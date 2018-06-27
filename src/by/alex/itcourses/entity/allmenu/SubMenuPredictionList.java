package by.alex.itcourses.entity.allmenu;

public class SubMenuPredictionList extends BaseMenu {

	@Override
	void showMenu() {
		System.out.println("Prediction list: ");
		System.out.println("1 - Love");
		System.out.println("2 - Life");
		System.out.println("3 - Money");
		System.out.println("4 - Previous menu");

		nextStep();
	}

	private void nextStep() {
		setChooseOperation(scanner.next());
		switch (getChooseOperation()) {
		case "1":
			assistant.choosePrediction("Love");
			break;
		case "2":
			assistant.choosePrediction("Life");
			break;
		case "3":
			assistant.choosePrediction("Money");
			break;
		case "4":
			menuQueueOrRandom.showMenu();
			break;
		default:
			System.out.println("Wrong choose Try again");
			showMenu();
		}
	}

}
