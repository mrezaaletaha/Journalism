package ir.miro.journalism.news

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import ir.miro.journalism.R
import ir.miro.journalism.data.News

/**
 * @author mrezaaletaha
 */

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupObservers()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadNews()
    }

    private fun setupObservers() {
        viewModel.isLoading.observe(this, loadingObserver)
        viewModel.news.observe(this, loadNewsObserver)
        viewModel.errorMessage.observe(this, errorMessageObserver)
    }

    private val loadingObserver = Observer<Boolean> {
        val message = if (it) "loading..." else "loading finished"
        Log.d("LOADING", message)
    }

    private val loadNewsObserver = Observer<List<News>> {
        Toast.makeText(this, "News loaded", Toast.LENGTH_SHORT).show()
        Log.d("News", it.toString())
    }

    private val errorMessageObserver = Observer<String> {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }
}