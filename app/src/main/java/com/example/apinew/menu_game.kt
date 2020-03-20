package com.example.apinew

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction

/**
 * A simple [Fragment] subclass.
 */
class menu_game : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        val btn1: Button = view.findViewById(R.id.btn_slot)
        val btn2: Button = view.findViewById(R.id.btn_dice)
        val btn3: Button = view.findViewById(R.id.btn_sudoku)
        val btn4: Button = view.findViewById(R.id.btn_Rottle)
        val btn5: Button = view.findViewById(R.id.btn_pie)
        btn1.setOnClickListener {
            var play1 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.freeslots.com/Slot503.htm"))
            startActivity(play1)
        }
        btn2.setOnClickListener {
            var play2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.online-stopwatch.com/chance-games/roll-a-dice/"))
            startActivity(play2)
        }
        btn3.setOnClickListener {
            var play3 = Intent(Intent.ACTION_VIEW, Uri.parse("https://sudoku.com/th"))
            startActivity(play3)
        }
        btn4.setOnClickListener {
            var play4 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.onlineroulette.org/free.php"))
            startActivity(play4)
        }
        btn5.setOnClickListener {
            val fragment_main_chart = MainChart()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.layout,fragment_main_chart,"fragment_pie_chart")
            transaction.addToBackStack("fragment_pie_chart")
            transaction.commit()
//            val MainChart = MainChart()
//            val manager = supportFragmentManager
//            val transaction = manager.beginTransaction()
//            transaction.replace(R.id.contentContainer, MainChart,"fragment_MainChart")
//            transaction.addToBackStack("fragment_MainChart")
//            transaction.commit()
////            var play4 = Intent(Intent.ACTION_VIEW, Uri.parse("https://sudoku.com/th"))
////            startActivity(play4)
        }
        return view
    }

}
