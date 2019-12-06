
public class HealthPoints extends DungeonCharacter{
	
	//Add Hp to a dungeonCharacter
	public void addHealth(int hp) {
		
		if(this.hp <= 0) {
			System.out.println("HP must be above 0 to heal, how are you alive?");
		} else {
			this.hp += hp;
			System.out.println("You have healed and now are at " + this.hp);
		}
	}
	
	public void subtractHealth(int hp, DungeonCharacter that) {
		
		this.hp -= hp;
			
		System.out.println(that.name + " hit " + " for <" + hp + "> points damage.");
		System.out.println(this.name + " now has " + this.hp + " hit points remaining.");
		System.out.println();
		
		if(this.hp <= 0) {
			System.out.println(getName() + " is dead, you have lost...");
			//game end
		}
	}
}
