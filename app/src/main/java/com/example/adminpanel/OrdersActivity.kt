package com.example.adminpanel

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminpanel.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class OrdersActivity : AppCompatActivity() {

    private lateinit var ordersRecyclerView: RecyclerView
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var fabTimer: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)


        ordersRecyclerView = findViewById(R.id.orders_recycler_view)
        bottomNavigationView = findViewById(R.id.bottom_navigation_bar)
        fabTimer = findViewById(R.id.fab_timer)


        findViewById<ImageView>(R.id.menu_button).setOnClickListener {
            Toast.makeText(this, "Menu button clicked", Toast.LENGTH_SHORT).show()

        }
        findViewById<ImageView>(R.id.notification_icon).setOnClickListener {
            Toast.makeText(this, "Notifications clicked", Toast.LENGTH_SHORT).show()

        }
        findViewById<ImageView>(R.id.profile_icon).setOnClickListener {
            Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()

        }
        findViewById<ImageView>(R.id.filter_icon).setOnClickListener {
            Toast.makeText(this, "Filter orders clicked", Toast.LENGTH_SHORT).show()

        }


        fabTimer.setOnClickListener {
            Toast.makeText(this, "Timer button clicked!", Toast.LENGTH_SHORT).show()

        }


        ordersRecyclerView.layoutManager = LinearLayoutManager(this)
        val orders = getSampleOrders()
        val adapter = OrdersAdapter(orders) { order ->

            Toast.makeText(this, "Order for ${order.restaurantName} clicked!", Toast.LENGTH_SHORT).show()

        }
        ordersRecyclerView.adapter = adapter

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_dashboard -> {
                    Toast.makeText(this, "Dashboard clicked", Toast.LENGTH_SHORT).show()

                    true
                }
                R.id.navigation_orders -> {
                    Toast.makeText(this, "Orders clicked", Toast.LENGTH_SHORT).show()

                    true
                }
                R.id.navigation_payments -> {
                    Toast.makeText(this, "Payments clicked", Toast.LENGTH_SHORT).show()

                    true
                }
                R.id.navigation_analytics -> {
                    Toast.makeText(this, "Analytics clicked", Toast.LENGTH_SHORT).show()

                    true
                }
                else -> false
            }
        }


        bottomNavigationView.selectedItemId = R.id.navigation_orders
    }

    data class Order(
        val restaurantName: String,
        val orderNumber: String,
        val description: String,
        val price: String,
        val status: OrderStatus,
        val time: String,
        val deliveryPerson: String
    )


    enum class OrderStatus {
        DELIVERED, IN_TRANSIT, PREPARING
    }

    private fun getSampleOrders(): List<Order> {
        return listOf(
            Order("Pizza Palace", "#2024001", "Margherita Pizza x2", "$24.5", OrderStatus.DELIVERED, "2:30 PM", "Mike J."),
            Order("Burger House", "#2024002", "Classic Burger, Fries", "$18.75", OrderStatus.IN_TRANSIT, "3:15 PM", "Alex B."),
            Order("Sushi Express", "#2024003", "California Roll", "$32", OrderStatus.PREPARING, "3:45 PM", "Emma D."),
            Order("Taco Bell", "#2024004", "Crunchy Taco x3, Nachos", "$19.25", OrderStatus.DELIVERED, "4:10 PM", "Tom S.")
        )
    }


    class OrdersAdapter(private val orders: List<Order>, private val onItemClick: (Order) -> Unit) :
        RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order_card, parent, false)
            return OrderViewHolder(view)
        }

        override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
            val order = orders[position]
            holder.bind(order, onItemClick)
        }

        override fun getItemCount(): Int = orders.size

        class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val restaurantName: TextView = itemView.findViewById(R.id.restaurant_name)
            private val orderPrice: TextView = itemView.findViewById(R.id.order_price)
            private val orderNumber: TextView = itemView.findViewById(R.id.order_number)
            private val orderDescription: TextView = itemView.findViewById(R.id.order_description)
            private val statusDot: ImageView = itemView.findViewById(R.id.status_dot)
            private val orderStatus: TextView = itemView.findViewById(R.id.order_status)
            private val orderTime: TextView = itemView.findViewById(R.id.order_time)
            private val deliveryPersonName: TextView = itemView.findViewById(R.id.delivery_person_name)

            fun bind(order: Order, onItemClick: (Order) -> Unit) {
                restaurantName.text = order.restaurantName
                orderPrice.text = order.price
                orderNumber.text = order.orderNumber
                orderDescription.text = order.description
                orderTime.text = order.time
                deliveryPersonName.text = order.deliveryPerson

                when (order.status) {
                    OrderStatus.DELIVERED -> {
                        orderStatus.text = "Delivered"
                        orderStatus.setTextColor(Color.parseColor("#228B22"))
                        statusDot.setImageResource(R.drawable.status_delivered_dot)
                    }
                    OrderStatus.IN_TRANSIT -> {
                        orderStatus.text = "In-Transit"
                        orderStatus.setTextColor(Color.parseColor("#007BFF"))
                        statusDot.setImageResource(R.drawable.status_in_transit_dot)
                    }
                    OrderStatus.PREPARING -> {
                        orderStatus.text = "Preparing"
                        orderStatus.setTextColor(Color.parseColor("#FFA500"))
                        statusDot.setImageResource(R.drawable.status_preparing_dot)
                    }
                }

                itemView.setOnClickListener { onItemClick(order) }
            }
        }
    }
}
