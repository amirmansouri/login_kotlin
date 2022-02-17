package com.example.login_test


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth



class MainActivity : AppCompatActivity() {
    val mAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
var button = findViewById<Button>(R.id.button)

        button.setOnClickListener{
login()
        }

    }
    private fun login () {
        val emailTxt = findViewById<View>(R.id.emailTxt) as EditText
        var email = emailTxt.text.toString()
        val passwordTxt = findViewById<View>(R.id.passwordTxt) as EditText
        var password = passwordTxt.text.toString()

        if (!email.isEmpty() && !password.isEmpty()) {
            this.mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener ( this, OnCompleteListener<AuthResult> { task ->
                if (task.isSuccessful) {
               //     startActivity(Intent(this, Timeline::class.java))
                    Toast.makeText(this, "mrgla ", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "thabett", Toast.LENGTH_SHORT).show()
                }
            })

        }else {
            Toast.makeText(this, "8alet", Toast.LENGTH_SHORT).show()
        }
    }
}