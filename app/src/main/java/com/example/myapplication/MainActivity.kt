package com.example.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        editTextName = findViewById<View>(R.id.nameText) as EditText
        editTextPhone = findViewById<View>(R.id.phoneText) as EditText
        sharedPreferences = getSharedPreferences("MySharedPreMain", MODE_PRIVATE)

        if (sharedPreferences!!.contains(NAME_KEY)) {
            editTextName!!.setText(sharedPreferences!!.getString(NAME_KEY, ""))
        }
        if (sharedPreferences!!.contains(PHONE_KEY)) {
            editTextPhone!!.setText(sharedPreferences!!.getString(PHONE_KEY, ""))
        }
    }

    companion object {
        const val NAME_KEY = "NAME_KEY"
        const val PHONE_KEY = "PHONE_KEY"
    }
    private var editTextName: EditText? = null
    private var editTextPhone: EditText? = null
    private var sharedPreferences: SharedPreferences? = null

    fun save(v: View) {
        val editor = sharedPreferences!!.edit()
        editor.putString(NAME_KEY, editTextName!!.text.toString())
        editor.putString(PHONE_KEY, editTextPhone!!.text.toString())
        editor.commit()
        Toast.makeText(v.context, "data saved", Toast.LENGTH_SHORT).show()
    }
}