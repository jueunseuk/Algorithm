import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 스위치의 개수
        int numSwitches = sc.nextInt();
        int[] switches = new int[numSwitches + 1];
        
        // 스위치 상태 입력하기
        for (int i = 1; i <= numSwitches; i++) {
            switches[i] = sc.nextInt();
        }
        
        // 학생 수
        int numStudents = sc.nextInt();
        
        // 학생 정보 입력
        for (int i = 0; i < numStudents; i++) {
            int gender = sc.nextInt();
            int number = sc.nextInt();
            
            if (gender == 1) {
                // 남학생인 경우: 받은 숫자의 배수 스위치를 반전
                for (int j = number; j <= numSwitches; j += number) {
                    switches[j] = switches[j] == 0 ? 1 : 0;
                }
            } else if (gender == 2) {
                // 여학생인 경우: 본인 기준 대칭 스위치 반전
                int left = number;
                int right = number;
                
                while (left > 0 && right <= numSwitches && switches[left] == switches[right]) {
                    switches[left] = switches[left] == 0 ? 1 : 0;
                    if (left != right) {
                        switches[right] = switches[right] == 0 ? 1 : 0;
                    }
                    left--;
                    right++;
                }
            }
        }
        
        // 스위치 상태 출력
        for (int i = 1; i <= numSwitches; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
