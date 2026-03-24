import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br:BufferedReader = BufferedReader(InputStreamReader(System.`in`))

    val n:Int = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toDouble() }.toTypedArray()

    var max: Double = Double.MIN_VALUE
    for(i in 0 until n) {
        if(arr[i] > max) max = arr[i]
    }

    var sum: Double = 0.0;
    for(i in 0 until n) {
        sum += arr[i]/max*100
    }

    print(sum / n)
}