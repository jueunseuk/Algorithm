import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))

    var idx = 1;
    var max = 0;

    for(i in 1..5) {
        var curr = 0;
        var st = StringTokenizer(br.readLine(), " ");
        for(j in 1.. 4) {
            curr += st.nextToken().toInt();
        }

        if(curr > max) {
            max = curr;
            idx = i;
        }
    }

    println("$idx $max")
}