package by.alex.itcourses.entity.allmenu;

import java.util.Scanner;

import by.alex.itcourses.util.Assistant;
import by.alex.itcourses.util.AssistantSingleton;
import by.alex.itcourses.util.ScannerSingleton;

public abstract class BaseMenu {

	private String chooseOperation;

	protected Assistant assistant = AssistantSingleton.ASSISTANT.getInstance();;
	protected Scanner scanner = ScannerSingleton.SCANNER_INSTANCE.getInstance();;
	protected MainMenu menuMain;
	protected SubMenuPredictionList menuListPrediction;
	protected SubMenuQueueOrRandom menuQueueOrRandom;
	protected SubMenuSettings menuSettings;

	BaseMenu() {

	}

	abstract void showMenu();

	public String getChooseOperation() {
		return chooseOperation;
	}

	public void setChooseOperation(String chooseOperation) {
		this.chooseOperation = chooseOperation;
	}

}
