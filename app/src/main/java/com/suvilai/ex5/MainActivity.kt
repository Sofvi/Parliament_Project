package com.suvilai.ex5

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.suvilai.ex5.adapter.ItemAdapter
import com.suvilai.ex5.data.Datasource
import java.lang.ProcessBuilder.Redirect.to

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        val myDataset = Datasource().member()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        recyclerView.setHasFixedSize(true)

         */

    }


    /*
    private fun replaceFragment(fragment: Fragment) {
        val action = supportFragmentManager.beginTransaction()
        action.replace(R.id.recycler_view, fragment)
        action.commit()
    }

     */

}