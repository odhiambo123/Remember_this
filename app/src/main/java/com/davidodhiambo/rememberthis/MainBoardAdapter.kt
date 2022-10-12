package com.davidodhiambo.rememberthis

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min

//note the changes made in this file
class MainBoardAdapter(private val context: Context, private val numPieces: Int) : RecyclerView.Adapter<MainBoardAdapter.ViewHolder>()  {

    //create a companion object to hold the constants for the spacing between the cards
    companion object {
        const val MARGIN_SIZE = 10
        const val CARD_ELEVATION = 8f
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {//1 creates one view of the recycle view
        val cardWidth : Int = parent.width / 2 - (2 * MARGIN_SIZE) //2 get the width of the parent view
        val cardHeight : Int = parent.height / 4 - (2 * MARGIN_SIZE)//3 get the height of the parent view
        val cardSideLength : Int = min(cardWidth, cardHeight) //4 get the minimum of the two

        val view: View = LayoutInflater.from(context).inflate(R.layout.memory_card, parent, false)
        val layoutParams : ViewGroup.LayoutParams = view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = cardSideLength //5 set the width of the layout params
        layoutParams.height = cardSideLength //6 set the height of the layout params
        //set margins for the card
        (layoutParams as ViewGroup.MarginLayoutParams).setMargins(MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE)
        return ViewHolder(view)
    }

    override fun getItemCount() = numPieces //2 returns the number of items in the recycle view

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { //2 binds the data to the view
        holder.bind(position)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)
        fun bind(position: Int) {
            imageButton.setOnClickListener {
                Log.i("TAG", "Clicked on position $position")
            }

        }

    }

}
