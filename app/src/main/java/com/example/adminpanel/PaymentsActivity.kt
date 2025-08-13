package com.example.adminpanel



import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.adminpanel.R

class PaymentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payments)


        val fixPaymentCard: CardView = findViewById(R.id.fixPaymentCard)

        fixPaymentCard.setOnClickListener {

            val intent = Intent(this, FixPaymentIssuesActivity::class.java)

            startActivity(intent)
        }
        val releasePaymentCard: CardView = findViewById(R.id.releasePaymentCard)
        releasePaymentCard.setOnClickListener{
            val intent = Intent(this, ReleaseActivity::class.java)

            startActivity(intent)

        }


        // You would do the same for manualPaymentCard and releasePaymentCard
        // For example:
        // val manualPaymentCard: CardView = findViewById(R.id.manualPaymentCard)
        // manualPaymentCard.setOnClickListener {
        //     val manualPaymentIntent = Intent(this, ManualPaymentActivity::class.java)
        //     startActivity(manualPaymentIntent)
        // }
    }
}