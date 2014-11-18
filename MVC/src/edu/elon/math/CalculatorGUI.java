package edu.elon.math;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorGUI implements ActionListener, Observer {

	private JTextField field;

	private JButton zero;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton add;
	private JButton subtract;
	private JButton multiply;
	private JButton divide;
	private JButton equals;
	private JButton decimal;

	private CalculatorControllerInterface controller;
	private CalculatorModelInterface model;
	
	public CalculatorGUI(CalculatorControllerInterface controller, CalculatorModelInterface model) {
		this.controller = controller;
		this.model = model;
		model.registerObserver((Observer) this);
	}

	public void createGUI() {
		JFrame calculatorFrame = new JFrame("Calculator");
		calculatorFrame.setLayout(new BorderLayout());
		calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculatorFrame.setSize(800, 800);

		JPanel viewPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		viewPanel.setLayout(new BorderLayout());
		field = new JTextField();
		field.setText("");
		viewPanel.add(field, BorderLayout.CENTER);

		buttonPanel.setLayout(new GridLayout(4, 4));
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		divide = new JButton("/");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		multiply = new JButton("*");
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		subtract = new JButton("-");
		zero = new JButton("0");
		decimal = new JButton(".");
		equals = new JButton("=");
		add = new JButton("+");

		buttonPanel.add(seven);
		buttonPanel.add(eight);
		buttonPanel.add(nine);
		buttonPanel.add(divide);
		buttonPanel.add(four);
		buttonPanel.add(five);
		buttonPanel.add(six);
		buttonPanel.add(multiply);
		buttonPanel.add(one);
		buttonPanel.add(two);
		buttonPanel.add(three);
		buttonPanel.add(subtract);
		buttonPanel.add(zero);
		buttonPanel.add(decimal);
		buttonPanel.add(equals);
		buttonPanel.add(add);

		zero.addActionListener(this);
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		add.addActionListener(this);
		subtract.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);
		decimal.addActionListener(this);
		equals.addActionListener(this);
		
		equals.setEnabled(false);
		
		calculatorFrame.getContentPane().add(viewPanel, BorderLayout.NORTH);
		calculatorFrame.getContentPane().add(buttonPanel, BorderLayout.CENTER);
		calculatorFrame.pack();
		calculatorFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == zero) {
			controller.updateNumber("0");
		}
		if(e.getSource() == one) {
			controller.updateNumber("1");
		}
		if(e.getSource() == two) {
			controller.updateNumber("2");
		}
		if(e.getSource() == three) {
			controller.updateNumber("3");
		}
		if(e.getSource() == four) {
			controller.updateNumber("4");
		}
		if(e.getSource() == five) {
			controller.updateNumber("5");
		}
		if(e.getSource() == six) {
			controller.updateNumber("6");
		}
		if(e.getSource() == seven) {
			controller.updateNumber("7");
		}
		if(e.getSource() == eight) {
			controller.updateNumber("8");
		}
		if(e.getSource() == nine) {
			controller.updateNumber("9");
		}
		if(e.getSource() == decimal) {
			controller.updateNumber(".");
		}
		if(e.getSource() == add) {
			controller.updateOperation("+");
		}
		if(e.getSource() == subtract) {
			controller.updateOperation("-");
		}
		if(e.getSource() == multiply) {
			controller.updateOperation("*");
		}
		if(e.getSource() == divide) {
			controller.updateOperation("/");
		}
		if(e.getSource() == equals) {
			controller.doExpression();
		}
	}
	
	public void setOperationEnabled() {
		add.setEnabled(true);
		subtract.setEnabled(true);
		multiply.setEnabled(true);
		divide.setEnabled(true);
	}
	
	public void setOperationDisabled() {
		add.setEnabled(false);
		subtract.setEnabled(false);
		multiply.setEnabled(false);
		divide.setEnabled(false);
	}
	
	public void setEqualsEnabled() {
		equals.setEnabled(true);
	}
	
	public void setEqualsDisabled() {
		equals.setEnabled(false);
	}
	
	public String getText() {
		return field.getText();
	}
	
	@Override
	public void update() {
		field.setText(model.getCurrentNumber());
	}
}
