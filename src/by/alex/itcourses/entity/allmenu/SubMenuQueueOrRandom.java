package by.alex.itcourses.entity.allmenu;

public class SubMenuQueueOrRandom extends BaseMenu {
	
	MainMenu menuMain = new MainMenu();
	
	
	public SubMenuQueueOrRandom() {
		
	}

	@Override
	public void showMenu() {
		System.out.println("Random or choice: ");
		System.out.println("1 - Get in line");
		System.out.println("2 - Choose your destiny");
		System.out.println("3 - Previous menu");
		
		nextStep();
	}
	
	private void nextStep() {
		String name=null;
		setChooseOperation(scanner.next());
		switch(getChooseOperation()) {
		case "1":
			SubMenuPredictionList list = new SubMenuPredictionList();
			System.out.println("Enter your name : ");
			name = scanner.next();
			assistant.getInLine(name);
			list.showMenu();
			break;
		case "2":
			System.out.println("Enter your name : ");
			name = scanner.next();
//			name = scanner.nextLine();
			assistant.getInLine(name);
			assistant.fullRandom();
			break;
		case "3":
			menuMain.showMenu();
			break;
		default: System.out.println("Wrong choose Try again");
		showMenu();
		}
		menuMain.showMenu();
	}
}
