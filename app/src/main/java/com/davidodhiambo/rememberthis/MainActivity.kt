package com.davidodhiambo.rememberthis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    // the main recyleview that will hold all the items to remember
    private lateinit var rvMainBoard: RecyclerView
    //this textview shows the number of moves made
    private lateinit var tvNumMoves: TextView
    // this textview showws the number of successful matches made
    private lateinit var tvNumFound: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize the views
        rvMainBoard = findViewById(R.id.rvMainBoard)
        tvNumMoves = findViewById(R.id.tvNumMoves)
        tvNumFound = findViewById(R.id.tvNumFound)

        //2 add the adapter to the recycler view

        rvMainBoard.adapter = MainBoardAdapter(this, 12)
        rvMainBoard.setHasFixedSize(true)

        //3 add data to recycler view  by adding cards . first  add the layour manager to the recycler view

        rvMainBoard.layoutManager = GridLayoutManager(this, 3)



        //4 add the item decorator to the recycler view

        //5 add the item touch helper to the recycler view

        //6 add the item animator to the recycler view

    }
}