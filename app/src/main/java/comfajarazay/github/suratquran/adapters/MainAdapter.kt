package comfajarazay.github.suratquran.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import comfajarazay.github.suratquran.R
import comfajarazay.github.suratquran.databinding.ItemSuratRowBinding
import comfajarazay.github.suratquran.models.Hasil
import comfajarazay.github.suratquran.viewmodels.ItemSuratViewModel

/**
 * Created by Fajar Septian on 2019-01-27.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */
class MainAdapter(val context: Context) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    protected var suratList: MutableList<Hasil> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemSuratRowBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_surat_row, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.d(MainAdapter::class.java.simpleName, "cek size: " + suratList.size)
        return suratList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(suratList[holder.adapterPosition])
    }


    fun setData(surat: MutableList<Hasil>) {
        this.suratList = surat
    }

    class ViewHolder(private val binding: ItemSuratRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Hasil) {
            val viewModel = ItemSuratViewModel(model)
            binding.itemSurat = viewModel
        }
    }
}