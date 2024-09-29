package com.verdixi.basickotlin.models.data

//import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.ArrayList

// Only can use in Kotlin version 1.4.30^
@Parcelize
data class Person(
    val name: String,
    val age: Int,
    val married: Boolean,
    val profession: String,
    val hobbies: ArrayList<String>?
) : Parcelable

// Use this if not use id("kotlin-parcelize") plugin
//{
//    constructor(parcel: Parcel) : this(
//        parcel.readString().toString(),
//        parcel.readInt(),
//        parcel.readByte() != 0.toByte(),
//        parcel.readString().toString(),
//        parcel.createStringArrayList()
//    ) {
//    }
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(name)
//        parcel.writeInt(age)
//        parcel.writeByte(if (married) 1 else 0)
//        parcel.writeString(profession)
//        parcel.writeStringList(hobbies)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<Person> {
//        override fun createFromParcel(parcel: Parcel): Person {
//            return Person(parcel)
//        }
//
//        override fun newArray(size: Int): Array<Person?> {
//            return arrayOfNulls(size)
//        }
//    }
//}