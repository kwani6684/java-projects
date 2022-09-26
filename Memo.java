public class Memo {
	private String name;
	private String time;
	private String content;
	
	public Memo(String name, String time, String content) {
		this.name = name;
		this.time = time;
		this.content = content;
	}
	public boolean isSameName(Memo person) {
		if(this == person) return true;
		else return false;
	}
	
	public void show() {
		System.out.println(name+" "+time+" "+content);
	}
	public int length() {
		return content.length();
		
	}

	public static void main(String[] args) {
		Memo a = new Memo("장수희", "10:10", "자바 과제 있음");
		Memo b = new Memo("강민서", "10:15", "저녁 알바 취소됨");
		Memo c = new Memo("최강", "11:30", "사랑하는 사람이 생겼어요");
		
		a.show();
		if(a.isSameName(b)) System.out.println("동일한 사람입니다.");
		else System.out.println("다른 사람입니다.");
		System.out.println("a의 메모 텍스트의 길이는 " + a.length());
		
	}

}
