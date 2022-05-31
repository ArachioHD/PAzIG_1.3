package com.example.pazig

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.lang.StringBuilder

class Doctor : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor)
/*
        val show = findViewById<Button>(R.id.showinfodoc1)
        show.setOnClickListener {


            val mail = findViewById<EditText>(R.id.app_user1)
            val dmail = mail.text.toString().trim()
            val uid = dmail?.subSequence(0, 5).toString()

            database = FirebaseDatabase.getInstance().reference.child("appointments")
            val postListener = object : ValueEventListener {
                @RequiresApi(Build.VERSION_CODES.N)
                @SuppressLint("SetTextI18n")
                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    val post: HashMap<String, Any?> = dataSnapshot.value as HashMap<String, Any?>

                    for (key in post){
                        var sb = StringBuilder()
                        val text = findViewById<TextView>(R.id.docshowpat1)
                        val x= post.keys.toString().trim()
                        val keyList = ArrayList(post.keys)
                        //val first=post.keys.first()
                        for( i in 0..(keyList.size-1)) {
                            val keys = keyList[i]
                            sb.append("AppointmentID: "+ dataSnapshot.child("$keys/appointmentID").value as String +"\n"
                                    + "Appointment date: " + dataSnapshot.child("$keys/appointmentdate").value as String+"\n"
                                    +"Appointment description: " + dataSnapshot.child("$keys/appointmentdescription").value as String+"\n"
                                    +"Humor: " + dataSnapshot.child("$keys/humor").value as String +"\n"
                                    +"Medications: "+ dataSnapshot.child("$keys/medications").value as String +"\n" +"\n")
                            text.text = "$sb"
                        }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Getting Post failed, log a message
                    Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
                }
            }
            database.addValueEventListener(postListener)
        }
        //goback
        val back = findViewById<Button>(R.id.backDoc1)
        back.setOnClickListener {
            val goback = Intent(applicationContext, MainActivity::class.java)

            startActivity(goback)

        }

*/

    }

}