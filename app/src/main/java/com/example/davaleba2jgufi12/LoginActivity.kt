package com.example.davaleba2jgufi12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonRegister: Button
    private lateinit var buttonResetPassword: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
        registerlistener()

    }
    private fun init(){
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonResetPassword = findViewById(R.id.buttonResetPassword)

    }
    private fun registerlistener(){
        buttonRegister.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        buttonResetPassword.setOnClickListener{
            startActivity(Intent(this, PasswordResetActivity::class.java))
        }
        buttonLogin.setOnClickListener{
            val email = editTextEmail.text.toString()
            val password = editTextPassword.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener{task->
                    if(task.isSuccessful){
                        gotoProfile()
                    }else{
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                    }

                }
        }

    }
    private fun gotoProfile(){
        startActivity(Intent(this, ProfileActivity::class.java))
        finish()
    }

}