package by.alex.itcourses.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

import by.alex.itcourses.util.LoaderPredictAndAnswers;

public class Predictor {

	private Map<Prediction, PriorityQueue<Answer>> predAnsw;
	private PriorityQueue<Client> clientQueue;
	private Map<Date, Client> clientHistory;
	private List<Client> waitList;

	private List<Client> randomClients;

	private int predictionCount = 0;

	public Predictor() {
		predAnsw = loadPrediction();
		clientQueue = new PriorityQueue<>();
		clientHistory = new HashMap<>();
		waitList = new ArrayList<Client>();

		randomClients = new ArrayList<Client>();
	}

	public void printPredictorHistory() {
		Set<Entry<Date, Client>> entrySet = clientHistory.entrySet();
		Iterator<Entry<Date, Client>> itr = entrySet.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	public void getInLine(Client client) {
		clientQueue.add(client);

		randomClients.add(client);
	}

	public void getInLineForMenu(Client client) {
		clientQueue.add(client);

	}

	// Change sysout toString
	public void printPrediction() {
		Iterator<Prediction> itr = predAnsw.keySet().iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	public Client nextClient() {
		return clientQueue.poll();
	}

	public Client delClientFromWaitList() {
		if (waitList.size() > 0) {
			return waitList.remove(0);
		} else {
			return null;
		}
	}

	public void addRandomClient() {
		Client client = null;
		int randomCount = new Random().nextInt(10);
		client = randomClients.get(randomCount);

		clientQueue.add(client);
	}

	public void printEntryPredictingAndAnswer() {
		Set<Entry<Prediction, PriorityQueue<Answer>>> entrySet = predAnsw.entrySet();
		for (Entry<Prediction, PriorityQueue<Answer>> entry : entrySet) {
			System.out.println(entry);
		}
	}

	// returns Set of prediction and answers
	public Set<Prediction> getSetPrediction() {
		return predAnsw.keySet();
	}

	// prints list predictions in console
	public void printListPrediction() {
		System.out.println(predAnsw.keySet());
	}

	// load predictions and answers
	public Map<Prediction, PriorityQueue<Answer>> loadPrediction() {
		LoaderPredictAndAnswers loader = new LoaderPredictAndAnswers();
		predAnsw = loader.loadPredictions();
		return predAnsw;
	}

	public Answer predicting(Prediction prediction, Client client) {
		predictionCount++;
		setHistoryPrediction(client);
		return randomAnswer(getListAnswers(prediction));
	}

	public void printClientQueue() {
		Iterator<Client> iter = clientQueue.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	public void printWaitList() {
		Iterator<Client> itr = waitList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	public void removeClientFromQueue(int number) {
		Client client = null;
		Iterator<Client> iter = clientQueue.iterator();
		while (number >= 0) {
			client = iter.next();
			number--;
		}
		clientQueue.remove(client);
	}

	private void addClientToWaitList(Client client) {
		if (!waitList.contains(client))
			waitList.add(client);
	}

	public boolean canGetPrediction(Prediction prediction, Client client) {
		if (!client.isToBeOrNotToBe() & predictionCount < 10) {
			return true;
		} else {
			addClientToWaitList(client);
			return false;
		}
	}

	private PriorityQueue<Answer> getListAnswers(Prediction prediction) {
		return predAnsw.get(prediction);
	}

	private Answer randomAnswer(PriorityQueue<Answer> answers) {
		Answer answer = null;
		int numberAnsw = new Random().nextInt(3);
		Iterator<Answer> iter = answers.iterator();
		while (numberAnsw >= 0) {
			answer = iter.next();
			numberAnsw--;
		}
		return answer;
	}

	private void setHistoryPrediction(Client client) {
		Date date = Calendar.getInstance().getTime();
		clientHistory.put(date, client);
	}

	public int getPredictionCount() {
		return predictionCount;
	}

	public void setPredictionCount(int predictionCount) {
		this.predictionCount = predictionCount;
	}

	public Queue<Client> getClientQueue() {
		return clientQueue;
	}

	public Map<Date, Client> getClientPred() {
		return clientHistory;
	}

}
