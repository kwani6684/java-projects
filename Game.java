import java.util.Random;
import java.util.Scanner;

abstract class Player{
	protected Scanner scanner = new Scanner(System.in);
	protected String[] value = {"묵","찌","빠"};
	protected String name;
	protected String lastValue = null;

	protected Player(String name) {
		this.name = name;
	}
	abstract public void setValue(); 
	protected String getValue() {
		return lastValue;
	}
	public String getName() {
		return name;
	}
	
}

class Human extends Player{
	
	protected Human(String name) {
		super(name);
	}
	@Override
	public void setValue() {
		int count = 0;
		boolean loop = true;
		while(loop) {
			System.out.print(this.name+">>");
			lastValue =scanner.nextLine();
			for(int i = 0; i<value.length;i++) {
				if(!(lastValue.equals(value[i]))) {
					count++;
					if(count == value.length) {
						System.out.println("묵, 찌, 빠 중에서 입력하세요.");
						loop = true;
						count = 0;
						break;
					}
				}loop = false;
			}
		}	
	}
}
class Computer extends Player{
	protected Computer(String name) {
		super(name);
	}	
	@Override
	public void setValue() {
		System.out.print(this.name+">> 결정하였습니다.");
		Random random = new Random();
		lastValue = value[random.nextInt(value.length)];
		System.out.println("");
	}
}
public class Game {
	protected Scanner scanner = new Scanner(System.in);
	private final int COUNT = 2;
	private Player players[];
	public Game() {
		players = new Player[COUNT];
		makeHumanPlayer();
		makeComputerPlayer();
	}
	public void makeHumanPlayer() {
		System.out.print("선수이름 입력 >>");
		players[0] = new Human(scanner.nextLine());
		
	}
	public void makeComputerPlayer() {
		System.out.print("컴퓨터이름 입력 >>");
		players[1] = new Computer(scanner.nextLine());
	}
	public void runGame() {
		boolean loop = true;
		while(loop) {
			for(int i = 0;i<players.length;i++) {
				players[i].setValue();
			}
			showValue();
			loop = compareValue();
		}

	}
	public void showValue() {
		for(int i = 0; i<players.length; i++) {
			System.out.print(players[i].getName()+" : "+players[i].getValue()+", ");
			
		}
		System.out.println("");
	}
	public boolean compareValue() {
		String vsValue = players[0].getValue()+players[1].getValue();
		String changeOwner[] = {"묵빠","찌묵","빠찌"};
		System.out.println("");
		
		if(players[0].getValue().equals(players[1].getValue())) {
			System.out.println(players[0].getName()+"이(가) 이겼습니다.");
			System.out.println("게임을 종료합니다.");
			return false;
		}
		else {
			for(int i = 0; i<changeOwner.length;i++) {
				if(vsValue.equals(changeOwner[i])) {
					Player p = players[0];
					players[0]=players[1];
					players[1]=p;
					break;
				}
			}
			return true;
		}
	}


	public static void main(String[] args) {
		
		Game game =  new Game();
		game.runGame();
	}

}
