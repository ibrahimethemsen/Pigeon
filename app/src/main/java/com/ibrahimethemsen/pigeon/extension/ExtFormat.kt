package com.ibrahimethemsen.pigeon.extension

import java.util.Locale

fun <T> List<T>.sumOfDouble(
    selector: (T) -> Double
): Double {
    return this.sumOf(selector).doubleFormat(2)
}

fun <T> List<T>.sumOfString(
    selector: (T) -> Double
): String {
    return this.sumOfDouble(selector).toString()
}

fun <T> List<T>.sumOfPrefix(
    selector: (T) -> Double
): String {
    return this.sumOfDouble(selector).changeToString()
}

fun Double.doubleFormat(formatSize: Int): Double {
    return String.format(Locale("tr-TR"), "%.${formatSize}f", this).toDouble()
}

fun Double.isIncreased() : Boolean{
    return this.toString().startsWith("-")
}

fun Double.changeToString(): String {
    return if (isIncreased()) {
        "-" + "₺" + this.toString().substring(1, this.toString().lastIndex)
    } else {
        "+" + "₺" + this.doubleFormat(4)
    }
}