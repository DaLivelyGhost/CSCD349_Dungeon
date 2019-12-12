import java.io.Serializable;

public class dungeonMemento implements Serializable{
	
	private Dungeon saveDungeon = new Dungeon(4, 4);
	private Hero saveHero = new Hero();
	
	public dungeonMemento(Dungeon dungeon, Hero hero) {
		this.saveDungeon = dungeon;
		this.saveHero = hero;
	}
	
	public Dungeon getDungeon() {
		return this.saveDungeon;
	}
	
	public Hero getHero() {
		return this.saveHero;
	}
	
	@Override
	public String toString() {
		return ("Current Save State of: " + this.saveHero.getName());
	}
}
