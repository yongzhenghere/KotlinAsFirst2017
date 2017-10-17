@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

import kotlin.concurrent.timer

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var count = 0
    var number = Math.abs(n)
    if (n == 0) return 1
    for (i in 1..number ) {
        if ( number != 0 ) {
            number /= 10
            count++
        }
    }
    return count
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var count = 2
    var number1 = 1
    var number2 = 1
    var number3 = 0
    if( n == 1 || n == 2 ) return 1
    for( i in 1..n ) {
        if ( count < n ) {
            count++
            number3 = number2
            number2 += number1
            number1 = number3
        }
    }
    return number2
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var q = Math.max( m , n )
    var r = Math.min( m , n )
    var s = 0
    var count = 0
    for( i in 1..r){
        if(( r % i == 0)&&( q % i == 0)) {
            count ++
            s = i
        }
    }
    return m * n / s
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var count = 0
    var a = 0
    for( i in 2..n ){
        if( n % i != 0){
            count ++
        }
        else {
            a = i
            break
        }
    }
    return a
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var number = n - 1
    for( i in 1..n ){
        if( n % number != 0){
            number --
        }
    }
    return number
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var c = Math.min( m , n )
    var d = Math.max( m , n )
    var e = 1
    while( e != 0 ){
        e = d % c
        d = c
        c = e
    }
     if( d  == 1 ) return true
        else  return false
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var k = 0
    while ( k * k in 0..n ){
        if( k * k in m..n ) return true
        k ++
    }
    return false
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    var quality: Double = x % ( Math.PI * 2 )
   var sum = quality
    var mult = quality
    var count = 0
    while( Math.abs( mult ) >= eps ) {
        count ++
        mult = Math.pow( quality , 2 * count + 1.0 )  / factorial( 2 * count + 1 )
        if( count % 2 == 0 ) sum += mult
        else sum -= mult
    }
    return sum
}
/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    var quality: Double = x % ( Math.PI * 2 )
    var sum = 1.0
    var mult = quality
    var count = 0
    while( Math.abs( mult ) >= eps ) {
        count ++
        mult = Math.pow( quality , 2.0 * count )  / factorial( 2 * count )
        if( count % 2 == 0 ) sum += mult
        else sum -= mult
    }
    return sum
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    val firstDigit = n.toString()
    val secondDigit: String = firstDigit.reversed()
    return secondDigit.toInt()
}
/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    val firstDigit = n.toString()
    val secondDigit: String = firstDigit.reversed()
    if ( firstDigit == secondDigit ) return true
    else return false
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var number = Math.abs( n )
    var lastFigure = 0
    if( number < 10 ) return false
    while( number > 10 ) {
        lastFigure = number % 10
        number /= 10
        if( number % 10 != lastFigure ) return true
    }
    return false
}


/**
 * сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var length = 0L
    var number = 0L
    var numberSquare = 0L
    do {
        number++
        numberSquare = number * number
        length += digitNumber(numberSquare.toInt())
    } while ( length < n )
    return when {
        length == 1L -> 1
        length.toInt() == n -> numberSquare.toInt() % 10
        else -> {
            val another = length.toInt() - n
            var result = numberSquare
            for (i in 1..another) {
                result /= 10
            }
            return result.toInt() % 10
        }
    }
}

/**
 * сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1 1 2 3 5 8 13 21 34 55 89 144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var length = 0L
    var number = 0L
    var fibNumber = 0L
    do {
        number++
        fibNumber = fib(number.toInt()).toLong()
        length += digitNumber(fibNumber.toInt())
    } while (length < n)
    return when {
        length == 1L -> 1
        length.toInt() == n -> fibNumber.toInt() % 10
        else -> {
            val another = length.toInt() - n
            var result = fibNumber
            for (i in 1..another) {
                result /= 10
            }
            return result.toInt() % 10
        }
    }
}