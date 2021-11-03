package br.com.alura.ceep.ui.desafioandroid.presentation

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.ceep.ui.coffemachine.exceptions.BadGatewayException
import br.com.alura.ceep.ui.coffemachine.exceptions.BadRequestException
import br.com.alura.ceep.ui.coffemachine.exceptions.NoContentException
import br.com.alura.ceep.ui.coffemachine.exceptions.NotFoundException
import br.com.alura.ceep.ui.desafioandroid.R
import br.com.alura.ceep.ui.desafioandroid.viewmodel.config.ViewModelFactory
import br.com.alura.ceep.ui.desafioandroid.presentation.custom.Adapter
import br.com.alura.ceep.ui.desafioandroid.helpers.RetrofitConfig
import br.com.alura.ceep.ui.desafioandroid.repository.Repository
import br.com.alura.ceep.ui.desafioandroid.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var Adapter: Adapter

    private val viewModel: UserViewModel by viewModels {
        ViewModelFactory(
            Repository(
                RetrofitConfig().getClient()
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
        observers()
        viewModel.getAll()
    }


    fun observers() {
        viewModel.list.observe(this) { coffee ->
            recyclerView.visibility = View.VISIBLE
            Adapter.list.clear()
            Adapter.list.addAll(coffee)
            Adapter.notifyDataSetChanged()
            progressBar.visibility = View.GONE
        }
        viewModel.error.observe(this) { exception ->
            when (exception) {
                is NoContentException -> {
                    recyclerView.visibility = View.GONE
                    progressBar.visibility = View.GONE
                }
                is BadRequestException -> Toast.makeText(
                    this,
                    exception.message,
                    Toast.LENGTH_SHORT
                ).show()
                is NotFoundException -> Toast.makeText(
                    this,
                    exception.message,
                    Toast.LENGTH_SHORT
                ).show()
                is BadGatewayException -> Toast.makeText(
                    this,
                    exception.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun setup() {
        recyclerView = findViewById(R.id.recycler)
        progressBar = findViewById(R.id.progress_bar)
    }
}