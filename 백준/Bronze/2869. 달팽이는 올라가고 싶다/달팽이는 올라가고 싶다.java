import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력받기
        int A = scanner.nextInt(); // 낮에 올라가는 거리
        int B = scanner.nextInt(); // 밤에 미끄러지는 거리
        int V = scanner.nextInt(); // 나무 막대의 높이

        int dayClimb = A - B;
        int days = (V - B) / dayClimb;
        if ((V - B) % dayClimb != 0) {
            days++;
        }
        System.out.println(days);
    }
}
