import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class CITPanel extends JPanel{
    private JLabel label;
    private ImageIcon logo;

    public CITPanel(){
	logo=new ImageIcon("index.jpg");
	label=new JLabel(logo);
        this.add(label);
    }
}

   
