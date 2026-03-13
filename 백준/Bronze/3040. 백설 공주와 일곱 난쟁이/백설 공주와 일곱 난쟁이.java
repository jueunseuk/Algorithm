import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 백설공주와 일곱난쟁이
	
	static int num[], result[], lier[];
	static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        num = new int[9];
        result = new int[2]; // 난쟁이가 아닌 2명만 뽑을 예정
        lier = new int[2];
        
        //아홉 난쟁이들의 숫자 입력 받기
        for(int i = 0; i < 9; i++) num[i] = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < 9; i++)
        total += num[i]; // 2개의 숫자를 뽑았을 때 total에서 100을 뺀 값과 같아야 함
        
        combination(0, 0);
        
        for (int i = 0; i < 9; i++) {
            if (num[i] != lier[0] && num[i] != lier[1]) { // lier 배열에 등록된 숫자는 출력하지 않음
                System.out.println(num[i]);
            }
        }
        
        br.close();
    }//main
    
    private static void combination(int depth, int idx) { // 조합
		if(depth == 2) {
			//result에 제대로 저장되었는지 체크
//			System.out.println(Arrays.toString(result));
			if(result[0]+result[1] == total-100) {
				lier[0] = result[0];
				lier[1] = result[1];
			}
			return;
		}//if
		
		for(int i = idx; i < 9; i++) {
			result[depth] = num[i];
			combination(depth+1, i+1);
		}//for
	}//dice4

}
