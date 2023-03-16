package com.example.smaplesocketcrypto.presention

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.smaplesocketcrypto.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val newsViewModel: MinViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newsViewModel.getStartSocket()
        txt_name_crypto.text = newsViewModel.symbol
        txt_last_price.text = newsViewModel.lastPrice
        txt_change_price.text = newsViewModel.changePriceList
    }
}