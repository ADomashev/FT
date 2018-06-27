package by.alex.itcourses.entity.allmenu;

public class SubMenuSettings extends BaseMenu {
	protected MainMenu menuMain ;
	@Override
	void showMenu() {
		System.out.println("Menu settings: ");
		System.out.println("1 - Look at clients line");
		System.out.println("2 - Look at Predictor history");
		System.out.println("3 - Look at waitList");
		System.out.println("4 - Delete client fromWaitList");
		System.out.println("5 - Look at Client history");
		System.out.println("6 - Previous menu");
		
		nextStep();
	}

	private void nextStep() {
		setChooseOperation(scanner.next());
		switch (getChooseOperation()) {
		case "1":
			assistant.printClientLine();
			showMenu();
			break;
		case "2":
			assistant.printPredictorHistory();
			showMenu();
			break;
		case "3":
			assistant.printWaitList();
			showMenu();
			break;
		case "4":
			assistant.delClientFromWaitList();
			showMenu();
			break;
		case "5":
			assistant.printClientHistory();
			showMenu();
			break;
		case "6":
			menuMain = new MainMenu();
			menuMain.showMenu();
			break;
		default:
			System.out.println("Wrong choose Try again");
			showMenu();
		}
		
	}
}
