fun main(args: Array<String>) {
    val countSec = 10
    println("был " + agoToText(countSec))
}

fun agoToText(countSec: Int): String {
    var endOfWord = "неизвестно"
    when {
        (countSec in 0..60) -> endOfWord = "только что"
        (countSec > 60 && countSec <= 60 * 60) -> endOfWord = getMinutes(countSec)
        (countSec > (60 * 60 + 1) && countSec <= 24 * 60 * 60) -> endOfWord = getHours(countSec)
        (countSec > 24 * 60 * 60 && countSec <= 2 * 24 * 60 * 60) -> endOfWord = "вчера"
        (countSec > 2 * 24 * 60 * 60 && countSec <= 3 * 24 * 60 * 60) -> endOfWord = "позавчера"
        (countSec > 3 * 24 * 60 * 60) -> return "давно"
    }
    return endOfWord
}

fun getMinutes(countSec: Int): String {
    val minutes = countSec / 60
    var endOfWord = "$minutes минут назад"
    when {
        (minutes % 10 == 1 && minutes != 11) -> endOfWord = "$minutes минуту назад"
        (minutes % 10 == 2) -> endOfWord = "$minutes минуты назад"
    }
    return endOfWord
}

fun getHours(countSec: Int): String {
    val hours = countSec / 60 / 60
    var endOfWord = "$hours часа назад"
    when {
        (hours == 1 || hours == 21) -> endOfWord = "$hours час назад"
        (hours in 5..20) -> endOfWord = "$hours часов назад"
    }
    return endOfWord
}