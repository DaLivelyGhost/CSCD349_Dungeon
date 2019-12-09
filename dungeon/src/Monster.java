public abstract class Monster extends DungeonCharacter{
   private int hpPerTurn;
   public Monster(String name, int hp, int attackSpeed, 
                  double hitChance, int minDamage, int maxDamage, 
                  double healChance, int minheal, int maxheal)
   {
      super(name, hp, attackSpeed, hitChance, minDamage, maxDamage);
      this.healChance = healChance;
   	this.maxHeal = maxHeal;
   	this.minHeal = minHeal;
   }
   
   
   public void setHpPerTurn(int hpPerTurn)
   {
      this.hpPerTurn;
   }
   
   public int getHpPerTurn()
   {
      return hpPerTurn;
   }
   
   //MUST WORK ON HEAL FOR MONSTERS 
   public void heal()
   {
	   boolean canHeal;
	   int healPoints;

	   canHeal = (Math.random() <= healChance) && (hitPoints > 0);

	   if(canHeal)
	   {
		   healPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
		   addHitPoints(healPoints);
		   System.out.println(name + " healed itself for " + healPoints + " points.\n"
							   + "Total hit points remaining are: " + hitPoints);
		   System.out.println();
	   }//end can heal
   }//end heal method
