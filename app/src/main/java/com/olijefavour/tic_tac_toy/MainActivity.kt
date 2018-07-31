package com.olijefavour.tic_tac_toy

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.olijefavour.tic_tac_toy.R.id.button1
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun btnClick (view: View){
        var btn = view as Button

        var butId= 0

        when(btn.id){

            R.id.button1-> butId=1
            R.id.button2-> butId=2
            R.id.button3-> butId=3
            R.id.button4-> butId=4
            R.id.button5-> butId=5
            R.id.button6-> butId=6
            R.id.button7-> butId=7
            R.id.button8-> butId=8
            R.id.button9 -> butId=9
        }

//            Toast.makeText(this,butId.toString(),Toast.LENGTH_SHORT).show()



        playGame(butId,btn)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer=1

    private fun playGame(btnId:Int,btnSelected:Button) {

        if (activePlayer == 1){

            btnSelected.text="x"
            btnSelected.setBackgroundColor(Color.GREEN)
            player1.add(btnId)

            activePlayer=2  //free this to play with an actual player
             autoplay()
        }

        else {
            btnSelected.text="0"
            btnSelected.setBackgroundColor(Color.BLUE)
            player2.add(btnId)
            activePlayer=1

        }
            btnSelected.isEnabled=false

        checkWinner()
    }

    private fun autoplay() {
        var emptyCells = ArrayList<Int>()
        for (butId in 1..9) {
            if (!(player1.contains(butId) || player2.contains(butId))) {
                emptyCells.add(butId)

            }
        }

        val random = Random()
        if (winner != -1 && emptyCells.size <= 1 ) {
            emptyCells.clear()
            reset()
        } else {
            val randomNum = random.nextInt(emptyCells.size - 0) + 0
            var boxId = emptyCells[randomNum]


            var butSelected: Button?
            when (boxId) {
                1 -> butSelected = button1
                2 -> butSelected = button2
                3 -> butSelected = button3
                4 -> butSelected = button4
                5 -> butSelected = button5
                6 -> butSelected = button6
                7 -> butSelected = button7
                8 -> butSelected = button8
                9 -> butSelected = button9

                else -> {
                    reset()

                    butSelected = button1

                }
            }

            playGame(boxId, butSelected)
        }
    }
    var winner=-1
    private fun checkWinner() {
//        row 1
       if (player1.contains(1)&&player1.contains(2)&&player1.contains(3)){

           winner=1
       }
       if (player2.contains(1)&&player2.contains(2)&&player2.contains(3)){

           winner=2
       }//        row 2
       if (player1.contains(4)&&player1.contains(5)&&player1.contains(6)){

           winner=1
       }
       if (player2.contains(4)&&player2.contains(5)&&player2.contains(6)){

           winner=2
       }//        row 3
       if (player1.contains(7)&&player1.contains(8)&&player1.contains(9)){

           winner=1
       }
       if (player2.contains(7)&&player2.contains(8)&&player2.contains(9)){

           winner=2


       }

        //     col1
       if (player1.contains(1)&&player1.contains(4)&&player1.contains(7)){

           winner=1
       }
       if (player2.contains(1)&&player2.contains(4)&&player2.contains(7)){

           winner=2
       }//        col2
       if (player1.contains(2)&&player1.contains(5)&&player1.contains(8)){

           winner=1
       }
       if (player2.contains(2)&&player2.contains(5)&&player2.contains(8)){

           winner=2
       }
        //         col3
       if (player1.contains(3)&&player1.contains(6)&&player1.contains(9)){

           winner=1
       }
       if (player2.contains(3)&&player2.contains(6)&&player2.contains(9)){

           winner=2
       }

        //        Accross left to right
       if (player1.contains(1)&&player1.contains(5)&&player1.contains(9)){

           winner=1
       }
       if (player2.contains(1)&&player2.contains(5)&&player2.contains(8)){

           winner=2
       }
        //        Accross left to right
       if (player1.contains(3)&&player1.contains(5)&&player1.contains(7)){

           winner=1
       }
       if (player2.contains(3)&&player2.contains(5)&&player2.contains(7)){

           winner=2
       }

        if (winner !=-1){
           if (winner==1){

               Toast.makeText(this,"Player 1 Won!",Toast.LENGTH_SHORT).show()
               reset()
           }
            else{
               Toast.makeText(this,"Player 2 Won!",Toast.LENGTH_SHORT).show()
               reset()
           }
        }
    }


     fun reset(){
         winner=-1
         button1.setBackgroundColor(Color.WHITE)
         button1.text=""
         button1.isEnabled=true
         button2.setBackgroundColor(Color.WHITE)
         button2.text=""
         button2.isEnabled=true
         button3.setBackgroundColor(Color.WHITE)
         button3.text=""
         button3.isEnabled=true
         button4.setBackgroundColor(Color.WHITE)
         button4.text=""
         button4.isEnabled=true
         button5.setBackgroundColor(Color.WHITE)
         button5.text=""
         button5.isEnabled=true
         button6.setBackgroundColor(Color.WHITE)
         button6.text=""
         button6.isEnabled=true
         button7.setBackgroundColor(Color.WHITE)
         button7.text=""
         button7.isEnabled=true
         button8.setBackgroundColor(Color.WHITE)
         button8.text=""
         button8.isEnabled=true
         button9.setBackgroundColor(Color.WHITE)
         button9.text=""
         button9.isEnabled=true


         player1.clear()
         player2.clear()
     }
}
