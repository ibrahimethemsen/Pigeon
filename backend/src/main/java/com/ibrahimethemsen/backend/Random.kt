package com.ibrahimethemsen.backend

import java.util.Locale
import kotlin.random.Random

fun randomDouble() : Double{
    return Random.nextDouble(-2.0, 2.0)
}

fun Double.doubleFormat(formatSize : Int) : Double{
    return String.format(Locale("tr-TR"),"%.${formatSize}f", this).toDouble()
}