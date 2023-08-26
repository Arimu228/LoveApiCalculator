package com.example.loveapicalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.loveapicalculator.R
import com.example.loveapicalculator.databinding.FragmentResultBinding
import com.example.loveapicalculator.model.LoveModel
import com.example.loveapicalculator.presentor.ResultPresenter
import com.example.loveapicalculator.view.ResultView


class ResultFragment : Fragment(), ResultView {
    private lateinit var binding: FragmentResultBinding
    private val resultPresenter = ResultPresenter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        receiveDataFromHomeFragment()
    }

    override fun showResult(
        loveModel: LoveModel
    ) {
        with(binding) {
            percent.text = loveModel.percentage
            edFirstName.text = loveModel.firstName
            edSecondName.text = loveModel.secondName
            advice.text = loveModel.result
        }
    }

    private fun receiveDataFromHomeFragment() {
        val result = arguments?.getSerializable("key") as LoveModel
        resultPresenter.receiveData(result)
    }


}