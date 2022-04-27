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
import com.example.frecycler.databinding.ItemsBinding

class myAdapterRecycler(var itemList:ArrayList<myList>, var listener:OnItemClickListener): RecyclerView.Adapter<myAdapterRecycler.contentViews>() {

    private var listaBase:ArrayList<myList> = ArrayList()

    init{
        listaBase.addAll(itemList)
    }

    inner class contentViews(views: ItemsBinding):RecyclerView.ViewHolder(views.root), View.OnClickListener {

        var itemText:TextView
        val itemIcon:ImageView
        val itemCont:ConstraintLayout

        init {
            itemText=views.textView
            itemIcon=views.imageView
            itemCont=views.cont

            views.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            listener.onItemClick(adapterPosition)
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

    interface OnItemClickListener {
        fun onItemClick(position:Int)
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

        if(items.obs==false){
            holder.itemIcon.setImageDrawable(getDrawable(holder.itemIcon.context,R.drawable.cancel))
        }else{
            holder.itemIcon.setImageDrawable(getDrawable(holder.itemIcon.context,R.drawable.ok))
        }


        val context=holder.itemCont.context

        /*
            holder.itemTitulo.text=items.titulo
            holder.itemDescrip.text=items.descripcion
            holder.itemCosto.text=items.costo
    */


    }

    override fun getItemCount()= itemList.size

    fun filtrar(filtro:String)
    {


        if(filtro.isEmpty()){
            itemList.clear()
            itemList.addAll(listaBase)
        }else{

            var result:ArrayList<myList> = ArrayList()

            for(item in itemList){
                if(item.titulo?.lowercase()?.contains(filtro.lowercase())!!){
                    result.add(item)
                }
            }
            itemList.clear()
            itemList.addAll(result)

        }

        notifyDataSetChanged()

    }


}