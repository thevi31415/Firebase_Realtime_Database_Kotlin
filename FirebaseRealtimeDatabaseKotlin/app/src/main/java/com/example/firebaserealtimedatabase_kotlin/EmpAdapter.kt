package com.example.firebaserealtimedatabase_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmpAdapter (
    private val emplist: ArrayList<EmployeModel>):RecyclerView.Adapter<EmpAdapter.ViewHolder>(){
    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpAdapter.ViewHolder {
       val itemview = LayoutInflater.from(parent.context)
           .inflate(R.layout.activity_item_list, parent, false)
     return ViewHolder(itemview, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val currentEmp = emplist[position]
        holder.tvName.text = currentEmp.name
    }

    override fun getItemCount(): Int {
       return emplist.size
    }
    class ViewHolder(itemview: View, clickListener: onItemClickListener): RecyclerView.ViewHolder(itemview){
         val  tvName: TextView = itemview.findViewById(R.id.txt)
        init{
            itemview.setOnClickListener {
              clickListener.onItemClick(adapterPosition)
            }
        }
    }


}

