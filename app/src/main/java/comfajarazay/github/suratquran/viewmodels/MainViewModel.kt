package comfajarazay.github.suratquran.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import comfajarazay.github.suratquran.models.SuratResponse
import comfajarazay.github.suratquran.network.MainRepository

/**
 * Created by Fajar Septian on 2019-01-27.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MainRepository()
    var surat: MutableLiveData<SuratResponse> = MutableLiveData()
    var error: MutableLiveData<Throwable> = MutableLiveData()

    fun getSurat() {
        repository.requestSurat({
            surat.postValue(it)
        }, {
            error.postValue(it)
        })
    }

    override fun onCleared() {
        super.onCleared()
        repository.onDestroy()
    }
}