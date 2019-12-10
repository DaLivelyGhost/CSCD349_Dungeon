import java.util.Scanner;

public class GameStart {
	//-------------------------------------------
		//Character Creation
	//-------------------------------------------
	public static DungeonCharacter PlayerCreate() {
		Hero player = new Hero();	//Default character; will need null race and null class
		String name = playerName();
		player.setName(name);								//DungeonCharacter will need a setName
		playerClass(player);				
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
	private static void playerClass(Hero player) {
		StartView.playerClass();
		Scanner input = new Scanner(System.in);
		int choice = 0;
		
		try {
			choice = input.nextInt();
			input.nextLine();
		}
		catch(Exception e) {
			e = new Exception("Invalid input");
			playerClass(player);
		}
		switch(choice) {
		//This will need work. Feel free to change this; I assume it's wrong.
		case 1:
			player = HeroFactory.makeHero("Warrior");
		case 2:
			player = HeroFactory.makeHero("Sorceress");
		case 3:
			player = HeroFactory.makeHero("Thief");
		case 4:
			player = HeroFactory.makeHero("Paladin");
		case 5:
			player = HeroFactory.makeHero("Arcanist");
		}
		
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
