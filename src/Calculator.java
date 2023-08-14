import javax.swing.*; //importing java swing library for GUI
import java.awt.*; //importing java Abstract Window Toolkit library for API
import java.awt.event.*;
public class Calculator implements ActionListener{ //Calculator class takes ActionListener class
    JFrame frame; //for our main application frame
    JTextField textField; //for text area of calculator
    JButton[] numberButtons = new JButton[10]; //a buttons array for all numbers
    JButton[] functionButtons = new JButton[9]; //a buttons array for all functions
    //declaring all the buttons
    JButton addButton, subtractButton, multiplicationButton, divisionButton,
    decimalButton, equalButton, deleteButton, clearButton,negativeButton;

    JPanel panel; //panel including all the buttons

    //a font for use in calculator
    Font myFont = new Font("Helvetica", Font.BOLD , 30);

    //numbers to be used for functionalities
    double number1 = 0;
    double number2 =0;
    double result = 0;

    char operator; //operator sign variable

    //Calculator class constructor, we will perform all functions for GUI here
    Calculator(){
        frame = new JFrame("Calculator"); //assigning title for application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //for application closure on cross button
        frame.setSize(420,550); //size of window
        frame.setLayout(null);

        //textfield
        textField = new JTextField();
        textField.setBounds(50,25,300,50); //size of text field
        textField.setFont(myFont);//setting font of text field
        textField.setEditable(false); //can not be edited

        //addbutton
        //Setting all buttons and their text
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplicationButton = new JButton("*");
        divisionButton = new JButton("/");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("del");
        clearButton = new JButton("clr");
        negativeButton = new JButton("(-)");


        //adding function buttons to functionButtons array
        functionButtons[0] = addButton;
        functionButtons[1] = subtractButton;
        functionButtons[2] = multiplicationButton;
        functionButtons[3] = divisionButton;
        functionButtons[4] = decimalButton;
        functionButtons[6] = equalButton;
        functionButtons[7] =deleteButton;
        functionButtons[5] = clearButton;
        functionButtons[8] = negativeButton;

        //a fot loop that sets all buttons as ActionListeners
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this); //"this" will be set later for actions
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        //a for loop for declaring all number buttons and their texts also their attributes as
        //ActionListener
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);

        }

        //setting positions for negative, delete and clear buttons
        negativeButton.setBounds(50,430,100,50);
        deleteButton.setBounds(150,430,100,50);
        clearButton.setBounds(250,430,100,50);

        //creating panel and it's layout
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10)); //columns, rows, and gap between

        //adding buttons inside the panel using numberButtons array
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        //adding addButton to panel
        panel.add(addButton);

        //adding buttons inside the panel using numberButtons array
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        //adding subtractButton to panel
        panel.add(subtractButton);

        //adding buttons inside the panel using numberButtons array
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        //adding multiplicationButton to panel
        panel.add(multiplicationButton);
        //adding decimalButton to panel
        panel.add(decimalButton);
        //adding zero button to panel
        panel.add(numberButtons[0]);
        //adding equalButton to panel
        panel.add(equalButton);
        //adding divisionButton to panel
        panel.add(divisionButton);

        //adding panel to frame
        frame.add(panel);
        //adding negativeButton to frame
        frame.add(negativeButton);
        //adding deleteButton to frame
        frame.add(deleteButton);
        //adding clearButton to frame
        frame.add(clearButton);
        //adding textField to frame
        frame.add(textField);
        //setting frame visibility as true
        frame.setVisible(true);
    }

    //main function
    public static void main(String[] args) {
        //making Calculator class' object so it calls the constructor
        Calculator c1 = new Calculator();
    }

    //for Actions
    @Override
    public void actionPerformed(ActionEvent e) {
        //when a number button is clicked, the textField stores the value from that button
        for (int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        //on decimal button add a dot
        if(e.getSource() == decimalButton){
            textField.setText(textField.getText().concat("."));
        }
        //on addButton, set operator to '+' and keep textField empty
        if (e.getSource()==addButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");

        }
        //on subtractButton, set operator to '-' and keep textField empty
        if (e.getSource()== subtractButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        //on multiplicationButton, set operator to '*' and keep textField empty
        if (e.getSource()== multiplicationButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");

        }
        //on divisionButton, set operator to '/' and keep textField empty
        if (e.getSource()== divisionButton){
            number1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");

        }
        //on equal button perform different functionalities based on operator
        if(e.getSource()==equalButton){
            number2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+':
                    result = number1+number2;
                    break;
                case '-':
                    result = number1-number2;
                    break;
                case '*':
                    result = number1*number2;
                    break;
                case '/':
                    result = number1/number2;
                    break;
            }
            textField.setText(String.valueOf(result));
            number1 = result;
        }

        //on clearButton set textField to empty
        if (e.getSource()==clearButton){
            textField.setText("");

        }
        //on deleteButton just clear the last character
        if (e.getSource()==deleteButton){
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                textField.setText(textField.getText()+ string.charAt(i));
            }
        }
        //on negativeButton multiply added number by -1 and set it in textField
        if (e.getSource()==negativeButton){
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }

    }
}
