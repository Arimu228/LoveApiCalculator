package com.example.loveapicalculator.presentor

import com.example.loveapicalculator.model.LoveModel
import com.example.loveapicalculator.view.ResultView

class ResultPresenter(private val resultView: ResultView) {
    fun receiveData(loveModel: LoveModel) {
        resultView.showResult(loveModel)
    }
}