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
    var num = Math.abs( n )
    if( n == 0 ) return 1
    while( num != 0 ) {
        num /= 10
        count++
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
    var antecedent = 1
    var consequent = 1
    var factor = 0
    if( n == 1 || n == 2 ) return 1
    while( count < n ) {
        count++
        factor = consequent
        consequent += antecedent
        antecedent = factor
        }
    return consequent
}
/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var maxNum = Math.max( m , n )
    var minNum = Math.min( m , n )
    var remainder = 0
    while( minNum != 0 ) {
        remainder = maxNum % minNum
        maxNum = minNum
        minNum = remainder
    }
    return m * n / maxNum
}
/** +
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var t = 2
    while( n % t != 0 ) t++
    return t
}
/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var number = n - 1
    while( n % number != 0 ) {
            number--
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
    var minNumber = Math.min( m , n )
    var maxNumber = Math.max( m , n )
    var remainder = 1
    while( remainder != 0 ){
        remainder = maxNumber % minNumber
        maxNumber = minNumber
        minNumber = remainder
    }
     return maxNumber == 1
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var k = 0.0
    val M = Math.sqrt( m.toDouble() )
    val N = Math.sqrt( n.toDouble() )
    while ( k in 0.0..N ) {
        if ( k in M..N ) return true
        k++
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
    val base: Double = x % ( Math.PI * 2 )
    var sum = base
    var mult = base
    var count = 0
    var factor = 1
    while( Math.abs( mult ) >= eps ) {
        count++
        val num = 2 * count + 1.0
        mult = Math.pow( base , num ) / factorial( num.toInt() )
        factor *= -1
        sum += mult * factor
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
    val base: Double = x % ( Math.PI * 2 )
    var sum = 1.0
    var mult = base
    var count = 0
    var factor = 1
    while( Math.abs( mult ) >= eps ) {
        count++
        val num = 2.0 * count
        factor *= -1
        mult = Math.pow( base , num )  / factorial( num.toInt() )
        sum += mult * factor
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
    var num = n
    var sum = 0
    while( num != 0 ) {
        sum = sum * 10 + num % 10
        num /= 10
    }
    return sum
}
/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean = n == revert( n )

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var number = Math.abs( n )
    var lastDigit = 0
    if( number < 10 ) return false
    while( number > 10 ) {
        lastDigit = number % 10
        number /= 10
        if( number % 10 != lastDigit ) return true
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
    var Length = 0
    var num = 0
    var numsqr = 0
    while( Length < n ){
        num ++
        numsqr = num * num
        Length += digitNumber( numsqr )
    }
    return when{
        Length == 1 -> 1
        Length == n -> numsqr % 10
        else -> {
            val delta = Length - n
            var result = numsqr
            for ( i in 1..delta ){
                result /= 10
            }
            return result % 10
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
    var length = 0
    var number = 0
    var fibNumber = 0
    while( length < n ) {
        number++
        fibNumber = fib( number )
        length += digitNumber( fibNumber )
    }
    return when {
        length == 1 -> 1
        length == n -> fibNumber % 10
        else -> {
            val delta = length - n
            var result = fibNumber
            for( i in 1..delta ) {
                result /= 10
            }
            return result % 10
        }
    }
}