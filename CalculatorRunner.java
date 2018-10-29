import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
public class CalculatorRunner {
	public static void main(String[] args){
    	final JFrame frame = new JFrame();
    	frame.setSize(750, 750);
    	frame.setTitle("Calculator");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setFocusable(true);
    	frame.setLayout(new BorderLayout());
    	JPanel output = new JPanel();
    	output.setLayout(new BoxLayout(output, BoxLayout.PAGE_AXIS));
    	final JTextArea input = new JTextArea("Question: ", 6, 60);
    	input.setEditable(false);
    	JScrollPane scroll = new JScrollPane(input);
    	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	output.add(scroll);
    	frame.add(output, BorderLayout.NORTH);
    	Border b = BorderFactory.createLineBorder(new Color(6,17,87), 10);
    	output.setBorder(b);
    	JPanel buttons = new JPanel();
    	buttons.setBorder(b);
    	JButton b0 = new JButton("0");
    	class b0Listener implements ActionListener{
        	public void actionPerformed(ActionEvent arg0){
            	input.append("0");
        	}
    	}
    	b0.addActionListener(new b0Listener());
    	JButton b1 = new JButton("1");
    	class b1Listener implements ActionListener{
        	public void actionPerformed(ActionEvent e){
            	input.append("1");
        	}
    	}
    	b1.addActionListener(new b1Listener());
    	JButton b2 = new JButton("2");
    	class b2Listener implements ActionListener{
        	public void actionPerformed(ActionEvent arg0){
            	input.append("2");
        	}
    	}
    	b2.addActionListener(new b2Listener());
    	JButton b3 = new JButton("3");
    	class b3Listener implements ActionListener{
        	public void actionPerformed(ActionEvent arg0){
            	input.append("3");
        	}
    	}
    	b3.addActionListener(new b3Listener());
    	JButton b4 = new JButton("4");
    	class b4Listener implements ActionListener{
        	public void actionPerformed(ActionEvent arg0){
            	input.append("4");
        	}
    	}
    	b4.addActionListener(new b4Listener());
    	JButton b5 = new JButton("5");
    	class b5Listener implements ActionListener{
        	public void actionPerformed(ActionEvent arg0){
            	input.append("5");
        	}
    	}
    	b5.addActionListener(new b5Listener());
    	JButton b6 = new JButton("6");
    	class b6Listener implements ActionListener{
        	public void actionPerformed(ActionEvent arg0){
            	input.append("6");
        	}
    	}
    	b6.addActionListener(new b6Listener());
    	JButton b7 = new JButton("7");
    	class b7Listener implements ActionListener{
        	public void actionPerformed(ActionEvent arg0){
            	input.append("7");
        	}
    	}
    	b7.addActionListener(new b7Listener());
    	JButton b8 = new JButton("8");
    	class b8Listener implements ActionListener{
        	public void actionPerformed(ActionEvent arg0){
            	input.append("8");
        	}
    	}
    	b8.addActionListener(new b8Listener());
    	JButton b9 = new JButton("9");
    	class b9Listener implements ActionListener{
        	public void actionPerformed(ActionEvent arg0){
            	input.append("9");
        	}
    	}
    	b9.addActionListener(new b9Listener());
    	JButton bDecimal = new JButton(".");
    	class bDecimalListener implements ActionListener{
        	public void actionPerformed(ActionEvent arg0){
            	input.append(".");
        	}
    	}
    	bDecimal.addActionListener(new bDecimalListener());
    	JButton bReset = new JButton("C");
    	class bResetListener implements ActionListener{
        	public void actionPerformed(ActionEvent arg0){
            	input.setText("Question: ");
        	}
    	}
    	bReset.addActionListener(new bResetListener());
    	JButton bClearEntry = new JButton("CE");
    	class bClearEntryListener implements ActionListener{
        	public void actionPerformed(ActionEvent arg0){
            	String temp = input.getText();
            	if (temp.indexOf("\n") == -1){
                	return;
            	}
            	if (temp.lastIndexOf("\n") < temp.length()-1){
                	input.setText(input.getText().substring(0, temp.lastIndexOf("\n")));
                	temp = input.getText();
            	}
            	int first = temp.length()-1;
            	while(first > 0 && !temp.substring(first-1, first).equals("\n")){
                	first--;
            	}
            	input.setText(input.getText().substring(0, first));
            	temp = input.getText();
            	if (temp.length() < 1){
                	return;
            	}
            	first = temp.length()-1;
            	while(first > 0 && !temp.substring(first-1, first).equals("\n")){
                	first--;
            	}
            	input.setText(input.getText().substring(0, first) + "Question: ");
        	}
    	}
    	bClearEntry.addActionListener(new bClearEntryListener());
    	JButton bDelete = new JButton("DEL");
    	class bDeleteListener implements ActionListener{
        	public void actionPerformed(ActionEvent e){
            	if (!input.getText().substring(input.getText().length()-1, input.getText().length()).equals(" "))
                    	input.setText(input.getText().substring(0, input.getText().length()-1));
        	}
    	}
    	bDelete.addActionListener(new bDeleteListener());
    	JButton bOff = new JButton("Off");
    	class bOffListener implements ActionListener{
        	public void actionPerformed(ActionEvent e){
            	System.exit(0);
        	}
    	}
    	bOff.addActionListener(new bOffListener());
    	JButton bEnter = new JButton("=");
    	class bEnterListener implements ActionListener{
        	public void actionPerformed(ActionEvent arg0){
            	if (input.getText().length() == 0 || input.getText().substring(input.getText().length()-1).equals(" ")){
                	return;
            	}
            	String temp = input.getText();
            	int first = temp.length()-1;
            	while(first > 0 && !temp.substring(first-1, first).equals(" ")){
                	first--;
            	}
            	temp = temp.substring(first);
            	input.append("\nAnswer: " + solve(temp) + "\nQuestion: ");
        	}
        	public String solve(String input){
            	String answer = input;
            	if (answer.indexOf("x") != -1){
                	answer = multiply(answer);
                	if (answer.contains("ERROR")){
                    	return "ERROR";
                	}
            	}
            	if (answer.indexOf("*") != -1){
                	answer = multiply2(answer);
                	if (answer.contains("ERROR")){
                    	return "ERROR";
                	}
            	}
            	if (answer.indexOf("/") != -1){
                	answer = divide(answer);
                	if (answer.contains("ERROR")){
                    	return "ERROR";
                	}
            	}
            	if (answer.indexOf("+") != -1){
                	answer = add(answer);
                	if (answer.contains("ERROR")){
                    	return "ERROR";
                	}
            	}
            	if (answer.indexOf("-") != -1 && !answer.substring(0, 1).equals("-") || answer.indexOf("-") < answer.lastIndexOf("-")){
                	answer = subtract(answer);
                	if (answer.contains("ERROR")){
                    	return "ERROR";
                	}
            	}
            	while (answer.indexOf(".")<answer.lastIndexOf(".")){
            	answer = answer.substring(0, answer.indexOf(".")) + answer.substring(answer.indexOf(".")+1);
            	}
            	if (answer.equals(".")){
                	return "ERROR";
            	}
            	return answer;
            	}
            	public String multiply(String answer){
                 	int x = answer.indexOf("x");
                 	int count1 = x;
                 	while(count1 >=1 && (answer.substring(count1-1,count1).compareTo("0")>=0 && answer.substring(count1-1,count1).compareTo("9")<=0 || answer.substring(count1-1,count1).equals(".") || answer.substring(count1-1, count1).equals("-"))){
                 	count1--;
                 	}
                 	String temp1 = answer.substring(count1,x);
                 	while (temp1.indexOf(".") < temp1.lastIndexOf(".")){
                 	temp1 = temp1.substring(0, temp1.indexOf(".")) + temp1.substring(temp1.indexOf(".")+1);
                 	}
                 	if (temp1.length() == 0){
                 	return "ERROR";
                 	}
                 	double first = Double.parseDouble(temp1);
                 	int count2 = x+1;
                 	while(count2 < answer.length() && (answer.substring(count2,count2+1).compareTo("0")>=0 && answer.substring(count2,count2+1).compareTo("9")<=0 || answer.substring(count2,count2 + 1).equals("."))){
                 	count2++;
                 	}
                 	String temp2 = answer.substring(x+1, count2);
                 	while (temp2.indexOf(".") < temp2.lastIndexOf(".")){
                 	temp2 = temp2.substring(0, temp2.indexOf(".")) + temp2.substring(temp2.indexOf(".")+1);
                 	}
                 	if (temp2.length() == 0){
                 	return "ERROR";
                 	}
                 	double second = Double.parseDouble(temp2);
                 	double product = first*second;
                 	answer = answer.substring(0,count1) + product + answer.substring(count2);
                 	return answer;
            	}
            	public String multiply2(String answer){
                	int x = answer.indexOf("*");
                	int count1 = x;
                	while(count1 >=1 && (answer.substring(count1-1,count1).compareTo("0")>=0 && answer.substring(count1-1,count1).compareTo("9")<=0 || answer.substring(count1-1,count1).equals(".") || answer.substring(count1-1, count1).equals("-"))){
                	count1--;
                	}
                	String temp1 = answer.substring(count1,x);
                	while (temp1.indexOf(".") < temp1.lastIndexOf(".")){
                	temp1 = temp1.substring(0, temp1.indexOf(".")) + temp1.substring(temp1.indexOf(".")+1);
                	}
                	if (temp1.length() == 0){
                	return "ERROR";
                	}
                	double first = Double.parseDouble(temp1);
                	int count2 = x+1;
                	while(count2 < answer.length() && (answer.substring(count2,count2+1).compareTo("0")>=0 && answer.substring(count2,count2+1).compareTo("9")<=0 || answer.substring(count2,count2 + 1).equals("."))){
                	count2++;
                	}
                	String temp2 = answer.substring(x+1, count2);
                	while (temp2.indexOf(".") < temp2.lastIndexOf(".")){
                	temp2 = temp2.substring(0, temp2.indexOf(".")) + temp2.substring(temp2.indexOf(".")+1);
                	}
                	if (temp2.length() == 0){
                	return "ERROR";
                	}
                	double second = Double.parseDouble(temp2);
                	double product = first*second;
                	answer = answer.substring(0,count1) + product + answer.substring(count2);
                	return answer;
            	}
            	public String divide(String answer){
                	int slash = answer.indexOf("/");
                	int count1 = slash;
                	while(count1 >=1 && (answer.substring(count1-1,count1).compareTo("0")>=0 && answer.substring(count1-1,count1).compareTo("9")<=0 || answer.substring(count1-1,count1).equals(".") || answer.substring(count1-1, count1).equals("-"))){
                	count1--;
                	}
                	String temp1 = answer.substring(count1,slash);
                	while (temp1.indexOf(".") < temp1.lastIndexOf(".")){
                	temp1 = temp1.substring(0, temp1.indexOf(".")) + temp1.substring(temp1.indexOf(".")+1);
                	}
                	if (temp1.length() == 0){
                	return "ERROR";
                	}
                	double first = Double.parseDouble(temp1);
                	int count2 = slash+1;
                	while(count2 < answer.length() && (answer.substring(count2,count2+1).compareTo("0")>=0 && answer.substring(count2,count2+1).compareTo("9")<=0 || answer.substring(count2,count2 + 1).equals("."))){
                	count2++;
                	}
                	String temp2 = answer.substring(slash+1, count2);
                	while (temp2.indexOf(".") < temp2.lastIndexOf(".")){
                	temp2 = temp2.substring(0, temp2.indexOf(".")) + temp2.substring(temp2.indexOf(".")+1);
                	}
                	if (temp2.length() == 0){
                	return "ERROR";
                	}
                	double second = Double.parseDouble(temp2);
                	double quotient = first/second;
                	answer = answer.substring(0,count1) + quotient + answer.substring(count2);
                	return answer;
            	}
            	public String add(String answer){
                	int plus = answer.indexOf("+");
                	int count1 = plus;
                	while(count1 >=1 && (answer.substring(count1-1,count1).compareTo("0")>=0 && answer.substring(count1-1,count1).compareTo("9")<=0 || answer.substring(count1-1,count1).equals(".") || answer.substring(count1-1, count1).equals("-"))){
                	count1--;
                	}
                	String temp1 = answer.substring(count1,plus);
                	while (temp1.indexOf(".") < temp1.lastIndexOf(".")){
                	temp1 = temp1.substring(0, temp1.indexOf(".")) + temp1.substring(temp1.indexOf(".")+1);
                	}
                	if (temp1.length() == 0){
                	return "ERROR";
                	}
                	double first = Double.parseDouble(temp1);
                	int count2 = plus+1;
                	while(count2 < answer.length() && (answer.substring(count2,count2+1).compareTo("0")>=0 && answer.substring(count2,count2+1).compareTo("9")<=0 || answer.substring(count2,count2 + 1).equals("."))){
                	count2++;
                	}
                	String temp2 = answer.substring(plus+1, count2);
                	while (temp2.indexOf(".") < temp2.lastIndexOf(".")){
                	temp2 = temp2.substring(0, temp2.indexOf(".")) + temp2.substring(temp2.indexOf(".")+1);
                	}
                	if (temp2.length() == 0){
                	return "ERROR";
                	}
                	double second = Double.parseDouble(temp2);
                	double sum = first+second;
                	answer = answer.substring(0,count1) + sum + answer.substring(count2);
                	return answer;
            	}
            	public String subtract(String answer){
                 	int minus = answer.lastIndexOf("-");
                 	int count1 = minus;
                 	while(count1 >=1 && (answer.substring(count1-1,count1).compareTo("0")>=0 && answer.substring(count1-1,count1).compareTo("9")<=0 || answer.substring(count1-1,count1).equals(".") || answer.substring(count1-1,count1).equals("-"))){
                 	count1--;
                 	}
                 	String temp1 = answer.substring(count1,minus);
                 	while (temp1.indexOf(".") < temp1.lastIndexOf(".")){
                 	temp1 = temp1.substring(0, temp1.indexOf(".")) + temp1.substring(temp1.indexOf(".")+1);
                 	}
                 	if (temp1.length() == 0){
                 	return "ERROR";
                 	}
                 	double first = Double.parseDouble(temp1);
                 	int count2 = minus+1;
                 	while(count2 < answer.length() && (answer.substring(count2,count2+1).compareTo("0")>=0 && answer.substring(count2,count2+1).compareTo("9")<=0 || answer.substring(count2,count2 + 1).equals("."))){
                 	count2++;
                 	}
                 	String temp2 = answer.substring(minus+1, count2);
                 	while (temp2.indexOf(".") < temp2.lastIndexOf(".")){
                 	temp2 = temp2.substring(0, temp2.indexOf(".")) + temp2.substring(temp2.indexOf(".")+1);
                 	}
                 	if (temp2.length() == 0){
                 	return "ERROR";
                 	}
                 	double second = Double.parseDouble(temp2);
                 	double difference = first-second;
                 	answer = answer.substring(0,count1) + difference + answer.substring(count2);
                 	return answer;
            	}
    	}
    	bEnter.addActionListener(new bEnterListener());
    	frame.getRootPane().setDefaultButton(bEnter);
	JButton bAdd = new JButton("+");
    	class bAddListener implements ActionListener{
        	public void actionPerformed(ActionEvent arg0){
    	String temp = input.getText();
       	int first = temp.length()-1;
       	while(first > 0 && !temp.substring(first-1, first).equals(" ")){
           	first--;
       	}
       	temp = temp.substring(first);
       	if (temp.indexOf("*") != -1 || temp.indexOf("x") != -1 || temp.indexOf("/") != -1 || temp.indexOf("+") != -1 || temp.indexOf("-") != -1 && !temp.substring(0,1).equals("-") || temp.indexOf("-") < temp.lastIndexOf("-")){
           	new bEnterListener().actionPerformed(null);
           	if (!new bEnterListener().solve(temp).equals("ERROR"))
               	input.append(new bEnterListener().solve(temp));
       	}
            	input.append("+");
        	}
    	}
    	bAdd.addActionListener(new bAddListener());
    	JButton bSubtract = new JButton("-");
    	class bSubtractListener implements ActionListener{
        	public void actionPerformed(ActionEvent arg0){
    	String temp = input.getText();
       	int first = temp.length()-1;
       	while(first > 0 && !temp.substring(first-1, first).equals(" ")){
           	first--;
       	}
       	temp = temp.substring(first);
       	if (temp.indexOf("*") != -1 || temp.indexOf("x") != -1 || temp.indexOf("/") != -1 || temp.indexOf("+") != -1 || temp.indexOf("-") != -1 && !temp.substring(0,1).equals("-") || temp.indexOf("-") < temp.lastIndexOf("-")){
           	new bEnterListener().actionPerformed(null);
           	if (!new bEnterListener().solve(temp).equals("ERROR"))
               	input.append(new bEnterListener().solve(temp));
       	}
            	input.append("-");
        	}
    	}
    	bSubtract.addActionListener(new bSubtractListener());
    	JButton bMultiply = new JButton("x");
    	class bMultiplyListener implements ActionListener{
        	public void actionPerformed(ActionEvent e){
String temp = input.getText();
       	int first = temp.length()-1;
       	while(first > 0 && !temp.substring(first-1, first).equals(" ")){
           	first--;
       	}
       	temp = temp.substring(first);
       	if (temp.indexOf("*") != -1 || temp.indexOf("x") != -1 || temp.indexOf("/") != -1 || temp.indexOf("+") != -1 || temp.indexOf("-") != -1 && !temp.substring(0,1).equals("-") || temp.indexOf("-") < temp.lastIndexOf("-")){
           	new bEnterListener().actionPerformed(null);
           	if (!new bEnterListener().solve(temp).equals("ERROR"))
               	input.append(new bEnterListener().solve(temp));
       	}
            	input.append("x");
        	}
    	}
    	bMultiply.addActionListener(new bMultiplyListener());
    	JButton bDivide = new JButton("/");
    	class bDivideListener implements ActionListener{
        	public void actionPerformed(ActionEvent e){
String temp = input.getText();
       	int first = temp.length()-1;
       	while(first > 0 && !temp.substring(first-1, first).equals(" ")){
           	first--;
       	}
       	temp = temp.substring(first);
       	if (temp.indexOf("*") != -1 || temp.indexOf("x") != -1 || temp.indexOf("/") != -1 || temp.indexOf("+") != -1 || temp.indexOf("-") != -1 && !temp.substring(0,1).equals("-") || temp.indexOf("-") < temp.lastIndexOf("-")){
           	new bEnterListener().actionPerformed(null);
           	if (!new bEnterListener().solve(temp).equals("ERROR"))
               	input.append(new bEnterListener().solve(temp));
       	}
            	input.append("/");
        	}
    	}
    	bDivide.addActionListener(new bDivideListener());
    	class calcKeyListener implements KeyListener{
        	public void keyPressed(KeyEvent e){
       		 if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
       			 if (!input.getText().substring(input.getText().length()-1, input.getText().length()).equals(" "))
                    	input.setText(input.getText().substring(0, input.getText().length()-1));
       		 }
        	}
        	public void keyReleased(KeyEvent e){
        	}
        	public void keyTyped(KeyEvent e){
       		 
            	char character = e.getKeyChar();
            	if (character == '0'){
                	input.append("0");
            	}
            	if (character == '1'){
                	input.append("1");
            	}
            	if (character == '2'){
                	input.append("2");
            	}
            	if (character == '3'){
                	input.append("3");
            	}
            	if (character == '4'){
                	input.append("4");
            	}
            	if (character == '5'){
                	input.append("5");
            	}
            	if (character == '6'){
                	input.append("6");
            	}
            	if (character == '7'){
                	input.append("7");
            	}
            	if (character == '8'){
                	input.append("8");
            	}
            	if (character == '9'){
                	input.append("9");
            	}
            	if (character == '.'){
                	input.append(".");
            	}
            	if (character == '*'){
                	String temp = input.getText();
                	int first = temp.length()-1;
                	while(first > 0 && !temp.substring(first-1, first).equals(" ")){
                    	first--;
                	}
                	temp = temp.substring(first);
                	if (temp.indexOf("*") != -1 || temp.indexOf("x") != -1 || temp.indexOf("/") != -1 || temp.indexOf("+") != -1 || temp.indexOf("-") != -1 && !temp.substring(0,1).equals("-") || temp.indexOf("-") < temp.lastIndexOf("-")){
                    	new bEnterListener().actionPerformed(null);
                    	if (!new bEnterListener().solve(temp).equals("ERROR"))
                   		 input.append(new bEnterListener().solve(temp));
                	}
                	input.append("*");
            	}
            	if (character == 'x'){
                	String temp = input.getText();
                	int first = temp.length()-1;
                	while(first > 0 && !temp.substring(first-1, first).equals(" ")){
                    	first--;
                	}
                	temp = temp.substring(first);
                	if (temp.indexOf("*") != -1 || temp.indexOf("x") != -1 || temp.indexOf("/") != -1 || temp.indexOf("+") != -1 || temp.indexOf("-") != -1 && !temp.substring(0,1).equals("-") || temp.indexOf("-") < temp.lastIndexOf("-")){
                    	new bEnterListener().actionPerformed(null);
                    	if (!new bEnterListener().solve(temp).equals("ERROR"))
                   		 input.append(new bEnterListener().solve(temp));
                	}
                	input.append("x");
            	}
            	if (character == '/'){
                	String temp = input.getText();
                	int first = temp.length()-1;
                	while(first > 0 && !temp.substring(first-1, first).equals(" ")){
                    	first--;
                	}
                	temp = temp.substring(first);
                	if (temp.indexOf("*") != -1 || temp.indexOf("x") != -1 || temp.indexOf("/") != -1 || temp.indexOf("+") != -1 || temp.indexOf("-") != -1 && !temp.substring(0,1).equals("-") || temp.indexOf("-") < temp.lastIndexOf("-")){
                    	new bEnterListener().actionPerformed(null);
                    	if (!new bEnterListener().solve(temp).equals("ERROR"))
                   		 input.append(new bEnterListener().solve(temp));
                	}
                	input.append("/");
            	}
            	if (character == '+'){
                	String temp = input.getText();
                	int first = temp.length()-1;
                	while(first > 0 && !temp.substring(first-1, first).equals(" ")){
                    	first--;
                	}
                	temp = temp.substring(first);
                	if (temp.indexOf("*") != -1 || temp.indexOf("x") != -1 || temp.indexOf("/") != -1 || temp.indexOf("+") != -1 || temp.indexOf("-") != -1 && !temp.substring(0,1).equals("-") || temp.indexOf("-") < temp.lastIndexOf("-")){
                    	new bEnterListener().actionPerformed(null);
                    	if (!new bEnterListener().solve(temp).equals("ERROR"))
                   		 input.append(new bEnterListener().solve(temp));
                	}
                	input.append("+");
            	}
            	if (character == '-'){
                	String temp = input.getText();
                	int first = temp.length()-1;
                	while(first > 0 && !temp.substring(first-1, first).equals(" ")){
                    	first--;
                	}
                	temp = temp.substring(first);
                	if (temp.indexOf("*") != -1 || temp.indexOf("x") != -1 || temp.indexOf("/") != -1 || temp.indexOf("+") != -1 || temp.indexOf("-") != -1 && !temp.substring(0,1).equals("-") || temp.indexOf("-") < temp.lastIndexOf("-")){
                    	new bEnterListener().actionPerformed(null);
                    	if (!new bEnterListener().solve(temp).equals("ERROR"))
                   		 input.append(new bEnterListener().solve(temp));
                	}
                	input.append("-");
            	}
            	if (character == '='){
                	new bEnterListener().actionPerformed(null);
            	}
        	}
    	}
    	frame.addKeyListener(new calcKeyListener());
    	bDelete.addKeyListener(new calcKeyListener());
    	bClearEntry.addKeyListener(new calcKeyListener());
    	bReset.addKeyListener(new calcKeyListener());
    	bAdd.addKeyListener(new calcKeyListener());
    	bSubtract.addKeyListener(new calcKeyListener());
    	bMultiply.addKeyListener(new calcKeyListener());
    	bDivide.addKeyListener(new calcKeyListener());
    	b6.addKeyListener(new calcKeyListener());
    	b7.addKeyListener(new calcKeyListener());
    	b8.addKeyListener(new calcKeyListener());
    	b9.addKeyListener(new calcKeyListener());
    	b2.addKeyListener(new calcKeyListener());
    	b3.addKeyListener(new calcKeyListener());
    	b4.addKeyListener(new calcKeyListener());
    	b5.addKeyListener(new calcKeyListener());
    	b1.addKeyListener(new calcKeyListener());
    	b0.addKeyListener(new calcKeyListener());
    	bDecimal.addKeyListener(new calcKeyListener());
    	bEnter.addKeyListener(new calcKeyListener());
    	buttons.setLayout(new GridLayout(5,4));
    	buttons.add(bDelete);
    	buttons.add(bClearEntry);
    	buttons.add(bReset);
    	buttons.add(bOff);
    	buttons.add(bAdd);
    	buttons.add(bSubtract);
    	buttons.add(bMultiply);
    	buttons.add(bDivide);
    	buttons.add(b6);
    	buttons.add(b7);
    	buttons.add(b8);
    	buttons.add(b9);
    	buttons.add(b2);
    	buttons.add(b3);
    	buttons.add(b4);
    	buttons.add(b5);
    	buttons.add(b1);
    	buttons.add(b0);
    	buttons.add(bDecimal);
    	buttons.add(bEnter);
    	buttons.setBackground(new Color(6,17,87));
    	frame.add(buttons, BorderLayout.CENTER);
    	frame.setBackground(new Color(6,17,87));
    	frame.setVisible(true);
	}
}