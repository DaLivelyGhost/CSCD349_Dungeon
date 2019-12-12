import java.io.Serializable;

public  class Skeleton extends Monster implements Serializable{
   public Skeleton()
   {
      this.name = "Skeleton";
      this.hp = 100;
      this.attackSpeed = 3;
      this.hitChance = .8;
      this.healChance = .3;
      this.minDamage = 30;
      this.maxDamage = 50;
      this.minHeal = 30;
      this.maxHeal = 50;

   }

}