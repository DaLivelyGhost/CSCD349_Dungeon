
public class CombatView {
	public static void CombatStart(DungeonCharacter attacker, DungeonCharacter attacky) {
		System.out.println(attacky.getName() + " attacks " + attacker.getName()
						+ "! Combat is inevitable!");
	}
	public static void CombatMenu(DungeonCharacter player) {
		System.out.println("1. Attack Opponent");
		System.out.println("2. " + player.specialAttack.toString());
		System.out.print("Choose an option: ");
	}
	public static void CombatSuccess(DungeonCharacter attacker, DungeonCharacter attacky) {
		System.out.println(attacker.getName() + " destroyed the " + attacky.getName());
	}
	public static void CombatFail(DungeonCharacter attacker, DungeonCharacter attacky) {
		System.out.println(attacker.getName() + " was destroyed by the " + attacky.getName());
	}
	public static void pitFall(Hero player) {
		System.out.println(player.getName() + " fell into a pit and now has " + player.hp + " left");
		GameView.printDivider();
	}
	public static void CombatDamage(DungeonCharacter attacker, DungeonCharacter attacked, int hp) {
		System.out.println(attacker.name + " hit " + attacked.name + " for <" + hp + "> points damage.");
		System.out.println(attacked.name + " now has " + attacked.hp + " hit points remaining.");
		System.out.println("");
	}
	public static void cantHeal() {
		System.out.println("HP must be above 0 to heal, how are you alive?");
	}
	public static void heal(DungeonCharacter toHeal) {
		System.out.println("You have healed and now are at " + toHeal.hp);
	}
	public static void monsterHeal(Monster m, int healPoints) {
		   System.out.println(m.name + " healed itself for " + healPoints + " points.\n"
				   + "Total hit points remaining are: " + m.hpPerTurn);
	}
	public static void failedAttack(DungeonCharacter attacker, DungeonCharacter attacky) {
		System.out.println(attacker.getName() + "'s attack on " + attacky.getName() + " failed!");
		System.out.println("");
	}
}
