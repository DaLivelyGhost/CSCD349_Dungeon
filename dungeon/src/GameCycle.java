
public class GameCycle {
	public static void beginAdventure(DungeonCharacter player, Dungeon Dungeon) {
		GameView.AdventureStart(player, Dungeon);
		
		RoomOptions(player, Dungeon);
	}
	private static void RoomOptions(DungeonCharacter player, Dungeon Dungeon) {
		//Gameplay loop goes here.
	}
}
