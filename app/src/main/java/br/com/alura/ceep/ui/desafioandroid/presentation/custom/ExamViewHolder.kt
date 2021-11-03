package br.com.alura.ceep.ui.desafioandroid.presentation.custom

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.ceep.ui.desafioandroid.R
import br.com.alura.ceep.ui.desafioandroid.domain.Exam
import java.text.SimpleDateFormat
import java.time.*
import java.util.*

class ExamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var exameNames: TextView
    var data: TextView
    var doctorName: TextView
    var goodHealthy: ImageButton
    var badHealthy: ImageButton

    init {
        exameNames = itemView.findViewById(R.id.name_exames)
        doctorName = itemView.findViewById(R.id.name_doctor)
        data = itemView.findViewById(R.id.data)
        goodHealthy = itemView.findViewById(R.id.good_heatlhy_button)
        badHealthy = itemView.findViewById(R.id.bad_healthy_button)
    }

    fun bind(exam: Exam) {
        exameNames.text = exam.name
        doctorName.text = exam.doctor
        val sdf = SimpleDateFormat("dd/MM/yy")
        val netDate = Date(exam.timestamp)
        val date = sdf.format(netDate)
        data.text = date
        if (exam.healthy == true) {
            goodHealthy.visibility = View.VISIBLE
            badHealthy.visibility = View.GONE
        } else {
            goodHealthy.visibility = View.GONE
            badHealthy.visibility = View.VISIBLE
        }
    }
}