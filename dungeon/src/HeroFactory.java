
public class HeroFactory extends Hero{

	Hero makeHero(String type) {
		
		if(type.equals("Warrior")) {
			return new Warrior();
		} else if (type.equals("Sorceress")) {
			return new Sorceress();
		}  else if (type.equals("Thief")) {
			return new Thief();
		}  else if (type.equals("Paladin")) {
			return new Paladin();
		}  else if (type.equals("Arcanist")) {
			return new Arcanist();
		}			
			return null;
		}
	}
}

