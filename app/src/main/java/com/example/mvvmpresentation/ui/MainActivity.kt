package com.example.mvvmpresentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.mvvmpresentation.R
import com.example.mvvmpresentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnGuessAge.setOnClickListener{
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.getAge(binding.etName.text.toString())
//                updateUI()
                withContext(Dispatchers.Main){
                    updateUI()
                }
            }
        }
    }

    private fun updateUI(){
        binding.tvAge.text = getString(R.string.tvAge,viewModel.myAge)
        binding.tvName.text = getString(R.string.tvName,viewModel.myName)
        binding.tvCount.text = getString(R.string.tvCount,viewModel.myCount)
    }

    override fun onStart() {
        updateUI()
        super.onStart()
    }
}