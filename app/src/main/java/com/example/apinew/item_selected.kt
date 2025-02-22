package com.example.apinew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide

/**
 * A simple [Fragment] subclass.
 */
class item_selected : Fragment() {

    private var head : String = ""
    private var body : String = ""
    private var img : String = ""

    fun newInstance(head: String,body: String,img: String): item_selected {

        val fragment = item_selected()
        val bundle = Bundle()
        bundle.putString("head", head)
        bundle.putString("body", body)
        bundle.putString("img", img)
        fragment.setArguments(bundle)

        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            head = bundle.getString("head").toString()
            body = bundle.getString("body").toString()
            img = bundle.getString("img").toString()

        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_item_selected, container, false)
        val imgVi : ImageView = view.findViewById(R.id.imgV)
        val headTxt : TextView = view.findViewById(R.id.tv_name)
        val bodyTxt : TextView = view.findViewById(R.id.tv_description)
        val button : Button = view.findViewById(R.id.btn_menu)

        button.setOnClickListener {
            val fragment_menu_game = menu_game()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.layout,fragment_menu_game,"fragment_menu_game")
            transaction.addToBackStack("fragment_menu_game")
            transaction.commit()
        }
        headTxt.setText(head)
        bodyTxt.setText(body)
        Glide.with(activity!!.baseContext)
            .load(img)
            .into(imgVi);
        // Inflate the layout for this fragment

        return view
    }


}
