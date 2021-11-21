package com.example.djsongrequestsclient.data.repositories

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.database.*

class FirebaseRepo {

    private lateinit var dbRef: DatabaseReference
    private lateinit var snapshot: Task<DataSnapshot>

    fun getDjById(id: String): Task<DataSnapshot> {
        // Reference to location "Users"
        dbRef = FirebaseDatabase.getInstance().getReference("Users")
        snapshot = dbRef.child("users").child(id).get().addOnSuccessListener {
            Log.i("firebase", "Got value ${it.value}")
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }

        return snapshot
    }
}