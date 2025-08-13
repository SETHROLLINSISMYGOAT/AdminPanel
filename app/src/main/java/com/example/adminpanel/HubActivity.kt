package com.example.adminpanel

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HubActivity : AppCompatActivity() {

    private lateinit var toolbarTitle: TextView
    private lateinit var accountOrFilterButton: ImageButton
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hub)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        toolbarTitle = findViewById(R.id.toolbar_title)
        accountOrFilterButton = findViewById(R.id.account_or_filter_button)
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)


        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_dashboard -> {
                    toolbarTitle.text = "DeliveryHub"
                    accountOrFilterButton.setImageResource(R.drawable.ic_account)

                    true
                }
                R.id.navigation_orders -> {
                    toolbarTitle.text = "Today's Orders"
                    accountOrFilterButton.setImageResource(R.drawable.ic_filter)
                    loadFragment(OrdersFragment())
                    true
                }
                R.id.navigation_payments -> {
                    toolbarTitle.text = "Payments"
                    accountOrFilterButton.setImageResource(R.drawable.ic_account)

                    true
                }
                R.id.navigation_analytics -> {
                    toolbarTitle.text = "Analytics"
                    accountOrFilterButton.setImageResource(R.drawable.ic_account)

                    true
                }
                else -> false
            }
        }


        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.navigation_dashboard
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}