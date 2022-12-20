import javax.swing.*;
import javax.swing.ImageIcon.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;

  /*Saad Shafiq
    June 17, 2021
    Receipt
  */

class Receipt implements ActionListener
{
  static JPanel contentPane;
	static JLabel prompt1, prompt2, output1, output2, output3;
	static JTextField price, quantity;
	static JButton calculate;
  static JFrame frame=new JFrame("Receipt");


	public static void main(String args[])
	{
    frame();
  }

    public static void frame(){

    //Frame created
		frame.setSize(1000,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(new FlowLayout());

    //Text space created
    prompt1 = new JLabel("Enter price of item");
	  frame.add(prompt1);
	    
	  price = new JTextField(10);
	  frame.add(price);

    prompt2 = new JLabel("Enter quantity of item");
	  frame.add(prompt2);
	    
	  quantity = new JTextField(10);
	  frame.add(quantity);

		//Button created
		calculate =new JButton("Calculate");
		frame.add(calculate);

		Receipt obj=new Receipt();
		calculate.addActionListener(obj);
		frame.setVisible(true);

    
	}


  //Method to display totals
	public void actionPerformed(ActionEvent e){
    NumberFormat formatter = new DecimalFormat("#0.00");
		double taxTotal;
    double subTotal;
    double total;
    String quantity1 = quantity.getText();
    String price1 = price.getText();
        	
    subTotal = ((Double.parseDouble(quantity1)*Double.parseDouble(price1)));
    String subTotalRounded = formatter.format(subTotal);
    output1 = new JLabel("\nSubtotal: $" + subTotalRounded);
	  frame.add(output1);


    taxTotal = ((Double.parseDouble(quantity1)*Double.parseDouble(price1))*0.13);
    String taxTotalRounded = formatter.format(taxTotal);
    output2 = new JLabel("\nTax: $" + taxTotalRounded);
	  frame.add(output2);

    total = ((Double.parseDouble(quantity1)*Double.parseDouble(price1))*1.13);
    String totalRounded = formatter.format(total);
    output3 = new JLabel("\nTotal: $" + totalRounded);
	  frame.add(output3);
	}
}

