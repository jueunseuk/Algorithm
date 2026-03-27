import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val st = StringTokenizer(br.readLine(), " ")
    var y = 0;
    var m = 0;

    for(i in 1..n) {
        val input = st.nextToken().toInt()
        y += (input / 30 + 1) * 10
        m += (input / 60 + 1) * 15
    }

    if(y == m) {
        println("Y M $y")
    } else if(y > m) {
        println("M $m")
    } else {
        println("Y $y")
    }
}