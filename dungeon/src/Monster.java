public abstract class Monster extends DungeonCharacter{
   protected int minHeal,maxHeal;
   protected double healChance;
   protected int hpPerTurn;
   
   public Monster()
   {
      this.healChance = healChance;
      this.minHeal = minHeal;
      this.maxHeal = maxHeal;
   }
   
   public void setHealChance(double healChance)
   {
      this.healChance = healChance;
   }
   
   public double getHealChance()
   {
      return healChance;
   }
   
   public void setMinHeal(int minHeal)
   {
      this.minHeal = minHeal;
   }
   
   public int getMinHeal()
   {
      return minHeal;
   }
   
   public void setMaxHeal(int maxHeal)
   {
      this.maxHeal = maxHeal;
   }
   
   public int getMaxHeal()
   {
      return maxHeal;
   }
   
   public void setHpPerTurn(int hpPerTurn)
   {
      this.hpPerTurn = hpPerTurn;
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

	   canHeal = (Math.random() <= healChance) && (hpPerTurn > 0);

	   if(canHeal)
	   {
		   healPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
		   addHealth(healPoints);
		   System.out.println(name + " healed itself for " + healPoints + " points.\n"
							   + "Total hit points remaining are: " + hpPerTurn);
		   System.out.println();
	   }//end can heal
   }//end heal method
}   
