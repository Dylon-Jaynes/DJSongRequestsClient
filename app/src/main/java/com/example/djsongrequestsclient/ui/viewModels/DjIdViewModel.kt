package com.example.djsongrequestsclient.ui.viewModels

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.djsongrequestsclient.data.repositories.FirebaseRepo
import com.example.djsongrequestsclient.utils.Event
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.database.DataSnapshot
import java.lang.Exception
import java.lang.IllegalArgumentException

class DjIdViewModel: ViewModel() {

    private val firebaseRepo = FirebaseRepo()

    private val _dbResponseError = MutableLiveData<String>()
    val dbResponseError: LiveData<String>
        get() = _dbResponseError

    private val _navigateToSongRequestFragment = MutableLiveData<Event<Boolean>>()
    val navigateToSongRequestFragment: LiveData<Event<Boolean>>
        get() = _navigateToSongRequestFragment

    fun findDjById(id: String) {
        try {
            val taskResult = firebaseRepo.getDjById(id)
            getStatusMessage(taskResult)

        } catch (e: Exception) {
            _dbResponseError.value = "There are no DJ's in our system with the specified Id. Please enter a valid DJ-Id and try again."
        }
    }

    private fun getStatusMessage(result: Task<DataSnapshot>) {
        result.addOnCompleteListener { result ->
            if (result.isSuccessful) {
                // Success getting the DJ-Id
                Log.d(ContentValues.TAG, "Get DJ-Id: Success")
                _navigateToSongRequestFragment.value = Event(true)
            } else {
                // Failed to get the DJ-Id
                Log.w(ContentValues.TAG, "Get DJ-Id: Failure")
                _dbResponseError.value = "There are no DJ's in our system with the specified Id. Please enter a valid DJ-Id and try again."
            }
        }
    }
}