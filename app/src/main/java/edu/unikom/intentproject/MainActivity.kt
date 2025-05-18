package edu.unikom.intentproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

 class MainActivity : AppCompatActivity(), View.OnClickListener {
     //minggu 18-05-2025
     //Rama Novaldy Pratama
     //10122156
     private lateinit var txtResultValue: TextView
     private val resultLauncher = registerForActivityResult(
         ActivityResultContracts.StartActivityForResult()
     ) { result ->
         if (result.resultCode == TambahActivity.RESULT_CODE && result.data != null) {
             val selectedValue =
                 result.data?.getStringExtra(TambahActivity.EXTRA_SELECTED_VALUE)
             txtResultValue.text = "Jenis Kelamin Anda Adalah : $selectedValue"
         }}
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         val btnPindah: Button = findViewById(R.id.btn_pindah)
         btnPindah.setOnClickListener(this)

         val btnPindahDenganData: Button = findViewById(R.id.btn_pindah_dengandata)
         btnPindahDenganData.setOnClickListener(this)
         val btnPindahDenganObjek: Button = findViewById(R.id.btn_pindah_denganobjek)
         btnPindahDenganObjek.setOnClickListener(this)
         val btnDial: Button = findViewById(R.id.btn_dial)
         btnDial.setOnClickListener(this)
         val btnOpenAnotherApps: Button = findViewById(R.id.btn_open_anotherapps)
         btnOpenAnotherApps.setOnClickListener(this)
         val btnForResult: Button = findViewById(R.id.btn_for_result)
         btnForResult.setOnClickListener(this)
         txtResultValue = findViewById(R.id.txt_result)

     }
     override fun onClick(v: View) {
         when (v.id) {
             R.id.btn_pindah -> {
                 val moveIntent = Intent(this@MainActivity, SecondActivity::class.java)
                 startActivity(moveIntent)
             }
             R.id.btn_pindah_dengandata -> {
                 val moveWithDataIntent = Intent(this@MainActivity, PindahDenganData::class.java)
                 moveWithDataIntent.putExtra(PindahDenganData.EXTRA_NAME, "Rama")
                 moveWithDataIntent.putExtra(PindahDenganData.EXTRA_AGE, 20)
                 startActivity(moveWithDataIntent)
             }
             R.id.btn_pindah_denganobjek -> {
                 val person = Person(
                     "Rama Novaldy Pratama",
                     20,
                     "Rama@gmail.com",
                     "Bandung"
                 )
                 val pindahDenganObject = Intent(this@MainActivity, PindahDenganObjek::class.java)
                 pindahDenganObject.putExtra(PindahDenganObjek.EXTRA_PERSON, person)
                 startActivity(pindahDenganObject)
             }
             R.id.btn_dial -> {
                 val phoneNumber = "089507426540"
                 val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                 startActivity(dialPhoneIntent)
             }
             R.id.btn_open_anotherapps -> {
                 val openAnotherApps = Intent(Intent.ACTION_MAIN)
                 openAnotherApps.setPackage("com.google.android.youtube")
                 startActivity(openAnotherApps)
             }
             R.id.btn_for_result -> {
                 val forResultIntent = Intent(this@MainActivity, TambahActivity::class.java)
                 //startActivity(ForResultIntent)
                 resultLauncher.launch(forResultIntent)
             }
         }
     }
 }
