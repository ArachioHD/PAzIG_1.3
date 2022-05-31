package com.example.pazig

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.lang.StringBuilder


class Calendar : AppCompatActivity() {

    private lateinit var database: DatabaseReference


    private lateinit var apid: String
    private lateinit var apdate: String
    private lateinit var apdescription: String
    private lateinit var aphumor: String
    private lateinit var apmedications: String
    private lateinit var app: Appointment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        //show
        val show = findViewById<Button>(R.id.showinfo)
        show.setOnClickListener {

            val uuid = FirebaseAuth.getInstance().currentUser!!.email
            val uid=uuid?.subSequence(0, 5).toString()
            database = FirebaseDatabase.getInstance().reference.child("appointments").child(uid)
            val postListener = object : ValueEventListener {
                @RequiresApi(Build.VERSION_CODES.N)
                @SuppressLint("SetTextI18n")
                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    val post: HashMap<String, Any?> = dataSnapshot.value as HashMap<String, Any?>

                    for (key in post){
                        var sb = StringBuilder()
                       val text = findViewById<TextView>(R.id.calendarshow)
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
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
                }
            }
            database.addValueEventListener(postListener)
        }

            //goback
            val back = findViewById<Button>(R.id.backCal)
            back.setOnClickListener {
                val goback = Intent(applicationContext, Appointments::class.java)
                startActivity(goback)
            }
        }

    }