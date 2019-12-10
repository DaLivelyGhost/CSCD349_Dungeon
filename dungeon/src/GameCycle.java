import java.util.Scanner;

public class GameCycle {
	public static void beginAdventure(DungeonCharacter player, Dungeon Dungeon) {
		GameView.AdventureStart(player, Dungeon);
		
		RoomOptions(Dungeon, player);
	}
	private static void RoomOptions(Dungeon Dungeon, DungeonCharacter player) {
		Scanner input = new Scanner(System.in);
		int option = 0;
		GameView.roomOptions();
		while(option == 0) {
			try {
				option = input.nextInt();
				input.nextLine();
				
				if(option != 1 && option != 2) {
					GameView.invalidInput();
					option = 0;
					GameView.roomOptions();
				}
			}
			catch(Exception e) {
				e = new Exception("Invalid input type!");
				GameView.printException(e);
				option = 0;
				input = new Scanner(System.in);
			}
		}
		if(option == 1) {
			//-----------------------------------------------
				//SAVE GAME GOES HERE
			//-----------------------------------------------
			RoomOptions(Dungeon, player);
		}
		else {
			playerMove(Dungeon, player, input);
		}
	}
	private static void playerMove(Dungeon Dungeon, DungeonCharacter player, Scanner input) {
		int option = 0;
		String[] Roomchoice = new String[5];
		GameView.move(Dungeon, Roomchoice);
		
		while(option == 0) {
			try {
				option = input.nextInt();
				input.nextLine();
				if(Roomchoice[option] == null || option < 1 || option > 4) {
					GameView.invalidInput();
					option = 0;
				}
			}
			catch(Exception e) {
				e = new Exception("Invalid input type");
				GameView.printException(e);
				option = 0;
				input = new Scanner(System.in);
				GameView.move(Dungeon, Roomchoice);
			}
		}
		GameView.printDivider();
		
		if(Roomchoice[option].compareTo("Up") == 0) {
			Dungeon.player_x--;
		}
		if(Roomchoice[option].compareTo("Down") == 0) {
			Dungeon.player_x++;
		}
		if(Roomchoice[option].compareTo("Left") == 0) {
			Dungeon.player_y--;
		}
		if(Roomchoice[option].compareTo("Right") == 0) {
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
