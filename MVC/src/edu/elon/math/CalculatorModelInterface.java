package edu.elon.math;

public interface CalculatorModelInterface {
	
	public boolean checkValidity(String num);
	
	public void createString(String num);
	
	public void doExpression();
	
	public void setCurrentNumber(String num);
	
	public void setCurrentOperation(String operation);
	
	public String getCurrentNumber();
	
	public void registerObserver(Observer o);
	
	public void removeObserver(Observer o);
	
	public void notifyObservers();
}
