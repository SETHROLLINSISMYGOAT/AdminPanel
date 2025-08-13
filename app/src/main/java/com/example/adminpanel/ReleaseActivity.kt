package com.example.adminpanel


import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ReleaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_release)


        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }

        val releaseButton1 = findViewById<Button>(R.id.release_button)
        val holdButton1 = findViewById<Button>(R.id.hold_button)

        releaseButton1.setOnClickListener {

            Toast.makeText(this, "Pizza Palace payment released!", Toast.LENGTH_SHORT).show()
        }

        holdButton1.setOnClickListener {

            Toast.makeText(this, "Pizza Palace payment held.", Toast.LENGTH_SHORT).show()
        }




        val paymentTitle1 = findViewById<TextView>(R.id.payment_title)
        val paymentSubtitle1 = findViewById<TextView>(R.id.payment_subtitle)
        val paymentDate1 = findViewById<TextView>(R.id.payment_date)
        val paymentAmount1 = findViewById<TextView>(R.id.payment_amount)
        val paymentStatus1 = findViewById<TextView>(R.id.payment_status)


        paymentTitle1.text = "Pizza Palace"
        paymentSubtitle1.text = "Restaurant"
        paymentDate1.text = "Due: 2024-08-05"
        paymentAmount1.text = "$450.75"
        paymentStatus1.text = "Pending"
    }
}