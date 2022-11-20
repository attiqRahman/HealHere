package com.example.HealHere

import java.util.*

data class UserModel (
    var id: Int = getAutoId(),
    var name: String = "",
    var email: String = "",
    var passwprd: String = "",
    var code: String = ""

){
    companion object{
        fun getAutoId():Int{
            val random = Random()
            return random.nextInt(100)
        }
    }
}