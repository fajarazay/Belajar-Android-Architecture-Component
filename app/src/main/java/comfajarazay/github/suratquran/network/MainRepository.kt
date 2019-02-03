package comfajarazay.github.suratquran.network

import comfajarazay.github.suratquran.models.SuratResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Fajar Septian on 2019-01-27.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */
class MainRepository {
    private val apiService = ApiFactory.create()
    private val compositeDisposable = CompositeDisposable()

    fun requestSurat(onResult: (SuratResponse) -> Unit, onError: (Throwable) -> Unit) {

        apiService.getSurat()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<SuratResponse>(compositeDisposable) {
                override fun onApiSuccess(data: SuratResponse) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    fun onDestroy() {
        compositeDisposable.clear()
    }
}