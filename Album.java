import java.util.Scanner;

class Song {

	private String name; 
	private String composer;
	private String singer;

	public Song(String name, String composer, String singer) {
		this.name = name;
		this.composer = composer;
		this.singer = singer;
	}
	public String getName() {return name;}
	public String getComposer() {return composer;}
	public String getSinger() {return singer;}

}
public class Album {
	private Scanner scanner = new Scanner(System.in);
	private Song[] songs;
	
	public Album() {
		System.out.println("한성 축제 앨범의 곡을 저장합니다.");
		System.out.print("곡 개수는?");
		final int SONGNUMBER = scanner.nextInt();
		scanner.nextLine();
		songs = new Song[SONGNUMBER];
		for(int i =0 ; i<songs.length; i++) {
			System.out.print("곡명?");
			String name = scanner.nextLine();
			System.out.print("작곡가?");
			String composer = scanner.nextLine();
			System.out.print("가수명?");
			String singer = scanner.nextLine();	
			
			songs[i] = new Song(name,composer,singer);
		}

	}
	public void searchAlbum() {
		boolean loop = true;
		
		System.out.println("한성 축제 앨범에서 곡을 검색합니다.");
		while(loop) {
			int count = 0;
			System.out.print("검색할 곡명을 입력하세요>>");
			String inputSong = scanner.nextLine();

			for(int i = 0; i<songs.length; i++) {
				if(inputSong.equals(songs[i].getName())) {
					System.out.println(songs[i].getName()+","+songs[i].getComposer()+","+songs[i].getSinger());
				}
				else if(inputSong.equals("그만")) {
					loop = false;
				}
				else if(!inputSong.equals(songs[i].getName())) {
					count++;
					if(count == songs.length) {
						System.out.println(inputSong+" 곡은 없습니다.");
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Album albumList = new Album();
		albumList.searchAlbum();
	}

}
