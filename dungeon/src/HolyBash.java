
public class HolyBash implements Attack{
	
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter attacky) {
		
		if (Math.random() <= .5)
		{	
			//change to half paladins attack
			int shieldbash = (int)(Math.random() * 76) + 100;
			System.out.println(attacker.getName() + " hits the monster with their shield for " + shieldbash + " damage!");
			attacker.subtractHealth(shieldbash, attacky);
			//heal for 1/4 of the hp
			System.out.println(attacker.getName() + " heals for a quarter of thier hp!");
			attacker.addHealth(20);
		}//end blow succeeded
		else
		{
			System.out.println(attacker.getName() + " failed to land a Holy Shield Bash");
			System.out.println();
		}//blow failed
	}
	
	@Override
	public String toString() {
		return "Holy Shield Bash";
	}
}
