package com.example.frecycler

import android.os.Parcel
import android.os.Parcelable

data class myList(var titulo:String?, var descripcion:String?,var costo:String?,var obs:Boolean=true):Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<myList> {
        override fun createFromParcel(parcel: Parcel): myList {
            return myList(parcel)
        }

        override fun newArray(size: Int): Array<myList?> {
            return arrayOfNulls(size)
        }
    }
}
