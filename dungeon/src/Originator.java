import java.util.List;
import java.util.ArrayList; 
public class Originator
{
	private static Dungeon saveDungeon = new Dungeon(0, 0);
	private static Hero saveHero = new Hero();
	
	public Originator(Dungeon dungeon, Hero hero) {
		saveDungeon = dungeon;
		saveHero = hero;
	}
	
	public Dungeon getDungeon() {
		return this.saveDungeon;
	}
	
	public Hero getHero() {
		return this.saveHero;
	}
	
	public void setDungeon(Dungeon dungeon) {
		this.saveDungeon = dungeon;
	}
	
	public void setHero(Hero hero) {
		this.saveHero = hero;
	}
	
	public dungeonMemento saveToMemento() {
		
		dungeonMemento gamesave = new dungeonMemento(saveDungeon, saveHero);
		return gamesave;
	}
	
	public static void undoFromMemento(dungeonMemento gamesave) {
		saveDungeon = gamesave.getDungeon();
		saveHero = gamesave.getHero();
	}
	
	public void print() {
		System.out.println("Character saved: " + this.saveHero.getName());
	}
   
}
