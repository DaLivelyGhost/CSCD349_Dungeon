
public class FireBomb implements Attack{
	
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter attacky) {
		
		if (Math.random() <= .1)
		{	
			
			int fireDamage = 10000;
			System.out.println(attacker.getName() + " throws a fire bomb and one shot the monster!");
			attacker.subtractHealth(fireDamage, attacky);
		}//end blow succeeded
		else
		{
			System.out.println(attacker.getName() + " missed the fireBomb...");
			System.out.println();
		}//blow failed
	}
	
	@Override
	public String toString() {
		return "Fire Bomb";
	}
}
