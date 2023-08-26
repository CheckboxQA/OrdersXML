package com.example.ordersxml

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ordersxml.databinding.ItemOrdersBinding

class OrderAdapter(private val itemClickListener: (Order) -> Unit):
    ListAdapter<Order, OrderAdapter.OrderViewHolder>(OrderDiffCallback()) {
        inner class OrderViewHolder(private val binding: ItemOrdersBinding):RecyclerView.ViewHolder(binding.root){
            fun bind(order: Order){
                binding.order = order
                binding.orderAddress.text = order.address
                binding.orderComment.text = order.comment
                binding.orderNumberDate.text = order.numberAndData
                binding.root.setOnClickListener {
                    itemClickListener.invoke(order)
                }
            }
        }
    class OrderDiffCallback :DiffUtil.ItemCallback<Order>(){
        override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = ItemOrdersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = getItem(position)
        holder.bind(order)
    }

}