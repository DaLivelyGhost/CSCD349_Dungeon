
public class CrushingBlow implements Attack{

	@Override
	public void attack(DungeonCharacter attacker, DungeonCharacter attacky) {
		
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(attacker.getName() + " lands a CRUSHING BLOW for " + blowPoints + " damage!");
			attacker.subtractHealth(blowPoints, attacky);
		}//end blow succeeded
		else
		{
			System.out.println(attacker.getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed
	}
	
	@Override
	public String toString() {
		return "Crushing Blow";
	}
}
