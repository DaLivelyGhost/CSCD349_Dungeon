
public class MonsterFactory extends Monster{
   Monster makeMonster(String type)
   {
      if(type.equals("Ogre")
      {
         return new Ogre();
      }
      else if(type.equals("Goblin")
      {
         return new Goblin();
      }
      else if(type.equals("Gremlin")
      {
         return new Gremlin();
      }
      else if(type.equals("Skeleton")
      {
         return new Skeleton();
      }
      else if(type.equals("Zombie")
      {
         return new Zombie();
      }
   }
}
