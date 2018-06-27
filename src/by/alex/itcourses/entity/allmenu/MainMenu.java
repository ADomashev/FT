package by.alex.itcourses.entity.allmenu;

public class MainMenu extends BaseMenu {

	// private String chooseOperation;

	@Override
	public void showMenu() {
		System.out.println("Main menu: ");
		System.out.println("1 - Go to FortuneTeller");
		System.out.println("2 - Settings");
		System.out.println("3 - Exit");

		nextStep();
	}

	private void nextStep() {
		super.setChooseOperation(scanner.next());
		switch (getChooseOperation()) {
		case "1":
			menuQueueOrRandom = new SubMenuQueueOrRandom();
			menuQueueOrRandom.showMenu();
			break;
		case "2":
			menuSettings = new SubMenuSettings();
			menuSettings.showMenu();
			break;
		case "3":
			System.exit(0);
			break;
		default:
			System.out.println("Wrong choose Try again");
			showMenu();
		}
	}
}
