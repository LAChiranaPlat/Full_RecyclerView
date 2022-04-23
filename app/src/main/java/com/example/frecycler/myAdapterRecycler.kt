package com.example.frecycler

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.getDrawable
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.frecycler.databinding.Items2Binding
import com.example.frecycler.databinding.ItemsBinding

class myAdapterRecycler (var itemList:ArrayList<myList>): RecyclerView.Adapter<myAdapterRecycler.contentViews>() {

    class contentViews(views: ItemsBinding):RecyclerView.ViewHolder(views.root) {

        var itemText:TextView
        val itemIcon:ImageView
        val itemCont:ConstraintLayout

        init {
            itemText=views.textView
            itemIcon=views.imageView
            itemCont=views.cont
        }

/*
        var itemTitulo:TextView
        val itemDescrip:TextView
        val itemCosto:TextView
        val itemIcon:ImageView
        val itemCont:ConstraintLayout

        init {
            itemTitulo=views.titulo
            itemCosto=views.costo
            itemIcon=views.icon
            itemDescrip=views.desc
            itemCont=views.contenedor

        }
*/
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): myAdapterRecycler.contentViews {

        val holderViews=ItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return contentViews(holderViews)

    }

    override fun onBindViewHolder(holder: myAdapterRecycler.contentViews, position: Int) {

        val items=itemList.get(position)

        holder.itemText.text=items.titulo

        if(items.obs==false)
            holder.itemIcon.setImageDrawable(getDrawable(holder.itemIcon.context,R.drawable.cancel))

        val context=holder.itemCont.context

        holder.itemCont.setOnClickListener {



        }

        /*
            holder.itemTitulo.text=items.titulo
            holder.itemDescrip.text=items.descripcion
            holder.itemCosto.text=items.costo
    */


    }

    override fun getItemCount()= itemList.size




}