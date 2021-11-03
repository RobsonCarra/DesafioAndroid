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
import br.com.alura.ceep.ui.desafioandroid.helpers.RetrofitConfig
import br.com.alura.ceep.ui.desafioandroid.presentation.custom.ExamAdapter
import br.com.alura.ceep.ui.desafioandroid.repository.ExamRepository
import br.com.alura.ceep.ui.desafioandroid.viewmodel.ExamViewModel
import br.com.alura.ceep.ui.desafioandroid.viewmodel.config.ExamViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private var examAdapter: ExamAdapter = ExamAdapter()

    private val viewModel: ExamViewModel by viewModels {
        ExamViewModelFactory(
            ExamRepository(
                RetrofitConfig().getClient()
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
        viewModel.getAll()
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        observers()
    }


    fun observers() {
        viewModel.list.observe(this) { exams ->
            recyclerView.adapter = examAdapter
            recyclerView.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            examAdapter.list.clear()
            examAdapter.list.addAll(exams)
            examAdapter.notifyDataSetChanged()
        }
        viewModel.error.observe(this) { exception ->
            when (exception) {
                is NoContentException -> {
                    recyclerView.visibility = View.GONE
                    progressBar.visibility = View.VISIBLE
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