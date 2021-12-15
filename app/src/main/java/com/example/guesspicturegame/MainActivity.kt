package com.example.guesspicturegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guesspicturegame.models.BoardSize
import com.example.guesspicturegame.utils.DEFAULT_ICONS

class MainActivity : AppCompatActivity() {
    private lateinit var rVboard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPairs: TextView

    private var boardSize =BoardSize.HARD





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rVboard = findViewById(R.id.rV_board)
        tvNumMoves = findViewById(R.id.tv_NumMoves)
        tvNumPairs = findViewById(R.id.tV_NumPairs)

        val chosenImages = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        val randomisedImages = (chosenImages+chosenImages).shuffled()

        rVboard.adapter = MemoryBoardAdapter(this, boardSize, randomisedImages)
        rVboard.setHasFixedSize(true)
        rVboard.layoutManager = GridLayoutManager(this, boardSize.getWidth())
    }
}