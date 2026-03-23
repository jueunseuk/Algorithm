import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))

    val n: Int = br.readLine().toInt()

    val sb: StringBuilder = StringBuilder()
    for(i in 1..n) {
        for(j in n-i downTo 1) {
            sb.append(' ')
        }
        for(j in 1..i) {
            sb.append('*')
        }
        sb.append("\n")
    }

    println(sb.toString())
}