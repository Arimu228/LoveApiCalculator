package com.example.loveapicalculator.ui

import android.os.Bundle
import android.service.autofill.UserData
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.loveapicalculator.R
import com.example.loveapicalculator.databinding.FragmentHomeBinding
import com.example.loveapicalculator.model.LoveModel
import com.example.loveapicalculator.presentor.HomePresenter
import com.example.loveapicalculator.view.HomeView

class HomeFragment : Fragment(), HomeView {
    private lateinit var binding: FragmentHomeBinding
    private val presenter = HomePresenter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        initListener()
        return binding.root
    }

    private fun initListener() {
        with(binding) {
            calculate.setOnClickListener {
                presenter.getLoveResult(edFirstName.text.toString(), edSecondName.text.toString())
            }
        }
    }

    override fun navigationComponent(
        loveModel: LoveModel
    ) {
        findNavController().navigate(R.id.resultFragment, bundleOf("key" to loveModel))
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }


}