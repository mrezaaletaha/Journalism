package ir.miro.journalism

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.miro.journalism.data.NewsRepository
import javax.inject.Inject

/**
 * @author mrezaaletaha
 */

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    private val _data = MutableLiveData<String>()
    val data: LiveData<String> get() = _data

}