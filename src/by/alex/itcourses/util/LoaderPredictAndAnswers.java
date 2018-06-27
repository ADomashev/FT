package by.alex.itcourses.util;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;

import by.alex.itcourses.entity.Answer;
import by.alex.itcourses.entity.Prediction;

public class LoaderPredictAndAnswers {

	public LinkedHashMap<Prediction, PriorityQueue<Answer>> loadPredictions() {
		System.out.println("LOADER");
		LinkedHashMap<Prediction, PriorityQueue<Answer>> map = new LinkedHashMap<Prediction, PriorityQueue<Answer>>();

		PriorityQueue<Answer> answ = new PriorityQueue<Answer>();
		answ.add(new Answer("Never"));
		answ.add(new Answer("Soon"));
		answ.add(new Answer("Today"));

		map.put(new Prediction("Love"), answ);

		PriorityQueue<Answer> answ1 = new PriorityQueue<Answer>();

		answ1.add(new Answer("A lot"));
		answ1.add(new Answer("Medium"));
		answ1.add(new Answer("Little"));

		map.put(new Prediction("Money"), answ1);

		PriorityQueue<Answer> answ2 = new PriorityQueue<Answer>();

		answ2.add(new Answer("You are happy"));
		answ2.add(new Answer("You are not happy"));
		answ2.add(new Answer("you will be happy"));

		map.put(new Prediction("Life"), answ2);
		
		return map;

	}

}
