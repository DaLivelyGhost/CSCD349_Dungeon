
public class HeroFactory extends Hero{

	static Hero makeHero(String type) {
		
		Hero hero = null;
		
		if(type.equals("Warrior")) {
			hero = new Warrior();
		} else if (type.equals("Sorceress")) {
			hero = new Sorceress();
		}  else if (type.equals("Thief")) {
			hero = new Thief();
		}  else if (type.equals("Paladin")) {
			hero = new Paladin();
		}  else if (type.equals("Arcanist")) {
			hero = new Arcanist();
		}			
			return hero;
	}
	
}

