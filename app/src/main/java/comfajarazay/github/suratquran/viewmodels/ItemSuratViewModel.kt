package comfajarazay.github.suratquran.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import comfajarazay.github.suratquran.models.Hasil

/**
 * Created by Fajar Septian on 2019-01-27.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */
class ItemSuratViewModel(model: Hasil) : ViewModel() {
    var namaSurat: ObservableField<String> = ObservableField()
    var namaSuratArab: ObservableField<String> = ObservableField()

    init {
        namaSurat.set(model.nama)
        namaSuratArab.set(model.asma)
    }
}