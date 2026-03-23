import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val arr = br.readLine().toCharArray()
    var sum = 0
    for(i in 1..n) {
        sum += arr[i - 1] - '0'
    }

    println(sum)
}