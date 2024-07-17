package com.wsgd.sh.hackerthon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.NumberPicker
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.wsgd.sh.hackerthon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.yearText.setOnClickListener{
            yearSetting(binding.yearText)
        }
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
            yearText.setText(selectedCity)
            dialog.dismiss()
            dialog.cancel()
        }

        dialog.setView(mView)
        dialog.create()
        dialog.show()
    }
}