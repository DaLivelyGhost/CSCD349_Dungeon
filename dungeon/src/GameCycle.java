import java.util.Scanner;

public class GameCycle {
	public static void beginAdventure(DungeonCharacter player, Dungeon Dungeon) {
		GameView.AdventureStart(player, Dungeon);
		
		RoomOptions(Dungeon, player);
	}
	private static void RoomOptions(Dungeon Dungeon, DungeonCharacter player) {
		Scanner input = new Scanner(System.in);
		int option = 0;
		String[] choice = new String[5];
		GameView.move(Dungeon, choice);
		
		while(option == 0) {
			try {
				option = input.nextInt();
				input.nextLine();
				if(choice[option] == null || option < 1 || option > 4) {
					GameView.invalidInput();
					option = 0;
				}
			}
			catch(Exception e) {
				e = new Exception("Invalid input type");
				GameView.printException(e);
				option = 0;
				input = new Scanner(System.in);
				GameView.move(Dungeon, choice);
			}
		}
		GameView.printDivider();
		playerMove(choice[option], Dungeon, player);
	}
	private static void playerMove(String input, Dungeon Dungeon, DungeonCharacter player) {
		if(input.compareTo("Up") == 0) {
			Dungeon.player_x--;
		}
		if(input.compareTo("Down") == 0) {
			Dungeon.player_x++;
		}
		if(input.compareTo("Left") == 0) {
			Dungeon.player_y--;
		}
		if(input.compareTo("Right") == 0) {
			Dungeon.player_y++;
		}
		RoomEnter(Dungeon, player);
		RoomOptions(Dungeon, player);
	}
	private static void RoomEnter(Dungeon Dungeon, DungeonCharacter player) {
		GameView.RoomEnter(Dungeon);
	}
	//----------------------------------------------------------------
		//Combat
	//----------------------------------------------------------------
	
}
