package ir.miro.journalism.news.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ir.miro.journalism.data.News
import ir.miro.journalism.databinding.LayoutNewsItemDefaultBinding
import ir.miro.journalism.databinding.LayoutNewsItemFullBinding

/**
 * @author mrezaaletaha
 */

class NewsAdapter : ListAdapter<News, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == DEFAULT_VIEW) {
            val binding = LayoutNewsItemDefaultBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            DefaultViewHolder(binding)
        } else {
            val binding = LayoutNewsItemFullBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            FullViewHolder(binding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if ((position + 1) % 3 == 0) DEFAULT_VIEW
        else FULL_VIEW
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (holder is DefaultViewHolder) holder.bind(item)
        else if (holder is FullViewHolder) holder.bind(item)
    }

    inner class DefaultViewHolder(private val binding: LayoutNewsItemDefaultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.txtTitle.text = news.title
        }
    }

    inner class FullViewHolder(private val binding: LayoutNewsItemFullBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.txtTitle.text = news.title
        }
    }

    companion object {
        private const val DEFAULT_VIEW = 0
        private const val FULL_VIEW = 1


        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem == newItem
            }

        }
    }
}