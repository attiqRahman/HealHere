package com.example.HealHere

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.toSpannable
import androidx.navigation.ui.AppBarConfiguration
import com.example.HealHere.databinding.ActivityLoginBinding
import com.example.HealHere.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var sqlitehelper: SQLHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
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

        val contex = this
        binding.content.signUpBtn.setOnClickListener {

            //Note: get data from input fields from content_sign_up.xml
            val username = binding.content.fieldUsername.text.toString()
            val email = binding.content.fieldEmail.text.toString()
            val password = binding.content.fieldPassword.text.toString()
            val verificationCode = binding.content.fieldVerificationCode.text.toString()


            if (username.length > 0 && email.length > 0 && password.length > 0 && verificationCode.length > 0) {
                val user = UserModel(
                    name = username,
                    email = email,
                    passwprd = password,
                    code = verificationCode
                )
                val status = sqlitehelper.insertUser(user)
                if (status > -1) {
                    Toast.makeText(this, "User added", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "User creation failed ", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all the fields ", Toast.LENGTH_SHORT).show()
            }
            //check if user exists
        }
    }
}