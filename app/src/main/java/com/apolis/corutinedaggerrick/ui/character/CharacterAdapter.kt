package com.apolis.corutinedaggerrick.ui.character

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apolis.corutinedaggerrick.data.models.Character
import com.apolis.corutinedaggerrick.databinding.RowAdapterCharacterBinding
import java.util.*
import kotlin.collections.ArrayList

class CharacterAdapter(var mContext: Context, var mList:ArrayList<Character> = ArrayList()):RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {

    inner class MyViewHolder(val mBinding:RowAdapterCharacterBinding):RecyclerView.ViewHolder(mBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater=LayoutInflater.from(mContext)
        val mBinding=RowAdapterCharacterBinding.inflate(layoutInflater)
        return MyViewHolder(mBinding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var character=mList[position]
        holder.mBinding.character=character
        holder.mBinding.executePendingBindings()
    }
    fun setData(characterList:ArrayList<Character>){
        mList=characterList
        notifyDataSetChanged()
    }

}