
public class Pit {
	
	DungeonCharacter dungeoncharacter;
	
	public Pit() {
		//change health as needed
		dungeoncharacter.hp = dungeoncharacter.hp - 20;
		System.out.println("You fell into a spike pit and took 20 damage!");
	}
}
