import java.util.List;
import java.util.ArrayList; 
public class Originator
{
	private Dungeon saveDungeon = null;
	private Hero saveHero = new Hero();
	
	public Originator(Dungeon dungeon, Hero hero) {
		this.saveDungeon = dungeon;
		this.saveHero = hero;
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
	
	public void undoFromMemento(dungeonMemento gamesave) {
		this.saveDungeon = gamesave.getDungeon();
		this.saveHero = gamesave.getHero();
	}
	
	public void print() {
		System.out.println("Character saved: " + this.saveHero.getName());
	}
   
}
