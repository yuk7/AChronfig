package com.github.yuk7.chronfig.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.yuk7.chronfig.R
import com.github.yuk7.chronfig.databinding.FragmentMainBinding
import com.github.yuk7.chronfig.models.UserAgentModel

class MainFragment : Fragment(R.layout.fragment_main) {
    companion object {
        fun newInstance() = MainFragment()
    }
    private lateinit var binding: FragmentMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var controller: MainController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentMainBinding.bind(view)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner

        controller = MainController()
        binding.recyclerView.setController(controller)

        mainViewModel.add(UserAgentModel(0,"Default", "df"))
        mainViewModel.add(UserAgentModel(1,"Windows Phone", "wp"))
        mainViewModel.add(UserAgentModel(2,"iPhone", "ip"))
        mainViewModel.add(UserAgentModel(3,"Windows PC", "pc"))

        mainViewModel.list.observe(viewLifecycleOwner, Observer(controller::setData))

    }

}