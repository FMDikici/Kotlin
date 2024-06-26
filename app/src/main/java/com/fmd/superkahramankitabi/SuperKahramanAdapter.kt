package com.fmd.superkahramankitabi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fmd.superkahramankitabi.databinding.RecyclerRowBinding

class SuperKahramanAdapter(var superKahramanListesi:List<SuperKahraman>,var mContext: Context): RecyclerView.Adapter<SuperKahramanAdapter.SuperKahramanViewHolder>() {

    class SuperKahramanViewHolder(val binding:RecyclerRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperKahramanViewHolder {
        val binding=RecyclerRowBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return SuperKahramanViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return superKahramanListesi.size
    }

    override fun onBindViewHolder(holder: SuperKahramanViewHolder, position: Int) {

        holder.binding.textViewRecyclerView.text=superKahramanListesi[position].isim

        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context,TanitimAktivitesi::class.java)
            intent.putExtra("secilenKahraman",superKahramanListesi[position])
            holder.itemView.context.startActivity(intent)
        }
    }
}