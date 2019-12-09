
public class BaseAttack implements Attack{
	
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter attacky) {
		
		boolean hitCheck = Math.random() <= attacker.hitChance;
		
		if(hitCheck == true) {
			int basicAttack = (int)(Math.random() * (attacker.maxDamage - attacker.minDamage + 1));
			attacker.subtractHealth(basicAttack, attacky);
			System.out.println(attacker.getName() + " hit " + attacky.getName() + " for " + basicAttack + "!");
		} else {
			System.out.println(attacker.getName() + " attack missed!");
		}
	}
	
	@Override
	public String toString() {
		return "Basic Attack";
	}
}
