package by.alex.itcourses.util;

import java.util.Iterator;
import java.util.Set;

import by.alex.itcourses.entity.Client;
import by.alex.itcourses.entity.Prediction;
import by.alex.itcourses.entity.Predictor;

public class Assistant {
	private Predictor predictor;
	private Client client;

	public Assistant() {
		predictor = new Predictor();
		client = new Client();
	}

	// ставит клиента в очередь
	public void getInLine(String nameClient) {
		client = new Client(nameClient);
		predictor.getInLineForMenu(client);
	}

	// полностью рандомное предсказание
	public void fullRandom() {
		// System.out.println(client); +
		Set<Prediction> setPrediction = predictor.getSetPrediction();
		Prediction prediction = client.choosePredictionRandom(setPrediction);
		// System.out.println(prediction);+
		client.askPredictorRandom(prediction, predictor);
	}

	// выбирает предсказание
	public void choosePrediction(String namePrediction) {
		Prediction prediction = null;
		Set<Prediction> setPrediction = predictor.getSetPrediction();
		Iterator<Prediction> itr = setPrediction.iterator();
		while (itr.hasNext()) {
			prediction = itr.next();
			if (prediction.getNamePred().equals(namePrediction)) {
				break;
			}
		}
		client.askPredictorForMenu(prediction, predictor);
	}

	public void delClientFromWaitList() {
		predictor.delClientFromWaitList();

	}

	public void printClientHistory() {

		client.printHistory();
	}

	public void printClientLine() {
		predictor.printClientQueue();
	}

	public void printPredictorHistory() {
		predictor.printPredictorHistory();
	}

	public void printWaitList() {
		predictor.printWaitList();
	}
}
