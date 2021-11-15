package com.nikevg.chebez.elephant.main

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.nikevg.chebez.elephant.R
import com.nikevg.chebez.elephant.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        //TODO 5: поиск элемента через findViewById и setOnClick

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewEvents.collect { event ->
                when (event) {
                    is CheckMicPermissionEvent -> {
                       //TODO 10: обработать получение разрешений и запись
                    }
                    is MicPermissionDeniedErrorEvent -> {
                        viewModel.speak(getString(R.string.error_permission))
                    }
                    is NetworkErrorEvent -> {
                        viewModel.speak(getString(R.string.error_network))
                    }
                    is OpenPurchaseEvent -> {
                        //TODO 9: запуск PurchaseActivity
                    }
                    is ShowElephantsEvent -> {
                        //TODO 6: поиск элемента через findViewById
                    }
                    is OpenPurchaseWithSpeakEvent -> {
                        //TODO 8: запуск PurchaseActivity
                    }
                    is UnknownErrorEvent -> {
                        viewModel.speak(getString(R.string.error_unknown))
                    }
                }
            }
        }

        //TODO 7: анимация седла

        return binding.root
    }

    private fun requestMicPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.RECORD_AUDIO
            ) == PackageManager.PERMISSION_GRANTED
        ) {
           //TODO 10.1: разрешения есть
        } else {
           //TODO 10.2: надо запросить разрешения
        }
    }
}
