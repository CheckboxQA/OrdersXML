package com.example.ordersxml

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ordersxml.databinding.ItemOrdersBinding

class OrderAdapter():
    ListAdapter<OrderViewModel, OrderAdapter.OrderViewHolder>(OrderDiffCallback()) {

        inner class OrderViewHolder(private val binding: ItemOrdersBinding):RecyclerView.ViewHolder(binding.root){
            fun bind(order: OrderViewModel){
                binding.order = order
                binding.orderAddress.text = order.address
                binding.orderComment.text = order.comment
                binding.orderNumberDate.text = order.numberAndData
            }
        }
    class OrderDiffCallback :DiffUtil.ItemCallback<OrderViewModel>(){
        override fun areItemsTheSame(oldItem: OrderViewModel, newItem: OrderViewModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: OrderViewModel, newItem: OrderViewModel): Boolean {
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