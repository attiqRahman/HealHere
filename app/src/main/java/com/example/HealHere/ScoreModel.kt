package com.example.HealHere



import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

data class ScoreModel (
    var id: Int = 0,
    var date: String ="",
    var score: String = "",


){
    companion object{
        fun getAutoId():Int{
            val random = Random()
            return random.nextInt(100)
        }
    }
}