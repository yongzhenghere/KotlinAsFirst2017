@file:Suppress("UNUSED_PARAMETER")
package lesson4.task1

import lesson1.task1.discriminant

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var sum = 0.0
    for( i in 0 until v.size ) {
        sum += v[i] * v[i]
    }
    return Math.sqrt( sum )
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    var sum = 0.0
    if( list.size == 0 ) return 0.0
    for( i in 0 until list.size ) {
        sum += list[i]
    }
        return sum / list.size
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    var mean = mean(list)
    for (i in 0 until list.size) {
        list[i] -= mean
    }
    return list
}
/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var c = 0.0
    for( i in 0 until a.size ) {
        c += a[i] * b[i]
        if( c == 0.0 ) return 0.0
    }
    return c
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var sum1 = 0.0
    var sum2 = 0.0
    for( i in 0 until p.size ) {
        sum1 += p[i] * Math.pow( x , sum2 )
        sum2 ++
        if( sum1 == 0.0 ) return 0.0
    }
    return sum1
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    var t = 0.0
    for( i in 0 until list.size ) {
        t += list[i]
        list[i] = t
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    val list = mutableListOf<Int>()
   var count = 2
    var number = n
    while( number != 1 ) {
        while (number % count == 0) {
            list.add(count)
            number /= count
        }
        count ++
    }
    return list
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString ("*" )
/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    val list = mutableListOf<Int>()
    var num = n
    if( num == 0 )  return listOf(0)
    while( num > 0 ) {
            list.add( num % base )
            num /= base
        }
    return list.reversed()
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    val wordlist = mutableListOf<Char>()
    val list = convert(n,base)
    if( n == 0 ) return 0.toString()
    for( element in list ) {
        when {
            element <= 9 -> wordlist.add( '0' + element )
            else -> wordlist.add( 'a' + element - 10 )
        }
    }
        return wordlist.joinToString("" )
    }
/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
  var sum = 0
    for( i in 0 until digits.size) {
        sum += digits[i] * Math.pow( base.toDouble() , (digits.size - i - 1).toDouble() ).toInt()
    }
    return sum
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    val list = mutableListOf<Int>()
    val string = str
       for( i in 0 until str.length ) {
           if( string[i] in '0'..'9') list += string[i].toInt() - 48
           else list += string[i].toInt() - 87
       }
    return decimal( list , base )
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String = TODO()/*{
    var num = n
   val list = mutableListOf<String>()
    do{
        num -= 1000
        list.add('M'.toString())
    }while( n < 1000 )
    when {
        num >= 900 -> list.add("CM")
        ( num >= 500 )&&( num < 900 ) -> list.add('D'.toString())
        ( num >= 400 )&&( num < 500 ) -> list.add("CD")
        ( num >= 100 )&&( num < 400 ) -> list.add('C'.toString())
    }

}*/

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var result = String()
    var num = n
    if ( n < 1000 ) {
        if( n / 100 == 1 ) result += "сто"
        if( n / 100 == 2 ) result += "двести"
        if( n / 100 == 3 ) result += "триста"
        if( n / 100 == 4 ) result += "четыреста"
        if( n / 100 == 5 ) result += "пятьсот"
        if( n / 100 == 6 ) result += "шестьсот"
        if( n / 100 == 7 ) result += "семьсот"
        if( n / 100 == 8 ) result += "восемьсот"
        if( n / 100 == 9 ) result += "девятьсот"
        num %= 100
        if ( num in 10..19 ) {
            if( num == 10 ) result += " десять"
            if( num == 11 ) result += " одиннадцать"
            if( num == 12 ) result += " двенадцать"
            if( num == 13 ) result += " тринадцать"
            if( num == 14 ) result += " четырнадцать"
            if( num == 15 ) result += " пятнадцать"
            if( num == 16 ) result += " шестнадцать"
            if( num == 17 ) result += " семнадцать"
            if( num == 18 ) result += " восемнадцать"
            if( num == 19 ) result += " девятнадцать"
        } else {
            val p = num / 10
            if( p == 2 ) result += " двадцать"
            if( p == 3 ) result += " тридцать"
            if( p == 4 ) result += " сорок"
            if( p == 5 ) result += " пятьдесят"
            if( p == 6 ) result += " шестьдесят"
            if( p == 7 ) result += " семьдесят"
            if( p == 8 ) result += " восемьдесят"
            if( p == 9 ) result += " девяносто"
            num %= 10
            if( num == 1 ) result += " один"
            if( num == 2 ) result += " два"
            if( num == 3 ) result += " три"
            if( num == 4 ) result += " четыре"
            if( num == 5 ) result += " пять"
            if( num == 6 ) result += " шесть"
            if( num == 7 ) result += " семь"
            if( num == 8 ) result += " восемь"
            if( num == 9 ) result += " девять"
        }
    } else {
    var thous = num / 1000
    val unit = num % 1000
    var t = 1
    if (( thous % 10 == 1 ) && (thous % 100 != 11 )) {
        thous = ( thous / 10 ) * 10
        t = 0
    }
    if (( thous % 10 == 2 ) && (thous % 100 !in 12..14 )) {
        thous = ( thous / 10 ) * 10
        t = 2
    }
    var step1 = russian(thous)
    val step2 = russian(unit)
    if (( thous % 10 == 0 )&&( t == 1 )) step1 += " тысяч "
     if ( thous % 100 == 11 ) step1 += " тысяч "
    if (( thous % 10 in 2..4 ) &&( thous % 100 !in 12..14 )) step1 += " тысячи "
    if (( thous % 10 in 5..9 )||( thous % 100 in 12..14 )) step1 += " тысяч "
    if ( t == 0 ) step1 += " одна тысяча "
    if ( t == 2 ) step1 += " две тысячи "
    result = step1 + step2
}
return result.trim()
}