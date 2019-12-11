import java.util.Scanner;
public class combat {
//engine for gameplay

	public static void battle(DungeonCharacter attacker, DungeonCharacter attacky) {

		Scanner input = new Scanner(System.in);
		
		System.out.println(attacker.getName() + " battles " + attacky.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (attacker.isAlive() && attacky.isAlive()) {
		    //hero goes first
			battleChoices(attacker, attacky);

			//monster's turn (provided it's still alive!)
			if (attacky.isAlive())
			    attacky.basicAttack(attacker);
		}//end battle loop

		if (!attacky.isAlive())
		    System.out.println(attacker.getName() + " destroyed the " + attacky.getName());
		else if (!attacker.isAlive())
			System.out.println(attacker.getName() + " was destroyed by the " + attacky.getName());
	}//end battle method

	//Hero picks an attack style, attacks go through, and continues until one wins.
    public static void battleChoices(DungeonCharacter attacker, DungeonCharacter attacky) {
		int choice = 0;
		Scanner attack = new Scanner(System.in);

		    System.out.println("1. Attack Opponent");
		    System.out.println("2. " + attacker.specialAttack.toString());
		    System.out.print("Choose an option: ");

		   if(choice == 1) {
			   attacker.basicAttack(attacky);
		   } else if (choice == 2) {
			   attacker.specialAttack(attacky);
		   } else {
			   System.out.println("That was not a valid option!\n");
			   battleChoices(attacker, attacky);
		   }
    }//end battleChoices method
}