                              /*             MAKERERE UNIVERSITY
                               SCHOOL OF COMPUTING AND INFORMATICS TECHNOLOGY
                                       DEPARTMENT OF COMPUTER SCIENCE
                                              CSC1208 ASSIGNMENT 5     
                                          LECTURER:DR. JOHN NGUBIRI      */

//NAME:NINSIIMA FLAVIA DELMIRA
//REGISTRATION NUMBER:10/U/1382
//STUDENT NUMBER:210000613

                            //      A PROGRAM THAT IMPLEMENTS THE INTERFACE OF A CALCULATOR           //
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class CITCalc extends JFrame{
    private static final Font BIGGER_FONT = new Font("monspaced", Font.PLAIN, 20);
    private JTextField _display;      // display result / input.
        
    //... Variables representing state of the calculator
    private boolean   _startNumber = true;      // true: num key next
    private String    _previousOp  = "=";      // previous operation
    private CalcLogic _logic = new CalcLogic(); // The internal calculator.              
    


    public static void main(String[] args){
       
    CITCalc frame = new CITCalc();
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    }

    public CITCalc(){
	_display = new JTextField("0", 12);
        _display.setHorizontalAlignment(JTextField.RIGHT);
        _display.setFont(BIGGER_FONT);

        //... Create and set attributes of clear button
        JButton clearButton = new JButton("Clear");
        clearButton.setFont(BIGGER_FONT);
	clearButton.addActionListener(new ClearListener());
        
	ActionListener numListener = new NumListener();
	String buttonOrder = "CDEF89AB45670123";
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 2, 2));
        for (int i = 0; i < buttonOrder.length(); i++) {
            String keyTop = buttonOrder.substring(i, i+1);
            JButton b = new JButton(keyTop);
           
                //... Put a digit button in the interface.
	    b.addActionListener(numListener);
	    b.setFont(BIGGER_FONT);
	    b.setBackground(Color.blue);
            
            buttonPanel.add(b);
        }

	ActionListener opListener = new OpListener();
	JPanel opPanel = new JPanel();
        opPanel.setLayout(new GridLayout(4, 3, 2, 2));
        String[] opOrder = {"AND","OR","XOR","NOR","NAND","+", "-", "*", "/", "="};
        for (int i = 0; i < opOrder.length; i++){
            JButton b = new JButton(opOrder[i]);
	    b.addActionListener(opListener);
            b.setFont(BIGGER_FONT);
	    b.setBackground(Color.green);
            opPanel.add(b);
        }

	CITPanel panel=new CITPanel();
	panel.setBackground(Color.gray);
        JPanel myPanel=new JPanel();
	myPanel.setLayout(new BorderLayout());
	myPanel.add(_display, BorderLayout.NORTH);
	myPanel.add(panel, BorderLayout.SOUTH);
	myPanel.setBackground(Color.gray);
	opPanel.setBackground(Color.gray);
	buttonPanel.setBackground(Color.gray);

	JPanel clearPanel = new JPanel();
        clearPanel.setLayout(new FlowLayout());
        clearPanel.add(clearButton);
	clearPanel.setBackground(Color.gray);
                
	JPanel content = new JPanel();
        content.setLayout(new BorderLayout(5, 5));
        content.add(myPanel, BorderLayout.NORTH );
        content.add(buttonPanel   , BorderLayout.CENTER);
        content.add(opPanel       , BorderLayout.EAST  );
	content.add(clearPanel         , BorderLayout.SOUTH );
	content.setBackground(Color.gray);

	content.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        //... Finish building the frame (JFrame)
        this.setContentPane(content);
        this.pack();
        this.setTitle("CIT Calculator");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    } //end constructor

    private void actionClear() {
	_startNumber = true;        // Expecting number, not op.
	_display.setText("0");
	_previousOp  = "=";
	_logic.setTotal("0");               
    }
                      
       
    /** Listener for all op buttons. */
    class OpListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
            // The calculator is always in one of two states.
            // 1. A number must be entered -- an operator is wrong.
            // 2. An operator must be entered.
            if (_startNumber) { // Error: needed number, not operator
                //... In this state we're expecting a number, but got an operator.
                actionClear();
                _display.setText("ERROR - No operator");
            } else {
                //... We're expecting an operator.
                _startNumber = true;  // Next thing must be a number
                try {
                    // Get value from display field, convert, do prev op
                    // If this is the first op, _previousOp will be =.
                    String displayText = _display.getText();
                    
                    if (_previousOp.equals("=")) {
                        _logic.setTotal(displayText);
                    } else if (_previousOp.equals("+")) {
                        _logic.add(displayText);
                    } else if (_previousOp.equals("-")) {
                        _logic.subtract(displayText);
                    } else if (_previousOp.equals("*")) {
                        _logic.multiply(displayText);
                    } else if (_previousOp.equals("/")) {
                        _logic.divide(displayText);
                    } else if (_previousOp.equals("AND")) {
                        _logic.and(displayText);
                    } else if (_previousOp.equals("OR")) {
                        _logic.or(displayText);
                    } else if (_previousOp.equals("XOR")) {
                        _logic.xor(displayText);
                    } else if (_previousOp.equals("NOR")) {
                        _logic.nor(displayText);
                    } else if (_previousOp.equals("NAND")) {
                        _logic.nand(displayText);
                    }
                    
                    _display.setText("" + _logic.getTotalString());
                    
                } catch (NumberFormatException ex) {
                    actionClear();
                    _display.setText("Error");
                }
                
                //... set _previousOp for the next operator.
                _previousOp = e.getActionCommand();
            }//endif _startNumber
        }//endmethod
    }//end class
    
    
    /** Action listener for numeric keys */
    class NumListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String digit = e.getActionCommand(); // Get text from button
            if (_startNumber) {
                //... This is the first digit, clear field and set
                _display.setText(digit);
                _startNumber = false;
            } else {
                //... Add this digit to the end of the display field
                _display.setText(_display.getText() + digit);
            }
        }
    }
    
    
    //////////////////////////////////// inner listener class ClearListener
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            actionClear();
	}                
    }                    
}       
    



