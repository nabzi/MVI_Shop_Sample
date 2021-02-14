package com.nabzi.mvi

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    /*
     This algorithm's time complexity is O(n), because converting
     a string to character array takes constant time and converting each
     character to integer and then converting calculated integer to character both
     take constant time , multiplied by n.
     Ascii character set is limited in comparison with Utf8,
     so using ascii we can not does not support east language characters.
     */

    @Test
    fun shift() {
        var str = "abc"
        val n = 2
        val a = 'a'.toInt() // 'a' code
        val m = 26  //english alphabet length
        var v = 0
        for (c: Char in str) {
            v = c.toInt() + n%m
           if (v < m +  a )
               print(v.toChar())
            else
               print((v - m).toChar())
        }
    }
}