package br.com.alura.ceep.ui.desafioandroid.domain

import java.sql.Timestamp
import java.util.*

class Exam(
    var id: Long,
    var name: String,
    var doctor: String,
    var timestamp: Long,
    var health: Boolean
)