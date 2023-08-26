package com.example.loveapicalculator.presentor

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.loveapicalculator.model.LoveModel
import com.example.loveapicalculator.model.RetrofitService
import com.example.loveapicalculator.view.HomeView
import retrofit2.Call
import retrofit2.Response

class HomePresenter(val homeView: HomeView) {
    fun getLoveResult(firstName: String, secondName: String) {
        RetrofitService().api?.getPercentage(
            firstName, secondName
        )?.enqueue(object : retrofit2.Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
              response.body()?.let { model ->
                 homeView.navigationComponent(model)
                  }
              }
            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}")
                homeView.showError(t.message.toString())
            }
        })
    }
}