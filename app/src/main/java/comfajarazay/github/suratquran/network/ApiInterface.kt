package comfajarazay.github.suratquran.network

import comfajarazay.github.suratquran.models.SuratResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Fajar Septian on 2019-01-27.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */
interface ApiInterface {
    @GET("quran/format/json/surat")
    fun getSurat(): Observable<SuratResponse>
}