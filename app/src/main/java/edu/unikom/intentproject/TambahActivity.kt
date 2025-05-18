package edu.unikom.intentproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TambahActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnChosen: Button
    private lateinit var rgGender: RadioGroup
    companion object{
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)
        btnChosen = findViewById(R.id.btn_tambah_data)
        rgGender = findViewById(R.id.rg_gender)
        btnChosen.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_tambah_data) {
            if (rgGender.checkedRadioButtonId != 0) {
                var value = ""
                when (rgGender.checkedRadioButtonId) {
                    R.id.rb_laki_laki -> value = "Laki-laki"
                    R.id.rb_perempuan -> value = "Perempuan"
                }
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }

    }
}}