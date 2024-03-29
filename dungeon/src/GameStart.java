import java.io.IOException;
import java.util.Scanner;

public class GameStart {
	public static void loadGame() throws ClassNotFoundException, IOException {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		
		StartView.gameLoad();
		
		while(choice == 0) {
			try {
				choice = input.nextInt();
				input.nextLine();
				
				if(choice != 1 && choice != 2) {
					choice = 0;
					StartView.gameLoad();
				}
			}
			catch(Exception e) {
				e = new Exception("Invalid input type!");
				GameView.printException(e);
				choice = 0;
				input = new Scanner(System.in);
				StartView.gameLoad();
			}
			if(choice == 2) {
				dungeonMemento gameSave = DungeonSerialization.Deserialization();
				Originator gameOriginator = new Originator(null, null);
				gameOriginator.undoFromMemento(gameSave);
				GameCycle.beginAdventure(gameSave.getHero(), gameSave.getDungeon());
			}
		}
	}
	//-------------------------------------------
		//Character Creation
	//-------------------------------------------
	public static DungeonCharacter PlayerCreate() {
		String name = playerName();
		Hero player = playerClass();	//Default character; will need null race and null class
		player.setName(name);								//DungeonCharacter will need a setName
		return player;
	}
	
	public static String playerName() {
		Scanner input = new Scanner(System.in);
		String name = "";
		StartView.playerName();
		
		try {
			name = input.nextLine();
		}
		catch(Exception e) {
			e = new Exception("Really don't know how you managed this.");
			playerName();
		}
		return name;
	}
	//Player class method
	private static Hero playerClass() {
		StartView.playerClass();
		Scanner input = new Scanner(System.in);
		int choice = 0;
		
		while(choice == 0) {
			try {
				choice = input.nextInt();
				input.nextLine();
				
				if(choice < 1 || choice > 5) {
					GameView.invalidInput();
					StartView.playerClass();
					choice = 0;
				}
			}
			catch(Exception e) {
				e = new Exception("Invalid input type");
				GameView.printException(e);
				StartView.playerClass();
				choice = 0;
				input = new Scanner(System.in);
			}
		}
		switch(choice) {
		//This will need work. Feel free to change this; I assume it's wrong.
		case 1:
			return HeroFactory.makeHero("Warrior");
		case 2:
			return HeroFactory.makeHero("Sorceress");
		case 3:
			return HeroFactory.makeHero("Thief");
		case 4:
			return HeroFactory.makeHero("Paladin");
		case 5:
			return HeroFactory.makeHero("Arcanist");
		}
		return HeroFactory.makeHero("Warrior");
	}
	//-------------------------------------------
		//Dungeon Creation
	//-------------------------------------------
	public static Dungeon dungeonSize() {
		StartView.dungeonSize();
		Scanner input = new Scanner(System.in);
		
		int size_x = 0, size_y = 0;
		Dungeon Dungeon = null;
		
		while(size_x * size_y <= 6) {
			try {
			
				StartView.x();
				size_x = input.nextInt();
				input.nextLine();
				//System.out.println("");
			
				StartView.y();
				size_y = input.nextInt();
				input.nextLine();
				//System.out.println("");
			}
			catch(Exception e){
				e = new Exception("Please enter integer values");
				StartView.dungeonException(e);
				size_x = 0;
				size_y = 0;
				input = new Scanner(System.in);
			}
			if(size_x * size_y <= 6) {
				StartView.invalidDimensions();
				size_x = 0;
				size_y = 0;
			}
		}
		if(size_x * size_y > 6) {
			Dungeon = new Dungeon(size_x, size_y);
		}
		return Dungeon;
	}
}
