//FEEL FREE TO REPLACE WHEN BUILDING THE ACTUAL PRODUCT
//JUST TEMPORARY TO TEST THE GAMECYCLE/GAMESTART
public  class DungeonCharacter {
	protected  String name, characterType;
	protected int attackSpeed , minDamage, maxDamage, hp;
	protected  double hitChance; 
	
	public DungeonCharacter() {
		this.setName(name);
		this.setName(name);
		this.characterType = characterType;
		this.hp = hp;
		this.attackSpeed = attackSpeed;
		this.hitChance = hitChance;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public int getHp() {
		return hp;
	}
	
	public int getAttackSpeed() {
		return attackSpeed;
	}
	
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
			
		System.out.println(this.name + " hit " + " for <" + hp + "> points damage.");
		System.out.println(that.name + " now has " + that.hp + " hit points remaining.");
		System.out.println();
		
		if(this.hp <= 0) {
			System.out.println(getName() + " is dead, you have lost...");
			//game end
		}
	}
}
