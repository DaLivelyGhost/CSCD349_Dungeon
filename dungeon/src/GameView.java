import java.util.Scanner;

//This is the view of our mvc
public class GameView {
	public static void AdventureStart(DungeonCharacter Player, Dungeon Dungeon) {
		System.out.println("----------------------------------------------------------------------\n"
				+ "You begin your adventure in the depths of your local dungeon"
				+ " at coordinates: " + (Dungeon.player_x) + "," + (Dungeon.player_y) + " (with 0 based indexing)"
				+ ".\n" + "Your goal is to find the 4 pillars of OO and escape through the exit alive!\n"
				+ "----------------------------------------------------------------------");
	}
	public static void move(Dungeon Dungeon) {
		System.out.println("Move to which room?");
		
		System.out.print(Dungeon.toString());
		String options = "";
		
		options = options.concat("1: ");
		if(Dungeon.player_x > 0) {
			options = options.concat("Up\n");
			
		}
	}
}
