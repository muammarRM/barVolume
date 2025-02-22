package com.dicoding.barvolume

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.barvolume.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
//    private lateinit var edtWidth: EditText
//    private lateinit var edtHeight: EditText
//    private lateinit var edtLength: EditText
//    private lateinit var btnCalculate: Button
//    private lateinit var tvResult: TextView
    companion object {
        private const val STATE_RESULT = "state_result"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        edtWidth = findViewById(R.id.edt_width)
//        edtHeight = findViewById(R.id.edt_height)
//        edtLength = findViewById(R.id.edt_length)
//        btnCalculate = findViewById(R.id.btn_calculate)
//        tvResult = findViewById(R.id.tv_result)
//        btnCalculate.setOnClickListener(this)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            binding.tvResult.text = result
        }
    }
    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_calculate) {
            val inputLength = binding.edtLength.text.toString().trim()
            val inputWidth = binding.edtWidth.text.toString().trim()
            val inputHeight = binding.edtHeight.text.toString().trim()
            var isEmptyField = false

            if (inputLength.isEmpty()) {
                isEmptyField = true
                binding.edtLength.error = "Field ini tidak boleh kosong"
            }
            if (inputWidth.isEmpty()) {
                isEmptyField = true
                binding.edtWidth.error = "Field ini tidak boleh kosong"
            }
            if (inputHeight.isEmpty()) {
                isEmptyField = true
                binding.edtHeight.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyField) {
                val volume = inputLength.toDouble() * inputHeight.toDouble() * inputWidth.toDouble()
                binding.tvResult.text = volume.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, binding.tvResult.text.toString())
    }
}