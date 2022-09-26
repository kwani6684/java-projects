import java.util.Random;
import java.util.Scanner;

public class Practice0913 {
	public static int[][] setSrc(){ //랜덤한 수를 저장하는 2차원 배열을 만들고 출력하기 위한 메소드
		Random random = new Random(); //랜덤하게 값을 저장하기 위한 random 객체 선언
		int[][] arr = new int[4][4]; 
		for(int i = 0; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[i].length; j++) {
				arr[i][j] = random.nextInt(255)+ 0 ; //255와0 사이의 정수를 랜덤하게 배열에 저장
				System.out.print(arr[i][j]+"\t");
			} 
			System.out.println();
		}
		return arr;
	}
	public static int[][] setBinary(int[][]src){ //값을 비교해 0과1을 대입하는 2차원배열을 만들고 출력하기 위한 메소드
												 //다른 배열의 값과 비교하여야 하기때문에 다른 배열을 매개변수로 넣음
		Scanner scanner = new Scanner(System.in); //임계값을 입력받기 위한 scanner 객체 선언
		int max = scanner.nextInt();
		System.out.println("변형한 binary 배열을 출력합니다.");
		int[][] arr = new int[4][4];
		for(int i = 0; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[i].length; j++) {
				if(src[i][j]>max) {				//임계값과 src 배열의 값을 비교해 
					arr[i][j] = 1;				//binary 배열에 1과 0 대입
				}
				else {
					arr[i][j] = 0;
				}
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		return arr;
		
	}
	
	public static void main(String[] args) {
		System.out.println("0~255 사이의 정수를 랜덤하게 저장하겠습니다.");
		int[][] src = setSrc();		//함수를 통해 src 배열을 선언 후 출력
		System.out.print("임계값을 입력하세요>> ");
		int[][] binary = setBinary(src);	//함수를 통해 binary 배열을 선언 후 출력
		
		
	}

}
