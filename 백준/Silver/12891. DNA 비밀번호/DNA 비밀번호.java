import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//입력
		Scanner scan = new Scanner(System.in);
		int S = scan.nextInt();	//임의로 만든 문자열 길이
		int P = scan.nextInt();	//부분문자열 길이
		String dna = scan.next();	//임의로 만든 문자열
		int[] minArr = new int[4];	//부분문자열에 포함되어야 할 {'A','C','G','T'} 최소 개수
		for(int i=0; i<4; i++) {
			minArr[i]=scan.nextInt();
		}
	
//		System.out.println(dna.charAt(2));
		
		//풀이
		int n = S-P+1;	//만들 수 있는 부분문자열 개수
		int[] count = new int[4];	//부분문자열에 포함된 {'A','C','G','T'}의 개수
		int result=0;	//만들 수 있는 비밀번호 개수
		
		//처음 부분문자열 검사
		for(int i=0; i<P; i++) {
			switch(dna.charAt(i)) {
			case 'A':
				count[0]++;
				break;
			case 'C':
				count[1]++;
				break;
			case 'G':
				count[2]++;
				break;
			case 'T':
				count[3]++;
				break;
			}
		}
		for(int j=0; j<4; j++) {
			if(minArr[j]>count[j])break;
			if(j==3) result++;	//조건 만족하면 비밀번호 가능
		}
		
		//나머지 부분문자열 검사 => 슬라이딩 윈도우
		for(int i=0; i<n-1; i++) {
			switch(dna.charAt(i)) {
			case 'A':
				count[0]--;
				break;
			case 'C':
				count[1]--;
				break;
			case 'G':
				count[2]--;
				break;
			case 'T':
				count[3]--;
				break;
			}
			
			switch(dna.charAt(i+P)) {
			case 'A':
				count[0]++;
				break;
			case 'C':
				count[1]++;
				break;
			case 'G':
				count[2]++;
				break;
			case 'T':
				count[3]++;
				break;
			}
			
			for(int j=0; j<4; j++) {
				if(minArr[j]>count[j])break;
				if(j==3) result++;	//조건 만족하면 비밀번호 가능
			}//for j		
		}//for i

		//출력
		System.out.println(result);
	}//main
}
