import java.util.ArrayList;
import java.util.List;
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
				
				if(option != 1 && option != 2 && option != 3) {
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
	        List<Originator.SaveState> savedStates = new ArrayList<Originator.SaveState>();
	        Originator ss = new Originator();
	        ss.set("State1");
	        savedStates.add(ss.saveToMomento());
	        // call ss.restoreFromSS(savedStates.get(1));  to restore
			RoomOptions(Dungeon, player);
		}
		if(option == 2) {
			playerMove(Dungeon, player, input);
		}
		else {
			//-----------------------------------------------
				//INVENTORY GOES HERE
			//-----------------------------------------------
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
	}
	
	private static void Inventory(Hero player) {
		int choice = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println(player.getName() + " you have " + player.getTotalHealthPots() + " health pots, " + player.getTotalVisionPots() + " vision pots, and " + player.getTotalPillars() + " Pillars of OO");
		System.out.println("1. Use Health Pot");
		System.out.println("2. Use Vision Pot");
		System.out.println("3. Back to the game");
		
		while(choice < 1 || choice > 3) {
			choice = input.nextInt();
			input.nextLine();
			
			if(choice == 1) {
				Potion_healing.useHealingPotion(player);
			}
			if (choice == 2) {
				player.useVisionPotion();
			}
			if (choice == 3 ) {
				
			}
		}
	}
	private static void RoomEnter(Dungeon Dungeon, DungeonCharacter player) {
		GameView.RoomEnter(Dungeon);
		if(Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[6] != null) {
			combat(Dungeon, player);
		}
		else {
			if(Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[3] != null) {
				GameView.pickUp(3);
			}
			if(Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[4] != null) {
				GameView.pickUp(4);
			}
			if(Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[5] != null) {
				GameView.pickUp(5);
			}
			RoomOptions(Dungeon, player);
		}
	}
	private static void combat(Dungeon Dungeon, DungeonCharacter player) {
		System.out.print("combat");
		Monster theMonster = (Monster)Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[6];
		RoomOptions(Dungeon, player);
	}
	//----------------------------------------------------------------
		//Combat
	//----------------------------------------------------------------
}
