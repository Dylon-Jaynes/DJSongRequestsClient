package com.example.djsongrequestsclient.data.repositories

import android.content.ContentValues.TAG
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue

class FirebaseRepo {

    private lateinit var dbRef: DatabaseReference

    fun getDjById(id: String): Task<DataSnapshot> {
        // Reference to location "Users"
        dbRef = FirebaseDatabase.getInstance().getReference("Users")
        val snapshotResult = dbRef.child("users").child(id).get().addOnSuccessListener {
            Log.i("firebase", "Got value ${it.value}")
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }
        return snapshotResult
    }
}