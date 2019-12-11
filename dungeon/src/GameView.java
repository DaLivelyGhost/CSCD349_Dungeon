import java.util.Scanner;

//This is the view of our mvc
public class GameView {
	public static void invalidInput() {
		System.out.println("Invalid input!");
	}
	public static void printException(Exception e) {
		System.out.println(e);
	}
	public static void printDivider() {
		System.out.println("----------------------------------------------------------------------");
	}
	public static void AdventureStart(DungeonCharacter Player, Dungeon Dungeon) {
		printDivider();
		System.out.println("You begin your adventure in the depths of your local dungeon"
				+ " at coordinates: " + (Dungeon.player_x) + "," + (Dungeon.player_y) + " (with 0 based indexing)"
				+ ".\n" + "Your goal is to find the 4 pillars of OO and escape through the exit alive!");
		printDivider();
	}
	public static void roomOptions() {
		System.out.println("1. Save\n"
							+ "2. Move\n"
							+ "3. Inventory");
	}
	public static void move(Dungeon Dungeon, String[] choice) {
		System.out.println("Move to which room?");
		System.out.println("");
		
		int i = 1;
		System.out.print(Dungeon.toString());
		String options = ("");
	
		if(Dungeon.player_x > 0) {
			choice[i] = ("Up");
			i++;
		}
		if(Dungeon.player_y > 0) {
			choice[i] = ("Left");
			i++;
		}
		if(Dungeon.player_x < Dungeon.x_dimension - 1) {
			choice[i] = ("Down");
			i++;
		}
		if(Dungeon.player_y < Dungeon.y_dimension - 1) {
			choice[i] = ("Right");
			i++;
		}
		
		System.out.println("");
		i = 1;
		
		for(String j : choice) {
			if(j != null) {
				options = options.concat(String.valueOf(i));
				options = options.concat(": " + j + "\n");
				i++;
			}
		}
		System.out.println(options);
	}
	public static void RoomEnter(Dungeon Dungeon) {
		String output = Dungeon.getRoom(Dungeon.player_x, Dungeon.player_y).description;
		System.out.println(output);
		
	}
	public static void pickUp(int pickup) {
		printDivider();
		if(pickup == 3) {
			System.out.println("You acquired a pillar of OO!\n" 
					+ "You come closer to finishing your goal!");
		}
		if(pickup == 4) {
			System.out.println("You acquired a healing potion!\n"
					+ "This will get you out of a jam!");
		}
		if(pickup == 5) {
			System.out.println("You acquired a vision potion!\n"
					+ "The path to the finish becomes clearer!");
		}
	}
	//----------------------------------------------------------------
		//Combat
	//----------------------------------------------------------------
	public static void GameOver() {
		System.out.println("You Died\n"
				+ "Try again?\n"
				+ "\n"
				+ "1. Accept\n"
				+ "2. Decline");
	}
}
