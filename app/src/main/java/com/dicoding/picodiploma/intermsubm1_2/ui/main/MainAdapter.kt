package com.dicoding.picodiploma.intermsubm1_2.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.intermsubm1_2.R
import com.dicoding.picodiploma.intermsubm1_2.response.ListStoryItem
import com.dicoding.picodiploma.intermsubm1_2.ui.detail.DetailActivity

class MainAdapter(private val listUsers: List<ListStoryItem>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_main, viewGroup, false))


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        //tempat untuk mengambil data dari list dan menyimpannya ke dalam RV
        viewHolder.tvName.text = listUsers[position].name
        viewHolder.tvCreate.text = listUsers[position].createdAt
        Glide.with(viewHolder.img).load(listUsers[position].photoUrl).into(viewHolder.img)

        //nanti buat menuju detail
        viewHolder.itemView.setOnClickListener{
            val intentDetail = Intent(viewHolder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_users",listUsers[position].id)
            viewHolder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount() = listUsers.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //inisialisasi textview dan imageview
        val tvName: TextView = view.findViewById(R.id.tv_item_name)
        val tvCreate: TextView = view.findViewById(R.id.tv_created)
        val img: ImageView = view.findViewById(R.id.iv_item_photo)


    }


}