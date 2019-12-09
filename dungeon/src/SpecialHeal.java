
public class SpecialHeal implements Attack{

	public void attack(DungeonCharacter attacker, DungeonCharacter attacky) {
		int hPoints;
		final int MIN_ADD = 25;
		final int MAX_ADD = 50;

		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		attacker.addHealth(hPoints);
		System.out.println(attacker.getName() + " added [" + hPoints + "] points.\n" + "Total hit points remaining are: " + attacker.getHp());
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "Heal";
	}

}
