import java.util.Scanner;
import java.util.Random;
public class combat {
//engine for gameplay

	public static void battle(DungeonCharacter attacker, DungeonCharacter attacky) {

		Scanner input = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println(attacker.getName() + " battles " + attacky.getName());
		GameView.printDivider();

		//do battle
		while (attacker.isAlive() && attacky.isAlive()) {
		    //hero goes first
			battleChoices(attacker, attacky);

			//monster's turn (provided it's still alive!)
			if (attacky.isAlive())
			    attacky.basicAttack(attacker);
		}//end battle loop
		
		GameView.printDivider();
		if (!attacky.isAlive()) {
		    System.out.println(attacker.getName() + " destroyed the " + attacky.getName());
			int reward = r.nextInt(11);
			if(reward > 7) {
				//Give player a health pot
			}
		}else if (!attacker.isAlive()) {
			System.out.println(attacker.getName() + " was destroyed by the " + attacky.getName());
		}
	}//end battle method

	//Hero picks an attack style, attacks go through, and continues until one wins.
    public static void battleChoices(DungeonCharacter attacker, DungeonCharacter attacky) {
		int choice = 0;
		Scanner attack = new Scanner(System.in);

		System.out.println("1. Attack Opponent");
		System.out.println("2. " + attacker.specialAttack.toString());
		System.out.print("Choose an option: ");
		    
		while(choice == 0) { 
			try {
				choice = attack.nextInt();
				attack.nextLine();
				
				if(choice != 1 && choice != 2) {
					GameView.invalidInput();
					choice = 0;
				}
			}
			catch(Exception e) {
				e = new Exception("Invalid input type!");
				GameView.printException(e);
				choice = 0;
			}
		}
		if(choice == 1) {
			attacker.basicAttack(attacky);
		} else if (choice == 2) {
			attacker.specialAttack(attacky);
		}
    }//end battleChoices method
}