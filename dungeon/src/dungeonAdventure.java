import java.io.IOException;

public class dungeonAdventure {

	public static void main(String[] args) throws IOException {
		Hero Player = (Hero)GameStart.PlayerCreate();
		Dungeon Dungeon = GameStart.dungeonSize();
		GameCycle.beginAdventure(Player, Dungeon);
	}

}
