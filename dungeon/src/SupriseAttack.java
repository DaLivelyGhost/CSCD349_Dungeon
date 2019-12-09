
public class SupriseAttack implements Attack{
	
	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter attacky) {
		
		if (Math.random() <= .4)
		{
			//change to double thiefs attack
			int crit = (int)(Math.random() * 76) + 100;
			System.out.println(attacker.getName() + " CRITS for double damage!");
			attacker.subtractHealth(crit, attacky);
		}//end crit succeeded
		else
		{
			System.out.println(attacker.getName() + " failed to land a crit");
			System.out.println();
		}//blow failed
	}
	
	@Override
	public String toString() {
		return "Suprise Attack";
	}
}
