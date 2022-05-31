package com.example.pazig

import android.annotation.SuppressLint

import android.content.ContentValues
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class PatientData : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    private lateinit var dname:TextView
    private lateinit var dlastName: TextView
    private lateinit var dage: TextView
    private lateinit var dhello: TextView

    private lateinit var ddname:String
    private lateinit var ddlastName: String
    private lateinit var ddage: String
    private lateinit var ddid: String

    private lateinit var sub: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_data)

        val i1 = intent
        val id = i1.getStringExtra("two")
        val uid = id.toString().trim()


        val show = findViewById<Button>(R.id.showData)
        show.setOnClickListener {

            sub = uid.subSequence(0, 5).toString()
            dhello = findViewById(R.id.helloData)

            database = FirebaseDatabase.getInstance().reference.child("patients")
            val postListener = object : ValueEventListener {
                @SuppressLint("SetTextI18n")
                override fun onDataChange(dataSnapshot: DataSnapshot) {


                    ddname = dataSnapshot.child("$sub/username").value as String
                    ddlastName = dataSnapshot.child("$sub/userlastname").value as String
                    ddage = dataSnapshot.child("$sub/userage").value as String


                    dname = findViewById(R.id.data_name)
                    dlastName = findViewById(R.id.data_lastname)
                    dage = findViewById(R.id.data_age)

                    dname.text=ddname
                    dlastName.text = ddlastName
                    dage.text = ddage
                    dhello.text = "hello $ddname"
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Getting Post failed, log a message
                    Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
                }

            }
            database.addValueEventListener(postListener)
        }
    //goback
    val back = findViewById<Button>(R.id.back_data)
    back.setOnClickListener {
        val goback = Intent(applicationContext, Patient::class.java)
        startActivity(goback)
    }
    }
}