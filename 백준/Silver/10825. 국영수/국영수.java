import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Subject implements Comparable<Subject>{
	String name;
	int kor;
	int eng;
	int math;
	
	public Subject(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	@Override
	public int compareTo(Subject other) {
		if(this.kor != other.kor) {
			return other.kor - this.kor;
		}
		else if(this.eng != other.eng) {
			return this.eng - other.eng;
		}
		else if(this.math != other.math) {
			return other.math - this.math;
		}
		return this.name.compareTo(other.name);
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Subject> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(new Subject(
					st.nextToken(),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
					));
		}
		
		Collections.sort(list);
		
		for(Subject subject : list) {
			System.out.println(subject.name);
		}
		
		
	}

}
