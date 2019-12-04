import java.util.Scanner;

public class GameCycle {
	public static void beginAdventure(DungeonCharacter player, Dungeon Dungeon) {
		GameView.AdventureStart(player, Dungeon);
		
		RoomOptions(player, Dungeon);
	}
	private static void RoomOptions(DungeonCharacter player, Dungeon Dungeon) {
		Scanner input = new Scanner(System.in);
		int option = 0;
		
		GameView.move(Dungeon);
		
	}
}
