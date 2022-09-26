import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchStudent {
	
	public static void main(String[] args) {
		System.out.println("학번과 점수를 입력하세요>>");
		Scanner scanner = new Scanner(System.in);
		int[] studentNum = new int[10];
		int[] score = new int[10];
		
		for(int i = 0; i<score.length; i++) {
			System.out.print((i+1)+">> ");
			studentNum[i] = scanner.nextInt();
			score[i] = scanner.nextInt();
			scanner.nextLine();
		}
		
		while(true) {
			
			System.out.print("학번으로 검색: 1, 점수로 검색:2, 끝내려면 3>> ");
			int value = scanner.nextInt();
			scanner.nextLine();
			
			if(value == 1) {
				while(true) {
					try {
						System.out.print("학번>> ");
						int inputStudentNum = scanner.nextInt();
						int count = 0;
						
							for(int i = 0; i<studentNum.length ; i++) {
								
								if(inputStudentNum == studentNum[i]) {
									System.out.println(score[i]+"점");
								}
								else {
									count++;
									if(count == studentNum.length) {
										System.out.println(inputStudentNum+"의 학생은 없습니다.");
									}
								}
							}
						break;
					}
					catch(InputMismatchException e){
						System.out.println("경고!! 정수를 입력하세요.");
						scanner.nextLine();
						continue;
						}
					}
				}
			
			if(value == 2) {
				while(true) {
					try {
						System.out.print("점수>> ");
						int inputScore = scanner.nextInt();
						int count = 0;
						System.out.print("점수가 "+inputScore+"인 학생은 ");
						
						for(int i = 0; i<score.length; i++) {
							if(score[i] == inputScore) {
								System.out.print(studentNum[i]+" ");
							}
							else {
								count++;
								if(count == score.length) {
									System.out.print("없습니다.");
									System.out.println("");
									
								}
							}
						}
						if(count != score.length) {
							System.out.print("입니다.");
							System.out.println("");
						}
						break;
					}
					catch(InputMismatchException e){
						System.out.println("경고!! 정수를 입력하세요.");
						scanner.nextLine();
						continue;
						}
				}
			} //점수 말해주기
			if(value == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		
		}
		
	}

}
