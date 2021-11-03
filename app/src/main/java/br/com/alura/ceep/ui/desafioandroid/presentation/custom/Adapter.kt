package br.com.alura.ceep.ui.desafioandroid.presentation.custom

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.ceep.ui.desafioandroid.R
import br.com.alura.ceep.ui.desafioandroid.domain.Exam

class Adapter :
    RecyclerView.Adapter<ViewHolder>() {
    var list = ArrayList<Exam>()
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.item_detail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.count()
    }
}