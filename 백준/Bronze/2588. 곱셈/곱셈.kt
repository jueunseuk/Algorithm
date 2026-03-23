import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))

    val a: Int = br.readLine().toInt()
    val b: CharArray = br.readLine().toCharArray()

    val mul1: Int = (b[0]-'0') * a
    val mul2: Int = (b[1]-'0') * a
    val mul3: Int = (b[2]-'0') * a

    val sb: StringBuilder = StringBuilder()
    sb.append(mul3).append("\n")
    sb.append(mul2).append("\n")
    sb.append(mul1).append("\n")
    sb.append(mul3+mul2*10+mul1*100).append("\n")

    println(sb.toString().trim())
}