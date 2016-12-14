package ld5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class fontnames extends JApplet implements ItemListener{

    private JButton btn1 = new JButton("Draw picture");
    private Canvas canvas = new Canvas();                    // Drawing panel
    private JPanel controls = new JPanel();
    private JTextField textfield = new JTextField(7);
    private JFormattedTextField valueK = new JFormattedTextField();
    private JLabel labelK = new JLabel("K value");
    private JLabel labelSymb = new JLabel("10 symbols");
    	   
    public void init() {
    	valueK.setColumns(5);
        canvas.setBorder(BorderFactory.createTitledBorder("Drawing Canvas"));
        controls.add(labelK);
        controls.add(valueK);
        controls.add(labelSymb);
        controls.add(textfield);
        btn1.addActionListener(new ButtonListener());
        controls.add(btn1);	   
        getContentPane().add(controls,"North");   // Add the controls
        getContentPane().add(canvas,"Center");    // And the drawing panel
        setSize(canvas.WIDTH,canvas.HEIGHT+controls.getSize().width); 
        
    } 
    
    public static boolean isInteger(String s) {
        boolean isValidInteger = false;
        try
        {
           Integer.parseInt(s);   
           isValidInteger = true;
        }
        catch (NumberFormatException ex)
        {}
        return isValidInteger;
     }
    
    class ButtonListener implements ActionListener {
  	  ButtonListener() {}

  	  public void actionPerformed(ActionEvent e) {
  	    if (e.getActionCommand().equals("Draw picture")) {
  	      System.out.println("Button1 has been clicked");
  	      String textValue = textfield.getText();
  	      System.out.println("textValue = " + textValue);
  	      String kValue = "";
  	      if (valueK.getText().equals("")){
  	    	  JOptionPane.showMessageDialog(null, "Please enter K", "InfoBox: " + "title", JOptionPane.INFORMATION_MESSAGE);
  	    	  System.out.println("is empty");
  	      } else {
  	        	kValue = valueK.getText();
  	        	if (textValue.length() != 10){
  	        		 JOptionPane.showMessageDialog(null, "Please enter 10 symbols", "InfoBox: " + "title", JOptionPane.INFORMATION_MESSAGE);
  	    	    	  System.out.println("not 10 symb");
  	    	      } else if (!isInteger(kValue)) {
  	    	    	  JOptionPane.showMessageDialog(null, "Please enter k as an integer", "InfoBox: " + "title", JOptionPane.INFORMATION_MESSAGE);
  	    	    	  System.out.println("not an integer");
  	    	      } else {
	  	    	      int k = Integer.parseInt((String)kValue);
	  	    	      if (k > 0) {
		  	    	      System.out.println("valueK = " + k);
		  	    	      canvas.setPattern(k, textValue);
		  	    	        repaint();
	  	    	      } else {
	  	    	    	JOptionPane.showMessageDialog(null, "Please enter k, that k>0 ", "InfoBox: " + "title", JOptionPane.INFORMATION_MESSAGE);
	  	    	    	  System.out.println("not an integer");
	  	    	      }
  	    	      }
  	        }
  	    }
  	  }
  }

    
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
} // FontNames