package com.respApi.retro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.respApi.retro.api.ApiService
import com.respApi.retro.api.MainModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showData()
    }

    private fun showData(){
        val showData = findViewById<RecyclerView>(R.id.viewList)
ApiService.endpoint.getData().enqueue(object : Callback<MainModel> {
    override fun onResponse(call: Call<MainModel>, response: Response<MainModel>) {
        val data = response.body()
        val dataMorty = data?.results
        val adapterRecyc = MainAdapter(dataMorty)

        showData.apply {

            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapterRecyc.notifyDataSetChanged()
            adapter = adapterRecyc
        }
    }

    override fun onFailure(call: Call<MainModel>, t: Throwable) {
        TODO("Not yet implemented")
    }
})

    }
}