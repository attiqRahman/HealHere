package com.example.HealHere

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.HealHere.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var sqlitehelper: SQLHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sqlitehelper = SQLHelper(this)

        initComponent()
    }

    private fun initComponent() {

        binding.content.btnBackToLogin.setOnClickListener {
            finish()
        }

        binding.content.cancelBtn.setOnClickListener {
            finish()
        }

        binding.content.signInBtn.setOnClickListener {
            val formValid = true

            //get data from input fields
            val userNameOrEmail = binding.content.fieldUsername.text.toString()
            val password = binding.content.fieldPassword.text.toString()

            if (userNameOrEmail.length > 0 && password.length > 0) {
                val user = UserModel(
                    name = userNameOrEmail,
                    passwprd = password
                )

                val status = sqlitehelper.insertUser(user)
                if (status > -1) {
                    Toast.makeText(this, "Logged In", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@SignInActivity, MainActivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "Please fill all the fields ", Toast.LENGTH_SHORT).show()
            }
        }

    }

}