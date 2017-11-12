@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.discriminant

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String = when {
    ( age % 10 == 1 )&&( age % 100 != 11 ) -> "$age год"
    ( age % 10 in 2..4 )&&( age !in 12..14 )&&( age !in 112..114 ) -> "$age года"
    else -> "$age лет"
}

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    val halfJourney = ( v2 * t2 + v3 * t3 + t1 * v1 ) / 2
    val time: Double
    when {
        halfJourney <= t1 * v1 ->  time = halfJourney / v1
        halfJourney < v2 * t2 + v1 * t1 ->  time = t1 + ( halfJourney - t1 * v1 ) / v2
        else ->  time = t1 + t2 + ( halfJourney - v2 * t2 - v1 * t1 ) / v3
    }
    return  time
}
/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    val firstRook = ( kingX == rookX1 )||( kingY == rookY1 )
    val secondRook = ( kingX == rookX2 )||( kingY == rookY2 )
   return when {
        firstRook && !secondRook -> 1
        secondRook && !firstRook -> 2
        firstRook && secondRook -> 3
        else -> 0
    }
}
/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    val deltay =  Math.abs( bishopY - kingY )
    val deltax =  Math.abs( bishopX - kingX )
    val rook = ( kingX == rookX || kingY == rookY )
    val bishop = ( deltay == deltax )
    return when {
        rook && bishop -> 3
       rook && !bishop -> 1
        bishop && !rook -> 2
        else -> 0
    }
}
/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double):Int {
    val minSide = minOf( a , b , c )
    val maxSide = maxOf( a , b , c )
    val midSide = a + b + c - minSide - maxSide
    val sum = minSide * minSide + midSide * midSide
    val pro = maxSide * maxSide
    if( midSide + minSide <= maxSide ) return -1
    return when( midSide + minSide > maxSide ) {
       sum == pro -> 1
        sum < pro -> 2
        else -> 0
    }
}
/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int = when {
        ( a <= c )&&( c < b )&&( b <= d ) -> b - c // a <= c , b between c and d
        ( c <= a )&&( b <= d ) -> b - a // a,b between c and d
        ( a <= c )&&( d <= b ) -> d - c // c,d between a and b
        ( c <= a )&&( a < d )&&( d <= b ) -> d - a // b >= d , a between c and d
        ( a == d )||( b == c ) -> 0 // ab coincide cd
        else -> -1
    }