
package com.example.pazig

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class UploadData : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    private lateinit var name: EditText
    private lateinit var lastName: EditText
    private lateinit var age: EditText
    private lateinit var hello: TextView

    private lateinit var uname:String
    private lateinit var ulastName: String
    private lateinit var uage: String
    private lateinit var uid: String

    private lateinit var sub: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_data)
        database = Firebase.database.reference
        fun writeNewUser(userId: String, userName: String, userLastName: String, userAge: String) {
            val user = Users(userName, userLastName, userAge)
            database.child("patients").child(userId).setValue(user)
        }

        val ii1 = intent
        val iid = ii1.getStringExtra("uploadtwo")

        val saveData: Button = findViewById(R.id.save)
        saveData.setOnClickListener {
            name = findViewById(R.id.user_name)
            lastName = findViewById(R.id.user_lastname)
            age = findViewById(R.id.user_age)
            hello = findViewById(R.id.hello)

            uname = name.text.toString().trim()
            ulastName = lastName.text.toString().trim()
            uage = age.text.toString().trim()
            uid = iid.toString().trim()

            hello.text = "hello " + uname
            name.setText(uname)
            lastName.setText(ulastName)
            sub = uid.subSequence(0, 5).toString()
            age.setText(uage)
            writeNewUser(sub, uname, ulastName, uage)

        }
        //goback
        val back = findViewById<Button>(R.id.back)
        back.setOnClickListener {
            val goback = Intent(applicationContext, Patient::class.java)
            startActivity(goback)
        }

    }
}