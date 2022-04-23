package com.example.frecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.frecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var layout:ActivityMainBinding
    var presentacion:Boolean=false
    lateinit var listado:ArrayList<myList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layout = ActivityMainBinding.inflate(layoutInflater)
        setContentView(layout.root)

        val list = layout.lista
        listado = ArrayList()

        if(savedInstanceState ==null){

            list.layoutManager = LinearLayoutManager(this)
            listado.add(myList("Backend Full Stack PHP", "Programación de PHP con MariaDB", "$ 70.00"))
            listado.add(myList("Android Developer con Kotlin","Creación de Apps en Android","$ 48.00"))
            listado.add(myList("Modelado e Impresión 3D","Modelado de Objetos con Blender","$ 30.00",false))

        }else{
            presentacion= savedInstanceState.get("presentacion") as Boolean

            if(presentacion) {
                list.layoutManager = GridLayoutManager(this, 2)
            }else{
                list.layoutManager = LinearLayoutManager(this)
            }

            listado.addAll(savedInstanceState.getParcelableArrayList("listaRecycler")!!)
        }


        val myAdapter = myAdapterRecycler(listado)

        list.adapter = myAdapter

        layout.add.setOnClickListener {

            listado.add(myList("Programación Javascript",
                "Programación javascript de 0 a Experto",
                "$ 32.00",
                false))
            myAdapter.notifyDataSetChanged()

            Log.i("result", listado.toString())
        }

        layout.delete.setOnClickListener {
            listado.removeAt(1)
            myAdapter.notifyDataSetChanged()
        }

        layout.change.setOnClickListener {
            if(presentacion==false) {
                list.layoutManager=GridLayoutManager(this,2)
                presentacion=true
            }else{
                list.layoutManager = LinearLayoutManager(this)
                presentacion=false
            }
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {

        super.onSaveInstanceState(outState)

        outState.putParcelableArrayList("listaRecycler",listado)
        outState.putBoolean("presentacion",presentacion)

    }
}