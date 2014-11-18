package edu.elon.math;

public class CalculatorController implements CalculatorControllerInterface {

	CalculatorModelInterface model;
	CalculatorGUI view;

	public CalculatorController() {
		model = new CalculatorModel();
		view = new CalculatorGUI(this, model);
		view.createGUI();
	}

	@Override
	public void doExpression() {
		if (model.checkValidity(view.getText())) {
			model.setCurrentNumber(view.getText());
			model.doExpression();
			view.setEqualsDisabled();
			view.setOperationEnabled();
		}
	}

	@Override
	public void updateNumber(String num) {
		model.setCurrentNumber(view.getText());
		model.createString(num);
	}

	@Override
	public void updateOperation(String operation) {
		if (model.checkValidity(view.getText())) {
			model.setCurrentNumber(view.getText());
			model.setCurrentOperation(operation);
			view.setEqualsEnabled();
			view.setOperationDisabled();
		}
	}

}
