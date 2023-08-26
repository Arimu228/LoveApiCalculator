package com.example.loveapicalculator.view

import android.os.Bundle
import com.example.loveapicalculator.model.LoveModel

interface HomeView {
    fun navigationComponent(loveModel: LoveModel)
    fun showError(error:String)
}