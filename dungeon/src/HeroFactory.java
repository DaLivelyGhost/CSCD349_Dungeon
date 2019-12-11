
public class HeroFactory extends Hero{

	static Hero makeHero(String type) {
		
		Hero hero = null;
		
		if(type.equals("Warrior")) {
			hero = new Warrior();
			hero.specialAttack = new CrushingBlow();
		} else if (type.equals("Sorceress")) {
			hero = new Sorceress();
			hero.specialAttack = new SpecialHeal();
		}  else if (type.equals("Thief")) {
			hero = new Thief();
			hero.specialAttack = new SupriseAttack();
		}  else if (type.equals("Paladin")) {
			hero = new Paladin();
			hero.specialAttack = new HolyBash();
		}  else if (type.equals("Arcanist")) {
			hero = new Arcanist();
			hero.specialAttack = new FireBomb();
		}			
			return hero;
	}
	
}

