package edu.elon.math;

import java.util.ArrayList;

public class CalculatorModel implements CalculatorModelInterface { 
	
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	private String previousNumber;
	private String currentNumber;
	private String operation;
	
	public CalculatorModel() {
		currentNumber = "";
	}
	
	@Override 
	public void setCurrentOperation(String operation) {
		this.operation = operation;
		previousNumber = currentNumber;
		setCurrentNumber("");
	}
	
	@Override
	public void createString(String num) {
		if(checkValidity(getCurrentNumber() + num)) {
			setCurrentNumber(getCurrentNumber() + num);
		}
	}
	
	@Override
	public boolean checkValidity(String num) {		
		try {
			Double.parseDouble(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	@Override
	public void doExpression() {
		
		double current = Double.parseDouble(currentNumber);
		double prev = Double.parseDouble(previousNumber);
		
		switch (operation) {
			case "+" : 
				setCurrentNumber((prev + current) + "");
				previousNumber = null;
				operation = null;
				break;
			case "-" : 
				setCurrentNumber((prev - current) + "");
				previousNumber = null;
				operation = null;
				break;
			case "*" : 
				setCurrentNumber((prev * current) + "");
				previousNumber = null;
				operation = null;
				break;
			case "/" : 
				setCurrentNumber((prev / current) + "");
				previousNumber = null;
				operation = null;
				break;
		}
	}

	@Override
	public String getCurrentNumber() {
		return currentNumber;
	}
	
	@Override
	public void setCurrentNumber(String num) {
		currentNumber = num;
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(int i = 0; i < observers.size(); i++) {
			observers.get(i).update();
		}
	}
}
