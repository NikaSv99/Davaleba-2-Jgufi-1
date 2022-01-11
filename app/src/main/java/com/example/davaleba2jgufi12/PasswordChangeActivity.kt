package com.example.davaleba2jgufi12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {

    private lateinit var editTextNewPassword: EditText
    private lateinit var buttonUpdatePassword: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)

        init()
        registerListeners()
    }

    private fun init(){
        editTextNewPassword = findViewById(R.id.editTextNewPassword)
        buttonUpdatePassword = findViewById(R.id.buttonUpdatePassword)
    }

    private fun registerListeners(){
        buttonUpdatePassword.setOnClickListener {
            val newPassword = editTextNewPassword.text.toString()
            if(newPassword.isEmpty()){
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth
                .getInstance()
                .currentUser
                ?.updatePassword(newPassword)
                ?.addOnCompleteListener{task->
                    if(task.isSuccessful){
                        Toast.makeText(this, "Good :)", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Bad :((", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

}