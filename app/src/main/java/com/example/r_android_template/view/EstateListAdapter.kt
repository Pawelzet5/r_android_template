package com.example.r_android_template.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.r_android_template.R
import com.example.r_android_template.databinding.ItemViewBinding
import com.example.r_android_template.service.Estate

class EstateListAdapter(private val estates: List<Estate>, private val onSelect: (Estate) -> Unit): RecyclerView.Adapter<EstateListAdapter.EstateViewHolder>() {
    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick()
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class EstateViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(currentEstate: Estate, onSelect: (Estate) -> Unit){
            binding.estate = currentEstate
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                onSelect(currentEstate)
            }
        }

        init{

        }
        companion object {
            fun from(parent: ViewGroup) : EstateViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                val binding: ItemViewBinding = DataBindingUtil.inflate(
                    layoutInflater, R.layout.item_view, parent, false)
                return EstateViewHolder(binding)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstateViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val EstateBinding = ItemViewBinding.inflate(inflater,parent,false)
        return EstateViewHolder(EstateBinding)
    }

    override fun onBindViewHolder(holder: EstateViewHolder, position: Int) {
        holder.bind(estates[position], onSelect)

    }

        override fun getItemCount(): Int = estates.size


}