//FEEL FREE TO REPLACE WHEN BUILDING THE ACTUAL PRODUCT
//JUST TEMPORARY TO TEST THE GAMECYCLE/GAMESTART
public  class DungeonCharacter {
	protected  String name;
	protected int attackSpeed , minDamage, maxDamage, hp;
	protected  double hitChance; 
	
	public DungeonCharacter() {
		this.name = name;
		this.hp = hp;
		this.attackSpeed = attackSpeed;
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
}
