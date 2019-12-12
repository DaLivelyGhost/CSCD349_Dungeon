import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class GameCycle {
	public static void beginAdventure(Hero player, Dungeon Dungeon) throws IOException {
		GameView.AdventureStart(player, Dungeon);
		int GameState = 0; //1 for game over, 2 for victory, 3 for quit
		RoomOptions(Dungeon, player, GameState);
	}
	private static void RoomOptions(Dungeon Dungeon, Hero player, int GameState) throws IOException {
		Scanner input = new Scanner(System.in);
		int option = 0;	
		
		while(GameState == 0) {
			while(option == 0) {
				try {
					GameView.roomOptions();
					option = input.nextInt();
					input.nextLine();
				
					if(option != 1 && option != 2 && option != 3 && option != 4) {
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
			GameView.printDivider();
			if(option == 1) {
				
				dungeonMemento gamesave = new dungeonMemento(Dungeon, player);
				DungeonSerialization.Serialization(gamesave);
	        	// call ss.restoreFromSS(savedStates.get(1));  to restore
				RoomOptions(Dungeon, player, GameState);
			}
			if(option == 2) {
				playerMove(Dungeon, player, input, GameState);
			}
			if(option == 3) {
				Inventory(player, Dungeon);
				RoomOptions(Dungeon, player, GameState);
			}
			else {
				GameState = 3;
				RoomOptions(Dungeon, player, GameState);
			}
		}
		if(GameState == 1) {
			GameOver(input);
		}
		if(GameState == 2) {
			GameVictory(input);
		}
		if(GameState == 3) {
			
		}
	}
	private static void playerMove(Dungeon Dungeon, Hero player, Scanner input, int GameState) throws IOException {
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
		RoomEnter(Dungeon, player, GameState);
	}	
	private static void Inventory(Hero player, Dungeon Dungeon) {
		int choice = 0;
		Scanner input = new Scanner(System.in);
		GameView.Inventory(player);
		
		while(choice == 0) {
			try {
				choice = input.nextInt();
				input.nextLine();
				
				if(choice != 1 && choice != 2 && choice != 3) {
					choice = 0;
					GameView.invalidInput();
				}
			}
			catch(Exception e) {
				e = new Exception("Invalid input type!");
				choice = 0;
				input = new Scanner(System.in);
			}
		}
		if(choice == 1) {
			if(player.getTotalHealthPots() >= 1) {
				Potion_healing.useHealingPotion(player);
			}
			else {
				GameView.InsufficientHealPots();
			}
		}
		if (choice == 2) {
			if(player.getTotalVisionPots() >= 1) {
				player.useVisionPotion(Dungeon);
				GameView.drinkVisionPotion();
			}
			else {
				GameView.InsufficientVisionPots();
			}

		}
		if (choice == 3 ) {}
		GameView.printDivider();
	}
	private static void RoomEnter(Dungeon Dungeon, Hero player, int GameState) throws IOException {
		Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).visited = true;
		GameView.RoomEnter(Dungeon);
		
		if(Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[6] != null) {//Monster
			
			combat.battle(player, (Monster)Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[6]);
			
			if(!player.isAlive()) {
				GameState = 1;
				RoomOptions(Dungeon, player, GameState);
			}
			Random r = new Random();
			int reward = r.nextInt(11);
			
			if(reward > 7) {
				player.setTotalHealthPots(player.getTotalHealthPots() + 1);
			}
			Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[6] = null;
		}
		//------------------------------------------------------------------------
		if(Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[0] != null) {//pit
			Pit pit = (Pit)Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[0];
			pit.damagePit(player);		
			
			if(!player.isAlive()) {
				GameState = 1;
				RoomOptions(Dungeon, player, GameState);
			}
		}
		if(Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[2] != null) {//exit
			//TO DO: check for if 4 pillars are collected. If so, end game.
			if(player.getTotalPillars() == 4) {
				GameState = 2;
				RoomOptions(Dungeon, player, GameState);
			}
		}
		//------------------------------------------------------------------------
		if(Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[3] != null) {//pillar
			GameView.pickUp(3);
			player.setTotalPillars(player.getTotalPillars() + 1);
			Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[3] = null;
		}
		//------------------------------------------------------------------------
		if(Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[4] != null) {//healing pot
			GameView.pickUp(4);
			player.setTotalHealthPots(player.getTotalHealthPots() + 1);
			Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[4] = null;
		}
		//------------------------------------------------------------------------
		if(Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[5] != null) {//vision pot
			GameView.pickUp(5);
			player.setTotalVisionPots(player.getTotalHealthPots() + 1);
			Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).content[5] = null;
		}
		//------------------------------------------------------------------------
		if(Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).icon.compareTo("O") != 0
				&& Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).icon.compareTo("I") != 0
				&& Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).icon.compareTo("P") != 0) {
			if(Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).icon.compareTo("P") == 0) {
				Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).setIcon("P");
			}
			else {
				Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).setIcon("E");
			}
		}
		
		RoomOptions(Dungeon, player, GameState);
	}
	private static void GameOver(Scanner input) throws IOException {
		int restart = 0;
		GameView.GameOver();
		while(restart == 0){
			try {
				restart = input.nextInt();
				input.nextLine();
				
				if(restart != 1 && restart != 2) {
					GameView.invalidInput();
					restart = 0;
				}
			}
			catch(Exception e) {
				e = new Exception("Invalid input type!");
				GameView.printException(e);
				restart = 0;
			}
		}
		if(restart == 1) {
			GameView.printDivider();
			Hero Player = (Hero)GameStart.PlayerCreate();
			Dungeon Dungeon = GameStart.dungeonSize();
			GameCycle.beginAdventure(Player, Dungeon);
		}
		else {
			GameView.printDivider();
			GameView.badEnding();
		}
	}
	private static void GameVictory(Scanner input) throws IOException {
		int restart = 0;
		GameView.GameWin();
		while(restart == 0){
			try {
				restart = input.nextInt();
				input.nextLine();
				
				if(restart != 1 && restart != 2) {
					GameView.invalidInput();
					restart = 0;
				}
			}
			catch(Exception e) {
				e = new Exception("Invalid input type!");
				GameView.printException(e);
				restart = 0;
			}
		}
		if(restart == 1) {
			GameView.printDivider();
			Hero Player = (Hero)GameStart.PlayerCreate();
			Dungeon Dungeon = GameStart.dungeonSize();
			GameCycle.beginAdventure(Player, Dungeon);
		}
		else {
			GameView.printDivider();
			GameView.goodEnding();
		}
	}
}
