
public class dungeonAdventure {

	public static void main(String[] args) {
		Hero Player = (Hero)GameStart.PlayerCreate();
		Dungeon Dungeon = GameStart.dungeonSize();
		GameCycle.beginAdventure(Player, Dungeon);
	}

}
