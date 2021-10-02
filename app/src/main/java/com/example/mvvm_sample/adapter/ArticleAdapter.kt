package com.example.mvvm_sample.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.mvvm_sample.R
import com.example.mvvm_sample.databinding.ListItemBinding
import com.example.mvvm_sample.response.PostResponse
import com.example.mvvm_sample.response.PostResponseItem
import com.example.mvvm_sample.viewmodel.SampleViewModel

class ArticleAdapter(private val context: Context, val viewModel: SampleViewModel): BaseAdapter() {

    init {
        viewModel.getData()
    }

    class ViewHolder(private val listItemBinding: ListItemBinding) {
        fun bind(item: PostResponseItem) {
            listItemBinding.item = item
            listItemBinding.executePendingBindings()
        }
    }

    override fun getCount(): Int {
        return viewModel.postResponse.value?.size ?: 0
    }

    override fun getItem(position: Int): PostResponseItem? {
        return viewModel.postResponse.value?.get(position)
    }

    override fun getItemId(position: Int): Long {
        return viewModel.postResponse.value?.get(position)?.id?.toLong() ?: 0L
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        lateinit var currentView: View
        val viewHolder: ViewHolder = convertView?.let {
            currentView = convertView
            currentView.tag as ViewHolder
        } ?: run {
            val inflater = LayoutInflater.from(context)
            val binding = ListItemBinding.inflate(inflater, parent,false)
            currentView = binding.root
            currentView.tag = ViewHolder(binding)
            currentView.tag as ViewHolder
        }
        viewHolder.bind(viewModel.postResponse.value!![position])

        return currentView
    }
}