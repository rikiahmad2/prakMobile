package com.riki.prakmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.riki.prakmobile.helper.Constant
import com.riki.prakmobile.helper.PreferencesHelper

class UserActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    lateinit var sharedpref: PreferencesHelper
    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        sharedpref = PreferencesHelper(this)

        postToList()
        //RecyclerView
        val rv: RecyclerView = findViewById(R.id.rv_recyclerView)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = RecyclerAdapter(this,titlesList, descList, imageList)

        //Sharedpreferences
        val textUsername = findViewById(R.id.textUsername) as TextView
        val bLogout: Button = findViewById(R.id.buttonLogout)

        textUsername.text = sharedpref.getString(Constant.PREF_USERNAME)

        bLogout.setOnClickListener {
            sharedpref.clear()
            Logout("Keluar Coyy !!")
            moveIntent()
        }
    }

    private fun addToList(title:String, description:String, image: Int){
        titlesList.add(title)
        descList.add(description)
        imageList.add(image)
    }

    private fun postToList(){
        addToList("Ayam Katsu", "Resep Ayam Katsu", R.drawable.ayam_katsu)
        addToList("Ayam Geprek", "Resep Ayam Geprek", R.drawable.ayam_geprek)
        addToList("Seblak Bandung", "Resep Seblak Bandung", R.drawable.seblak_bandung)
        addToList("Karedok", "Coming Soon", R.mipmap.ic_launcher)
        addToList("Burger Mie", "Coming Soon", R.mipmap.ic_launcher)
    }

    private fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun Logout(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}