import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentInfo {
	Scanner scanner = new Scanner(System.in);
	private int[] studentNum;
	private int[] studentScore;
	
	public StudentInfo(){
		studentNum = new int[10];
		studentScore = new int[10];
		for(int i = 0; i<studentNum.length; i++) {
			System.out.print((i+1)+">> ");
			studentNum[i] = scanner.nextInt();
			studentScore[i] = scanner.nextInt();
		}
	}
	public void selectNumber() {
		boolean loop = true;
			while(loop) {
			System.out.print("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3>> ");
			int number = scanner.nextInt();
			scanner.nextLine();
			
			switch(number) {
			case 1:
				while(true) {
				try {
					System.out.print("학번>> ");
					searchToStudentNum(scanner.nextInt());
				}
				catch (InputMismatchException e) {
					System.out.println("경고!! 정수를 입력하세요.");
					scanner.nextLine();
					continue;
				}
				break;
				}
				break;
			case 2:
				while(true) {
				try {
					System.out.print("점수>> ");
					searchToStudentScore(scanner.nextInt());
					
					}
				catch (InputMismatchException e) {
					System.out.println("경고!! 정수를 입력하세요.");
					scanner.nextLine();
					continue;
					}
				break;
				}
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				loop = false;
				break;
				
			default:
				System.out.println("1~3까지 입력");
				break;
			}
		}
	}
	public void searchToStudentNum(int studentNum) {
		int count = 0;
		for(int i = 0; i<this.studentNum.length; i++) {
			if (this.studentNum[i] == studentNum) {
				System.out.println(this.studentScore[i]+"점");
			}
			else {
				count++;
				if(count == this.studentNum.length) {
					System.out.println(studentNum+"의 학생은 없습니다.");
					scanner.nextLine();
					continue;
				}
			}
		}
	}
	public void searchToStudentScore(int studentScore) {
		String scoreList = "";
		int count = 0;
		System.out.print("점수가 "+studentScore+"인 학생은 ");
		for(int i = 0 ; i<this.studentScore.length ; i++) {
			if(this.studentScore[i] == studentScore) {
				scoreList += Integer.toString(this.studentNum[i])+" ";
			}
			else {
				count++;
				if(count == this.studentScore.length) {
					System.out.println("없습니다.");
					scanner.nextLine();
				}
			}
		}
		if(count != this.studentScore.length) {
			System.out.println(scoreList+"입니다.");
		}
	}
	public static void main(String[] args) {
		System.out.println("학번과 점수를 입력하세요>>");
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.selectNumber();
	}
}