package com.nikevg.chebez.elephant.purchase

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nikevg.chebez.elephant.R
import com.nikevg.chebez.elephant.databinding.ActivityPurchaseBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PurchaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPurchaseBinding
    private val viewModel: PurchaseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_purchase)
        binding.lifecycleOwner = this

        //TODO 11: получить аргументы и использовать их
    }

    companion object {
        const val EXTRA_PHRASE = "extra_phrase"
        const val EXTRA_SHOULD_SPEAK = "extra_should_speak"
    }
}
