import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val map = mutableMapOf<String, Int>()
    map["black"] = 0
    map["brown"] = 1
    map["red"] = 2
    map["orange"] = 3
    map["yellow"] = 4
    map["green"] = 5
    map["blue"] = 6
    map["violet"] = 7
    map["grey"] = 8
    map["white"] = 9

    val a = br.readLine()
    val b = br.readLine()
    val c = br.readLine()

    var sum = 0L
    sum += map[a]!! * 10
    sum += map[b]!!
    sum *= 10.0.pow(map[c]!!.toDouble()).toLong()

    println(sum)
}