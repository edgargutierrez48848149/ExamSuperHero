package com.gentera.yastas.sdk.myapplication.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gentera.yastas.sdk.myapplication.core.VhAdapter
import com.gentera.yastas.sdk.myapplication.data.models.DtoSuperHero
import com.gentera.yastas.sdk.myapplication.databinding.ItemSuperHeroBinding

class RvListSuperHero(
    private val listSuperHero: MutableList<DtoSuperHero>,
    private val eventOnClick: OnClick
) : RecyclerView.Adapter<VhAdapter<*>>() {

    interface OnClick {
        fun onClick(dtoSuperHero: DtoSuperHero)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VhAdapter<*> {
        val itemBinding = ItemSuperHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val itemholder = ViewHolder(itemBinding,parent.context)
        itemBinding.root.setOnClickListener {
            val position = itemholder.absoluteAdapterPosition.takeIf {
                it != DiffUtil.DiffResult.NO_POSITION
            } ?: return@setOnClickListener
            eventOnClick.onClick(listSuperHero[position])
        }
        return itemholder
    }

    override fun onBindViewHolder(holder: VhAdapter<*>, position: Int) {
        when (holder) {
            is ViewHolder -> holder.bind(listSuperHero[position])
        }
    }

    override fun getItemCount(): Int = listSuperHero.size

    private inner class ViewHolder(
        private val binding: ItemSuperHeroBinding,
        private val context: Context
    ) : VhAdapter<DtoSuperHero>(binding.root) {
        override fun bind(view: DtoSuperHero) {
            Glide.with(context).load(view.image.url).skipMemoryCache(true).into(binding.ivPictureHeader)
            Glide.with(context).load(view.image.url).skipMemoryCache(true).into(binding.ivPictureCircle)
            binding.tvName.text = view.name
            binding.tvOcupation.text = view.id
        }
    }
}