package com.wsgd.sh.hackerthon

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.lifecycleScope
import coil.load
import com.wsgd.sh.hackerthon.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private var count = ""
    private var pow1 = 1.1
    private var pow2 = 2.2

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.yearText.setOnClickListener{
            yearSetting(binding.yearText)
        }

//        for (i in 1..10000000){
//            pow1.pow(pow2)
//        }

    }

    private fun yearSetting(yearText: AppCompatTextView) {
        val dialog = AlertDialog.Builder(this).create()
        val edialog : LayoutInflater = LayoutInflater.from(this)
        val mView : View = edialog.inflate(R.layout.year_dialog_view, null)

        val city : NumberPicker = mView.findViewById(R.id.cityPicker)
        val cancel : Button = mView.findViewById(R.id.cancelBtn)
        val save : Button = mView.findViewById(R.id.saveBtn)

        val cities = arrayOf("1950", "1960", "1970", "1980", "1990", "2000", "2010", "2020", "2030", "2040", "2050", "2060", "2070", "2080", "2090", "2100")
        city.minValue = 0
        city.maxValue = cities.size - 1
        city.displayedValues = cities

        cancel.setOnClickListener {
            dialog.dismiss()
            dialog.cancel()
        }

        save.setOnClickListener {
            val selectedCity = cities[city.value]
            count = selectedCity
            yearText.setText(selectedCity)
            a()
            dialog.dismiss()
            dialog.cancel()
        }

        dialog.setView(mView)
        dialog.create()
        dialog.show()
    }

    private fun a() {
        lifecycleScope.launch(Dispatchers.Main){
            Log.d(TAG, "onCreate: ${count}")
            kotlin.runCatching {
                when(count){
                    "1950" -> {
                        binding.imageView.load(R.drawable.earth)
                        binding.temperatureText.setText("0도 상승했어요")
                    }
                    "1960" -> {
                        binding.imageView.load(R.drawable.earth)
                        binding.temperatureText.setText("0.2도 상승했어요")
                    }
                    "1970" -> {
                        binding.imageView.load(R.drawable.earth)
                        binding.temperatureText.setText("0.4도 상승했어요")
                    }
                    "1980" -> {
                        binding.imageView.load(R.drawable.earth)
                        binding.temperatureText.setText("0.7도 상승했어요")
                    }
                    "1990" -> {
                        binding.imageView.load(R.drawable.drought)
                        binding.temperatureText.setText("1도 상승했어요")
                    }
                    "2000" -> {
                        binding.imageView.load(R.drawable.drought)
                        binding.temperatureText.setText("1.3도 상승했어요")
                    }
                    "2010" -> { binding.imageView.load(R.drawable.drought)
                        binding.temperatureText.setText("1.6도 상승했어요")
                    }
                    "2020" -> { binding.imageView.load(R.drawable.bear)
                        binding.temperatureText.setText("2도 상승했어요")
                    }
                    "2030" -> {
                        binding.imageView.load(R.drawable.bear)
                        binding.temperatureText.setText("2.4도 상승할거에요")
                    }
                    "2040" -> {
                        binding.imageView.load(R.drawable.bear)
                        binding.temperatureText.setText("2.9도 상승할거에요")
                    }
                    "2050" -> {
                        binding.imageView.load(R.drawable.glacier)
                        binding.temperatureText.setText("3.5도 상승할거에요")
                    }
                    "2060" -> {
                        binding.imageView.load(R.drawable.shortage)
                        binding.temperatureText.setText("4도 상승할거에요")
                    }
                    "2070" -> {
                        binding.imageView.load(R.drawable.shortage)
                        binding.temperatureText.setText("4.5도 상승할거에요")
                    }
                    "2080" -> {
                        binding.imageView.load(R.drawable.tsunami)
                        binding.temperatureText.setText("5도 상승할거에요")
                    }
                    "2090" -> {
                        binding.imageView.load(R.drawable.tsunami)
                        binding.temperatureText.setText("5.5도 상승할거에요")
                    }
                    "2100" -> {
                        binding.imageView.load(R.drawable.extinction)
                        binding.temperatureText.setText("6도 상승할거에요")
                    }
                }
                b(count)
            }
        }
    }


    private fun b(count: String) {
        var a = 0.0
        kotlin.runCatching {
            for(i in 1..10000000){
                a += pow1.pow(pow2)
            }
        }
    }
}