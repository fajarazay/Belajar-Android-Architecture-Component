package comfajarazay.github.suratquran.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import comfajarazay.github.suratquran.R
import comfajarazay.github.suratquran.adapters.MainAdapter
import comfajarazay.github.suratquran.databinding.ActivityMainBinding
import comfajarazay.github.suratquran.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.main = viewModel

        setupRecyclerView()
        observeLiveData()
        viewModel.getSurat()
        swipeRefresh.setOnRefreshListener {
            viewModel.getSurat()
        }
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView.layoutManager = layoutManager
        adapter = MainAdapter(this)
        binding.mainRecyclerView.adapter = adapter
    }

    private fun observeLiveData() {
        viewModel.surat.observe(this, Observer {
            adapter.setData(it.hasil)
            adapter.notifyDataSetChanged()
            swipeRefresh.isRefreshing = false
        })
        viewModel.error.observe(this, Observer {
            //handle error
            toast(it.message.toString())
            swipeRefresh.isRefreshing = false
        })
    }
}
