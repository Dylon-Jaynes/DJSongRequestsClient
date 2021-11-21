package com.example.djsongrequestsclient.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.djsongrequestsclient.data.repositories.FirebaseRepo
import com.example.djsongrequestsclient.utils.Event
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import java.lang.Exception
import java.lang.IllegalArgumentException

class DjIdViewModel: ViewModel() {

    private val firebaseRepo = FirebaseRepo()
    private val _dbResponseMessage = MutableLiveData<Event<String>>()
    val dbResponseMessage: LiveData<Event<String>>
        get() = _dbResponseMessage

    fun findDjById(id: String){
        try {
            firebaseRepo.getDjById(id)
        } catch (e: IllegalArgumentException) {
            _dbResponseMessage.value = Event("There are no Dj's in our system with the specified Id. Please enter a valid Dj-Id and try again.")
        }

    }
}