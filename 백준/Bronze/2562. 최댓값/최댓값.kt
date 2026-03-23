import java.io.BufferedReader

fun main() {
    val br = BufferedReader(System.`in`.reader())

    val size: Int = 9
    var idx: Int = 0
    var max: Int = 0

    for(i in 1..size) {
        val num = br.readLine().toInt()

        if(num > max) {
            max = num
            idx = i
        }
    }

    println(max)
    println(idx)
}