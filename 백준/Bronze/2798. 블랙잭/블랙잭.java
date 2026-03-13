import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 블랙잭 변형
	
	static int[] num;
	static int[] result;
	static int N, M, maxInt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 카드 개수
        M = Integer.parseInt(st.nextToken()); // 목표 숫자
        num = new int[N];
        result = new int[3];
        
        st = new StringTokenizer(br.readLine(), " ");
        //카드 숫자 입력 받고 배열에 저장
        for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
        //입력확인
//        System.out.println(Arrays.toString(num));
        
        combination(0, 0);
        System.out.println(maxInt);
        
        br.close();
    }//main
    
    private static void combination(int depth, int idx) { // 조합
		if(depth == 3) {
			//result에 제대로 저장되었는지 체크
//			System.out.println(Arrays.toString(result));
			if(result[0]+result[1]+result[2] <= M && result[0]+result[1]+result[2] > maxInt) {
				maxInt = result[0]+result[1]+result[2];
			}
			return;
		}//if
		
		for(int i = idx; i < N; i++) {
			result[depth] = num[i];
			combination(depth+1, i+1);
		}//for
	}//dice4

}
