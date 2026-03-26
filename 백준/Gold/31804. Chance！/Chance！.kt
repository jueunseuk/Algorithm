import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))

    val st: StringTokenizer = StringTokenizer(br.readLine(), " ")
    var start: Int = st.nextToken().toInt()
    var end: Int = st.nextToken().toInt()

    var visit = Array(end+1, {BooleanArray(2, {false})})

    br.close()

    var q: Queue<Array<Int>> = ArrayDeque()
    q.offer(arrayOf(start, 0, 0))
    visit[start][0] = true

    while(!q.isEmpty()) {
        val poll = q.poll()

        if(poll[0] == end) {
            print(poll[2])
            return
        }

        var nx: Int = poll[0]+1
        if(nx <= end && !visit[nx][poll[1]]) {
            visit[nx][poll[1]] = true
            q.offer(arrayOf(nx, poll[1], poll[2]+1))
        }

        nx = poll[0] * 2;
        if(nx <= end && !visit[nx][poll[1]]) {
            visit[nx][poll[1]] = true
            q.offer(arrayOf(nx, poll[1], poll[2]+1))
        }

        nx = poll[0] * 10
        if(poll[1] == 0 && nx <= end && !visit[nx][0]) {
            visit[nx][1] = true
            q.offer(arrayOf(nx, 1, poll[2]+1))
        }
    }
}