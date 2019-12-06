
public class HeroFactory extends Hero{

	Hero makeHero(String type) {
		
		if(type.equals("Warrior")) {
			return new Warrior();
		}
		
		return null;
	}
}
