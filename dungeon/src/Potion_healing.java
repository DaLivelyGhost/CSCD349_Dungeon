
public class Potion_healing {
	//Change DungeonCharacter to Hero once Hero is made, maybe make it extend hero.
	DungeonCharacter dungeoncharacter;
	private int healingPotion;
	
	public Potion_healing() {
		this.healingPotion = healingPotion;
	}
	
	public void getHealingPotion() {
		healingPotion++;
	}
	
	public void useHealingPotion() {
		dungeoncharacter.hp = dungeoncharacter.getHp() + 10;
		System.out.println("You used the healing potion and healed for 10 hp!");
	}
}
