import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))

    var st: StringTokenizer = StringTokenizer(br.readLine())
    val criteria = st.nextToken().toInt() * st.nextToken().toInt()

    var sb: StringBuilder = StringBuilder()
    st = StringTokenizer(br.readLine())
    for(i in 1..5) {
        sb.append(st.nextToken().toInt() - criteria).append(" ")
    }

    println(sb.toString().trim())
}