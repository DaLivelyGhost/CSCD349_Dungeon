import java.util.Scanner;

public class GameStart {
	//Player name method
	public static void playerName() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the name of your hero:");
		
		try {
			
		}
		catch(Exception e) {
			e = new Exception("Really don't know how you managed this.");
			playerName();
		}
		playerClass(input);
	}
	//Player class method
	private static void playerClass(Scanner input) {
		
		dungeonSize(input);
	}
	//size of dungeon method
	private static void dungeonSize(Scanner input) {
		System.out.println("What size of dungeon will you explore?");
		int size_x = 0, size_y = 0;
		try {
			
		}
		catch(Exception e){
			e = new Exception("enter a valid integer size, please.");
		}
		createDungeon(input, size_x, size_y);
	}
	//Dungeon Generation
	private static void createDungeon(Scanner input, int size_x, int size_y) {
		Dungeon Dungeon = new Dungeon(size_x, size_y);
	}
}
