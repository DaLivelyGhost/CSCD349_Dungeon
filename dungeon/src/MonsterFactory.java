
public class MonsterFactory extends Monster
{
   static Monster makeMonster(String type)
   {
	  Monster monster = null;
	  
      if(type.equals("Ogre"))
      {
         monster = new Ogre();
      }
      else if(type.equals("Goblin"))
      {
         monster = new Goblin();
      }
      else if(type.equals("Gremlin"))
      {
         monster = new Gremlin();
      }
      else if(type.equals("Skeleton"))
      {
         monster = new Skeleton();
      }
      else if(type.equals("Zombie"))
      {
         monster = new Zombie();
      }
      return monster;
   }
}
