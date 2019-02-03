package comfajarazay.github.suratquran.network

import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Fajar Septian on 2019-01-27.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */
abstract class ApiObserver<T> constructor(private val compositeDisposable: CompositeDisposable) : Observer<T> {
    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
        compositeDisposable.add(d)
    }

    override fun onNext(t: T) {
        onApiSuccess(t)
    }

    override fun onError(e: Throwable) {
        onApiError(e)
    }

    abstract fun onApiSuccess(data: T)
    abstract fun onApiError(er: Throwable)
}