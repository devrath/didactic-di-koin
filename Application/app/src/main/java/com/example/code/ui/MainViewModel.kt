package com.example.code

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.code.model.Photo
import com.example.code.network.NASAAPIInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

interface MainView {
  fun setDailyPhoto(dailyPhoto: Photo)
}

class MainViewModel : ViewModel(), KoinComponent {
  val nasaAPIInterface: NASAAPIInterface by inject()
  var view: MainView? = null

  fun getDailyPhoto() {
    viewModelScope.launch(Dispatchers.IO) {
      val dailyPhoto = nasaAPIInterface.getDailyPhoto()
      withContext(Dispatchers.Main) {
        view?.setDailyPhoto(dailyPhoto)
      }
    }
  }
}