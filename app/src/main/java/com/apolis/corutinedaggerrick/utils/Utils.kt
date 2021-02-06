package com.apolis.corutinedaggerrick.utils

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.apolis.corutinedaggerrick.R
import com.squareup.picasso.Picasso

fun Context.toast(message:String){
    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
}
fun Context.d(message: String){
    Log.d("abc",message)
}

fun ProgressBar.show(){
    this.visibility= View.VISIBLE
}
fun ProgressBar.hide(){
    this.visibility= View.GONE
}
@BindingAdapter("bind:imageUrl")
fun setImageUrl(imageView: ImageView, url:String){
    Picasso
        .get()
        .load("${url}")
        .error(R.drawable.ic_launcher_foreground)
        .into(imageView)
}
@BindingAdapter("setAdapter")
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>){
    this.run {
        this.setHasFixedSize(true)
        this.adapter=adapter
    }
}