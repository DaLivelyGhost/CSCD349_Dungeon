
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
			CombatView.cantHeal();
		} else {
			this.hp += hp;
			CombatView.heal(this);
		}
	}
	
	public void subtractHealth(int damage, DungeonCharacter that) {
		that.hp -= damage;
		CombatView.CombatDamage(this, that, damage);
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
		}//end if can attack
		else {
			CombatView.failedAttack(this, attacky);
		}//end else
	}//end attack method
}
