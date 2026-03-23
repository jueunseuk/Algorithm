import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))

    val st: StringTokenizer = StringTokenizer(br.readLine(), " ")
    val h: Int = st.nextToken().toInt()
    val m: Int = st.nextToken().toInt()

    if(m >= 45) {
        println("$h ${m-45}")
    } else {
        if(h > 0) {
            println("${h-1} ${m+15}")
        } else {
            println("23 ${m+15}")
        }
    }
}