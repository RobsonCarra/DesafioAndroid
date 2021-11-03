package br.com.alura.ceep.ui.desafioandroid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.alura.ceep.ui.desafioandroid.repository.Repository
import br.com.alura.ceep.ui.desafioandroid.viewmodel.UserViewModel

class ViewModelFactory(
    private val repository: Repository,
//    private val auth: FirebaseAuth,
//    private val sharedPref: SharedPref
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}