package com.example.printent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class actIntent2 : AppCompatActivity() {

    companion object {
        const val dataTerima = "GETDATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_act_intent2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val data = intent.getStringExtra(dataTerima)
        val _showData = findViewById<TextView>(R.id.showData)
        _showData.text = data?.toString()

        val _btnKembali1 = findViewById<Button>(R.id.btnKembali1)
        _btnKembali1.setOnClickListener{
            val intent = Intent(this@actIntent2, MainActivity::class.java)
            startActivity(intent)
        }

        val _btnKembali3 = findViewById<Button>(R.id.btnKembali3)
        _btnKembali3.setOnClickListener{
            val intent = Intent(this@actIntent2, actIntent3::class.java).apply {
                putExtra(actIntent3.dataHasil, MainActivity.isiHasil)
            }
            startActivity(intent)
        }

    }


}