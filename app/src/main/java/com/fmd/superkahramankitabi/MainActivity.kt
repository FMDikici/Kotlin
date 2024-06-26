package com.fmd.superkahramankitabi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.fmd.superkahramankitabi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var superKahramanListesi: ArrayList<SuperKahraman>
    private lateinit var adapter: SuperKahramanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.superKahramanRecyclerView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val superman=SuperKahraman("Superman","Gazeteci",R.drawable.superman)
        val batman=SuperKahraman("Batman","Patron",R.drawable.batman)
        val ironman=SuperKahraman("Ironman","Holding Sahibi",R.drawable.ironman)
        val aquaman=SuperKahraman("Aquaman","Kral",R.drawable.aquaman)

        superKahramanListesi = arrayListOf(superman,batman,ironman,aquaman)


        adapter=SuperKahramanAdapter(superKahramanListesi,this)

        binding.rv.layoutManager=LinearLayoutManager(this)
        binding.rv.adapter=adapter
    }
}