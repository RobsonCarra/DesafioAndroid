package br.com.alura.ceep.ui.desafioandroid.domain

import java.sql.Timestamp
import java.util.*

class User(
    var id: Long,
    var name: String,
    var doctor: String,
    var timestamp: Long,
    var heatly: Boolean
)