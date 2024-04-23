package com.example.printent

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class actIntent3 : AppCompatActivity() {
    companion object {
        val dataHasil = "KirimDataHasil"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_act_intent3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val _btnKembali1 = findViewById<Button>(R.id.btnKembali1)
        _btnKembali1.setOnClickListener{
            val intent = Intent(this@actIntent3, MainActivity::class.java)
            startActivity(intent)
        }

        // Retrieve isiHasil from intent extras
        val hasilList = intent.getStringArrayListExtra(dataHasil)

        // Set up TextView to display hasilList
        val textView = findViewById<TextView>(R.id.getHistori)
        textView.text = hasilList?.joinToString(separator = ", ") ?: "No data"
    }
}