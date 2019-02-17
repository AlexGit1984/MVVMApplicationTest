package me.mvvm.com.myapplication.data.database

/**
 * Created by Alexander Karpenko on 02.02.19.
 * java.karpenko@gmail.com
 */
data class Product(var price: String?) {


    fun requestPriceUpdates(mListener: (String) -> Unit) {


    }

    fun removeUpdates(mListener: (String) -> Unit) {

    }


}