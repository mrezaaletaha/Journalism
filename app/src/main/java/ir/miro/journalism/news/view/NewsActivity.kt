package ir.miro.journalism.news.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ir.miro.journalism.R
import ir.miro.journalism.data.News
import ir.miro.journalism.databinding.ActivityNewsBinding
import ir.miro.journalism.news.NewsViewModel

/**
 * @author mrezaaletaha
 */

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding
    private val adapter = NewsAdapter()
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
        setupObservers()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadNews()
    }

    private fun setupViews() {
        binding.recyclerNews.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerNews.addItemDecoration(
            DividerItemDecoration(
                this, LinearLayoutManager.VERTICAL
            )
        )
        binding.recyclerNews.adapter = adapter

        binding.swipe.setOnRefreshListener {
            viewModel.loadNews()
            binding.swipe.isRefreshing = false
        }
    }

    private fun setupObservers() {
        viewModel.isLoading.observe(this, loadingObserver)
        viewModel.news.observe(this, loadNewsObserver)
        viewModel.errorMessage.observe(this, errorMessageObserver)
    }

    private val loadingObserver = Observer<Boolean> {
        if (it) {
            binding.progress.visibility = View.VISIBLE
            binding.recyclerNews.visibility = View.GONE
        } else {
            binding.progress.visibility = View.GONE
            binding.recyclerNews.visibility = View.VISIBLE
        }
    }

    private val loadNewsObserver = Observer<List<News>> {
        adapter.submitList(it)
    }

    private val errorMessageObserver = Observer<String> {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }
}