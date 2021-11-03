package br.com.alura.ceep.ui.desafioandroid.presentation.custom

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.ceep.ui.desafioandroid.R
import br.com.alura.ceep.ui.desafioandroid.domain.Exam

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var exameNames: TextView
    var data: TextView
    var doctorName: TextView

    init {
        exameNames = itemView.findViewById(R.id.name_exames)
        doctorName = itemView.findViewById(R.id.name_doctor)
        data = itemView.findViewById(R.id.data)
    }

    fun bind(exam: Exam) {
        exameNames.text = exam.name
        doctorName.text = exam.doctor
        data.text = exam.timestamp.toString()
    }
}