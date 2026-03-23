import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n: Int = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()

    var min = Integer.MAX_VALUE
    var max = Integer.MIN_VALUE

    for(i in 0 until n) {
        if(arr[i] < min) {
            min = arr[i]
        }
        if(arr[i] > max) {
            max = arr[i]
        }
    }

    println("$min $max")
}