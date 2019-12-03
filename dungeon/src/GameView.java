import java.util.Scanner;

//This is the view of our mvc
public class GameView {
	public static void AdventureStart(DungeonCharacter Player, Dungeon Dungeon) {
		System.out.println("You begin your adventure in the depths of your local dungeon"
				+ "at coordinates: " + Dungeon.player_x + "," + Dungeon.player_y);
	}
}
