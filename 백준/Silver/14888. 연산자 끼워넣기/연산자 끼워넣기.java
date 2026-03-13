import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main { //같은 요소가 포함된 순열 - n!/p!q!r!ᆢ (n=p+q+r+)
    static int N, size;
    static int[] num, operInput;
    static boolean[] isSelected;
    static List<String> oper = new ArrayList<>();
    static String check;
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //숫자열 개수 입력
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        operInput = new int[4]; // 부호 개수 저장할 배열
        String[] str = br.readLine().split(" ");
        //숫자열 입력
        for(int i = 0; i < N; i++) num[i] = Integer.parseInt(str[i]);
        //부호 개수 입력
        str = br.readLine().split(" ");
        for(int i = 0; i < 4; i++) operInput[i] = Integer.parseInt(str[i]);
        //부호를 배열로 변환
        for(int i = 0; i < operInput[0]; i++) oper.add("+");
        for(int i = 0; i < operInput[1]; i++) oper.add("-");
        for(int i = 0; i < operInput[2]; i++) oper.add("*");
        for(int i = 0; i < operInput[3]; i++) oper.add("/");
        
        isSelected = new boolean[oper.size()];
        
        perm(0, new String[N-1]);
        
        System.out.println(maxResult);
        System.out.println(minResult);
        //정상 입력 확인
//        System.out.println(Arrays.toString(operInput));
//        System.out.println(oper.toString());
    }//main
    
    public static void perm(int depth, String[] selected) {
        if(depth == N-1) { //재귀 종료할 조건
        	int result = calculate(selected);
        	// 순열이 만들어졌을때마다 비교 후 최댓값 저장
        	maxResult = Math.max(maxResult, result);
            minResult = Math.min(minResult, result);
            return;
        }//if
        
        // 반복적인 재귀 호출
        for(int i = 0; i < oper.size(); i++) {
        	if(isSelected[i]) continue; // 선택되었다면 패스
			//선택되지 않았다면 실행
			isSelected[i] = true;
			selected[depth] = oper.get(i);
			perm(depth+1, selected);
			isSelected[i] = false;
        }//for
    }//perm
    
    public static int calculate(String[] selected) {
        int result = num[0];
        for (int i = 0; i < N-1; i++) {
            switch (selected[i]) {
                case "+":
                    result += num[i+1]; break;
                case "-":
                    result -= num[i+1]; break;
                case "*":
                    result *= num[i+1]; break;
                case "/":
                    result /= num[i+1]; break;
            }//switch
        }//for
        return result;
    }//calculate
}//class