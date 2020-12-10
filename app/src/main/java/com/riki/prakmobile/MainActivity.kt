package com.riki.prakmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.riki.prakmobile.helper.Constant
import com.riki.prakmobile.helper.PreferencesHelper

class MainActivity : AppCompatActivity() {

    lateinit var sharedpref:PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedpref = PreferencesHelper(this)

        val sButton: Button = findViewById(R.id.submitButton)
        val eUser: EditText = findViewById(R.id.editUsername)
        val ePass: EditText = findViewById(R.id.editPassword)

        sButton.setOnClickListener {
            if (eUser.text.isNotEmpty() && ePass.text.isNotEmpty()) {
                saveSession(eUser.text.toString(), ePass.text.toString())
                showToast("Behasil Masuk Gan !!")
                moveIntent()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if(sharedpref.getBoolean(Constant.PREF_IS_LOGIN)){
            moveIntent()
        }
    }

    private fun moveIntent(){
        startActivity(Intent(this, UserActivity::class.java))
        finish()
    }

    private fun saveSession(username : String, password : String){
        sharedpref.putStr(Constant.PREF_USERNAME, username)
        sharedpref.putStr(Constant.PREF_PASSWORD, password)
        sharedpref.putBool(Constant.PREF_IS_LOGIN, true)
    }

    private fun showToast(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}