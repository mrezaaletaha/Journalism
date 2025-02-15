package ir.miro.journalism.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.miro.journalism.data.News
import ir.miro.journalism.data.NewsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author mrezaaletaha
 */

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    private val _news = MutableLiveData<List<News>>()
    val news: LiveData<List<News>> get() = _news

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun loadNews(){
        _isLoading.value = true
        viewModelScope.launch {
            _news.value = repository.getNewsStream()
            _isLoading.value = false
        }
    }

    fun refresh() {
        _isLoading.value = true
        viewModelScope.launch {
            repository.refresh()
            _isLoading.value = false
        }
    }
}