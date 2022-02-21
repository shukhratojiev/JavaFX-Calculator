import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
	
	JFrame frame;
	TextField textField;
	JPanel panel;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton delButton, equButton, decButton, clrButton, minButton;
    Font myFont = new Font("Times New Roman", Font.PLAIN, 30);
    double num1=0, num2=0, result=0;
    char operator;
	
	Calculator(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 500);
		frame.setLayout(null);
		frame.setResizable(false);
		
		textField = new TextField();
		textField.setEditable(false);
		textField.setBounds(50, 20, 300, 40);
		textField.setFont(myFont);
		
		panel = new JPanel();
		panel.setBounds(50, 70, 300, 300);
		//panel.setBackground(Color.gray);
		panel.setLayout(new GridLayout(4, 4, 5, 5));
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		equButton = new JButton("=");
		decButton = new JButton(".");
		delButton = new JButton("del");
		delButton.setBounds(50, 400, 100, 30);
		clrButton = new JButton("clr");
		clrButton.setBounds(150, 400, 100, 30);
		minButton = new JButton("(-)");
		minButton.setBounds(250, 400, 100, 30);
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = delButton;
		functionButtons[5] = equButton;
		functionButtons[6] = decButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = minButton;
		
		
		for(int i = 0; i < 9; i++) {
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
			functionButtons[i].addActionListener(this);
		}
		
		for(int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i)); 
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			numberButtons[i].addActionListener(this);
		}
		
		
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		
		frame.add(panel);
		frame.add(textField);
		frame.add(delButton);
		
		frame.add(clrButton);
		frame.add(minButton);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == decButton) {
			textField.setText(textField.getText().concat("."));
		}
		
		if(e.getSource() == addButton) {
			operator = '+';
			num1 = Double.parseDouble(textField.getText());
			textField.setText("");
		}
		
		if(e.getSource() == subButton) {
			operator = '-';
			num1 = Double.parseDouble(textField.getText());
			textField.setText("");
		}
		
		if(e.getSource() == mulButton) {
			operator = '*';
			num1 = Double.parseDouble(textField.getText());
			textField.setText("");
		}
		
		if(e.getSource() == divButton) {
			operator = '/';
			num1 = Double.parseDouble(textField.getText());
			textField.setText("");
		}
		
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textField.getText());
			textField.setText("");
			
			switch(operator) {
			case '+':
				result = num1 + num2;
				textField.setText(String.valueOf(result));
				break;
			case '-':
				result = num1 - num2;
				textField.setText(String.valueOf(result));
				break;
			case '*':
				result = num1 * num2;
				textField.setText(String.valueOf(result));
				break;
			case '/':
				result = num1 / num2;
				textField.setText(String.valueOf(result));
				break;
			}
			
		}
		
		if(e.getSource() == delButton) {
			String string = textField.getText();
			textField.setText("");
			for(int i=0; i<string.length()-1; i++) {
				textField.setText(textField.getText() + string.charAt(i));
			}
		}
		
		if(e.getSource() == clrButton) {
			textField.setText("");
		}
		
		if(e.getSource() == minButton) {
			double temp = Double.parseDouble(textField.getText());
			temp*=-1;
			textField.setText(String.valueOf(temp));
		}
	}
	
	

}
