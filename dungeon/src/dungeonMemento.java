import java.io.Serializable;

public class dungeonMemento implements Serializable{
	
	private static Dungeon saveDungeon = new Dungeon(5, 5);
	private static Hero saveHero = new Hero();
	
	public dungeonMemento(Dungeon dungeon, Hero hero) {
		this.saveDungeon = dungeon;
		this.saveHero = hero;
	}
	
	public static Dungeon getDungeon() {
		return saveDungeon;
	}
	
	public static Hero getHero() {
		return saveHero;
	}
	
	@Override
	public String toString() {
		return ("Current Save State of: " + this.saveHero.getName());
	}
}
