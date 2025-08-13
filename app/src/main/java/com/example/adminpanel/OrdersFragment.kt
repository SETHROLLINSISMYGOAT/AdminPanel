package com.example.adminpanel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminpanel.OrdersAdapter
import com.example.adminpanel.Order

class OrdersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_orders, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.orders_recycler_view)


        val ordersList = listOf(
            Order("Pizza Palace", "$24.5", "#2024001", "Margherita Pizza x2", "Delivered", "2:30 PM", "Mike J.", R.color.green_delivered),
            Order("Burger House", "$18.75", "#2024002", "Classic Burger, Fries", "In-Transit", "3:15 PM", "Alex B.", R.color.blue_intransit),
            Order("Sushi Express", "$32", "#2024003", "California Roll", "Preparing", "3:45 PM", "Emma D.", R.color.yellow_preparing),
            Order("Taco Bell", "$19.25", "#2024004", "Crunchy Taco x3, Nachos", "Delivered", "4:10 PM", "Tom S.", R.color.green_delivered)
        )

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = OrdersAdapter(ordersList)

        return view
    }
}