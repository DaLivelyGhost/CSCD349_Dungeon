
public class BaseAttack implements Attack{
	
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter attacky) {
		
		boolean hitCheck = Math.random() <= attacker.hitChance;
		
		if(hitCheck == true) {
			int basicAttack = (int)(Math.random() * (attacker.maxDamage - attacker.minDamage + 1));
			attacker.subtractHealth(basicAttack, attacky);
			CombatView.CombatDamage(attacker, attacky, basicAttack);
		} else {
			CombatView.failedAttack(attacker, attacky);
		}
	}
	
	@Override
	public String toString() {
		return "Basic Attack";
	}
}
