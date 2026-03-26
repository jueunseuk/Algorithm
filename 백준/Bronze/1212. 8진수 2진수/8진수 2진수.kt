import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val array = arrayOf("000", "001", "010", "011", "100", "101", "110", "111")
    val str = br.readLine().toCharArray()
    var sb = StringBuilder()
    sb.append(array[str[0]-'0'].toInt())
    for(i in 1 until str.size) {
        sb.append(array[str[i]-'0'])
    }
    println(sb.toString())
}