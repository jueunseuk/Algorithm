import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int rateFirst1000 = scanner.nextInt();
        int rateAdditional = scanner.nextInt();
        
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            int consumption = scanner.nextInt();
            int charge;
            if (consumption <= 1000) {
                charge = consumption * rateFirst1000;
            } else {
                charge = (1000 * rateFirst1000) + ((consumption - 1000) * rateAdditional);
            }
            System.out.println(consumption + " " + charge);
        }
        
        scanner.close();
    }
}
