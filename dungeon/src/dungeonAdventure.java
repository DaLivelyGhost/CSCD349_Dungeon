
public class dungeonAdventure {

	public static void main(String[] args) {
		Hero Player = (Hero)GameStart.PlayerCreate();
		Dungeon Dungeon = GameStart.dungeonSize();
		GameCycle.beginAdventure(Player, Dungeon);
		
		//just testing out the dungeon stuff. feel free to delete.
		//Dungeon test = new Dungeon(1, 9);
		//System.out.println(test.toString());
	}

}
