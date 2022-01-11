package com.example.davaleba2jgufi12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    private lateinit var textView: EditText
    private lateinit var buttonChangePassword:Button
    private lateinit var buttonLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        init()
        registerListener()
        //textView.text = FirebaseAuth.getInstance().currentUser?.uid
    }
    private fun init(){
        textView = findViewById(R.id.textView)
        buttonChangePassword = findViewById(R.id.buttonChangePassword)
        buttonLogout = findViewById(R.id.buttonLogout)
    }
    private fun registerListener(){
        buttonChangePassword.setOnClickListener{
            startActivity(Intent(this, PasswordChangeActivity::class.java))
        }
        buttonLogout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}