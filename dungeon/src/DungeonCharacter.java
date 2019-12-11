//FEEL FREE TO REPLACE WHEN BUILDING THE ACTUAL PRODUCT
//JUST TEMPORARY TO TEST THE GAMECYCLE/GAMESTART
public  class DungeonCharacter {
	protected  String name, characterType;
	protected int attackSpeed , minDamage, maxDamage, hp;
	protected  double hitChance; 
	public Attack specialAttack;
	
	public DungeonCharacter() {
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
	
	public void subtractHealth(int damage, DungeonCharacter that) {
		
		that.hp -= damage;
			
		System.out.println(this.name + " hit " + " for <" + hp + "> points damage.");
		System.out.println(that.name + " now has " + that.hp + " hit points remaining.");
		System.out.println();
	}
	
	public boolean isAlive() {
		return (this.hp > 0);
	}
	
	public void specialAttack(DungeonCharacter opponent) {
		specialAttack.attack(this, opponent);
	}
	
	protected void basicAttack(DungeonCharacter attacky) {
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= this.hitChance;

		if (canAttack) {
			damage = (int)(Math.random() * (this.maxDamage - this.minDamage + 1))
						+ this.minDamage ;
			subtractHealth(damage, attacky);
			System.out.println();
		}//end if can attack
		else {
			System.out.println(this.getName() + "'s attack on " + attacky.getName() + " failed!");
			System.out.println();
		}//end else
	}//end attack method
}
