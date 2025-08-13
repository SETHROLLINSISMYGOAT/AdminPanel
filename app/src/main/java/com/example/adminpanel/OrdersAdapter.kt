package com.example.adminpanel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.adminpanel.R
import com.example.adminpanel.Order

class OrdersAdapter(private val orders: List<Order>) :
    RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>() {

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val restaurantName: TextView = itemView.findViewById(R.id.restaurant_name)
        val orderPrice: TextView = itemView.findViewById(R.id.order_price)
        val orderNumber: TextView = itemView.findViewById(R.id.order_number)
        val orderDetails: TextView = itemView.findViewById(R.id.order_details)
        val statusDot: View = itemView.findViewById(R.id.status_dot)
        val statusText: TextView = itemView.findViewById(R.id.status_text)
        val timeText: TextView = itemView.findViewById(R.id.time_text)
        val driverName: TextView = itemView.findViewById(R.id.driver_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]
        holder.restaurantName.text = order.restaurantName
        holder.orderPrice.text = order.price
        holder.orderNumber.text = order.orderNumber
        holder.orderDetails.text = order.orderDetails
        holder.statusText.text = order.status
        holder.timeText.text = order.time
        holder.driverName.text = order.driverName


        holder.statusDot.backgroundTintList = ContextCompat.getColorStateList(holder.itemView.context, order.statusColorRes)
    }

    override fun getItemCount() = orders.size
}