//This is the view for the game start class.
//This class will not be in use after the game is initialized.
public class StartView {
	public static void gameLoad() {
		System.out.println("----GAME START----\n"
				+ "1. New Game\n"
				+ "2. Load Game");
	}
	public static void playerName() {
		System.out.println("Enter the name of your hero:");
	}
	public static void playerClass() {
		GameView.printDivider();
		System.out.println("Enter your class: \n"
				+ "1.Warrior \n"
				+ "2.Sorceress \n"
				+ "3.Thief \n"
				+ "4 Paladin\n"
				+ "5 Arcanist");
	}
	public static void dungeonSize() {
		GameView.printDivider();
		System.out.println("What size of dungeon will you explore? (must have over 6 rooms)");
	}
	public static void x() {
		System.out.print("x:");
	}
	public static void y() {
		System.out.print("y:");
	}
	public static void dungeonException(Exception e) {
		System.out.println(e);
		System.out.println("");
	}
	public static void invalidDimensions() {
		System.out.println("Please enter larger dimensions");
		System.out.println("");
	}
}
