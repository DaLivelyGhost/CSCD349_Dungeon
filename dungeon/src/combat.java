import java.util.Scanner;
import java.util.Random;

public class combat {
//engine for gameplay

	public static void battle(DungeonCharacter attacker, DungeonCharacter attacky) {

		Scanner input = new Scanner(System.in);

		
		CombatView.CombatStart(attacker, attacky);
		

		//do battle
		while (attacker.isAlive() && attacky.isAlive()) {
		    //hero goes first
			GameView.printDivider();
			battleChoices(attacker, attacky);

			//monster's turn (provided it's still alive!)
			if (attacky.isAlive())
			    attacky.basicAttack(attacker);
		}//end battle loop
		
		GameView.printDivider();
		if (!attacky.isAlive()) {
		    CombatView.CombatSuccess(attacker, attacky);

		}else if (!attacker.isAlive()) {
			CombatView.CombatFail(attacker, attacky);
		}
		GameView.printDivider();
	}//end battle method

	//Hero picks an attack style, attacks go through, and continues until one wins.
    public static void battleChoices(DungeonCharacter attacker, DungeonCharacter attacky) {
		int choice = 0;
		Scanner attack = new Scanner(System.in);
		CombatView.CombatMenu(attacker);
		   
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
		GameView.printDivider();
		if(choice == 1) {
			attacker.basicAttack(attacky);
		} else if (choice == 2) {
			attacker.specialAttack(attacky);
		}
    }//end battleChoices method
}