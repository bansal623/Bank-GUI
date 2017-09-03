import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class FinalBank extends JMenuBar implements ActionListener {

	// Declaring components
	JFrame f;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
	JDesktopPane jdp;
	JInternalFrame jif1,jif2,jif3,jif4;

	String accountItems[] = {"New Account","Close Account","Exit"};
	String transactionItems[] = {"Deposit","Withdraw"};
  int count = 0,OpenClicked = 0;
  String name, marks, account;
  int accountno, no1, no, mark, total, flag = 0,n1;
  int fl1 = 0; int c2 = 0; String r, t;

  // Default constructor
	public FinalBank() {
		f = new JFrame();
		f.setSize(400,400);

		jdp = new JDesktopPane();
		f.add(jdp);

		JMenu accountMenu = new JMenu("Account");
		JMenu transactionMenu = new JMenu("Transaction");

		for(int i = 0;i <  accountItems.length;i++) {


				JMenuItem item = new JMenuItem(accountItems[i]);
				item.addActionListener(this);
				accountMenu.add(item);

		}
		accountMenu.insertSeparator(2);

		for(int i = 0;i < transactionItems.length;i++)
		{

				JMenuItem item = new JMenuItem(transactionItems[i]);
				item.addActionListener(this);
				transactionMenu.add(item);
		}
			transactionMenu.insertSeparator(1);

		add(accountMenu);
		add(transactionMenu);
		f.setJMenuBar(this);

		jif1 = new JInternalFrame("New Account",true,true,true,true);
		jdp.add(jif1);
		jif2 = new JInternalFrame("Delete Account",true,true,true,true);
		jdp.add(jif2);

		jif3 = new JInternalFrame("Deposit Window",true,true,true,true);
		jdp.add(jif3);
		jif4 = new JInternalFrame("WithDraw Window",true,true,true,true);
		jdp.add(jif4);
		f.setVisible(true);


	}



	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if(str.equals("New Account")) {
	   p1 = new JPanel();
	   p2 = new JPanel(new GridLayout(4,2));
	   p3 = new JPanel(new GridLayout(1,3));
	   l1 = new JLabel("Account_No");    l2 = new JLabel("Name");     l3 = new JLabel("Amount");
	   t1 = new JTextField(20);          t2 = new JTextField(20);     t3 = new JTextField(20);
	   p2.add(l1); p2.add(t1);         p2.add(l2); p2.add(t2);    p2.add(l3); p2.add(t3);
	   b1 = new JButton("Save");         b2 = new JButton("Reset");   b3 = new JButton("Close");
	   p3.add(b1); p3.add(b2);   p3.add(b3);
	   p1.add(p2);  p1.add(p3);
	   jif1.add(p1);

  	 b1.addActionListener(this);
     b2.addActionListener(this);
     b3.addActionListener(this);

	   jif1.setVisible(true);
	   jif1.setSize(500,300);

			try {
  		 	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("Jdbc:Odbc:Bank");
  	     Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery("SELECT * FROM bank1");
           if(rs.last())
             {
	            accountno = rs.getInt("Account_No");
	            accountno = accountno+1;
                System.out.println(accountno+"");
                t1.setText(accountno+"");

             }

             t1.setEditable(false);
            // t2.setText("Mohit");


		    }
		    catch (Exception e1)
		    {
		    	System.out.println(e1.getMessage());
		    }

		}

	  if(str.equals("Close Account"))
		{
			 OpenClicked = 1;
	     p4 = new JPanel();
	     p5 = new JPanel(new GridLayout(4,2));
	     p6 = new JPanel(new GridLayout(1,3));
	     l4 = new JLabel("Account_No");    l5 = new JLabel("Name");     l6 = new JLabel("Amount");
	     t4 = new JTextField(20);    t5 = new JTextField(20);   t6 = new JTextField(20);


	    p5.add(l4); p5.add(t4);   p5.add(l5); p5.add(t5); p5.add(l6); p5.add(t6);

	    b4 = new JButton("Next"); b5 = new JButton("Delete");      b6 = new JButton("Reset");  b7 = new JButton("Close");
	    p6.add(b4); p6.add(b5);   p6.add(b6); p6.add(b7);

	    p4.add(p5);  p4.add(p6);
	    jif2.add(p4);

	    	b4.addActionListener(this);
		    b5.addActionListener(this);
		    b6.addActionListener(this);
		    b7.addActionListener(this);

			  jif2.setVisible(true);
	          jif2.setSize(500,300);

	       //   t5.setEditable(false);
	       //    t6.setEditable(false);

		}




		if(str.equals("Next"))
	{
		try
		{
			System.out.println("hii");
		    name = t4.getText();
		    System.out.println(name);
		    no = Integer.parseInt(name);

		}
		catch(NumberFormatException e2)
		{
				c2 = 1;
		       JOptionPane.showMessageDialog(jif2,"Please Enter Integer Value","Alert",JOptionPane.PLAIN_MESSAGE);
		       t4.setText(""); t4.setText("");t6.setText("");

		}

		System.out.println(no+"");
		 try
		    {


		    		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	                 Connection con = DriverManager.getConnection("Jdbc:Odbc:Bank");
		    	     Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	                 ResultSet rs = stmt.executeQuery("SELECT * from bank1");


		             while(rs.next())
		              {
		              	no1 = rs.getInt("Account_No");



		            if(no== no1)
		             	{
		             		flag = 0;
		             		System.out.println(no+"");
		             		t5.setText(rs.getString("name"));
	              	        t6.setText(rs.getString("balance"));
	              	        t5.setEditable(false);
	              	        t6.setEditable(false);
	              	        String m = rs.getString("balance");
	              	        mark = Integer.parseInt(m);
	              	        System.out.println(mark+"");
	              	        break;

 	             	    }
 	             	    else
 	             	    {
 	             	    	flag++;

 	             	    }

		   	          }


		   	         if(flag! = 0)
		   	         {
		   	         	if(no <  0|| flag! = 0 && c2== 0)
		   	         	{
		   	         		JOptionPane.showMessageDialog(jif2,"Invalid Account No. Please Enter again","Alert",JOptionPane.PLAIN_MESSAGE);
		   	          	t4.setText("");


		   	         	}

		   	         }
		   	         else
		   	         {
		   	         	System.out.println("MOhit Bansal");
		   	         }




		    }
		    catch (Exception e1)
		    {
		    	System.out.println(e1.getMessage());
		    }

	}

		if(str.equals("Next1"))
	{
		try
		{
			System.out.println("hii");
		 name = t7.getText();
		System.out.println(name);
		no = Integer.parseInt(name);

		}
		catch(NumberFormatException e2)
		{
			c2 = 1;
			JOptionPane.showMessageDialog(jif3,"Please Enter Integer Value","Alert",JOptionPane.PLAIN_MESSAGE);
		       t7.setText("");  t8.setText("");t9.setText("");t10.setText("");

		}


		 try
		    {


		    		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	                 Connection con = DriverManager.getConnection("Jdbc:Odbc:Bank");
		    	     Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	                 ResultSet rs = stmt.executeQuery("SELECT * from bank1");


		             while(rs.next())
		              {
		              	no1 = rs.getInt("Account_No");



		            if(no== no1)
		             	{
		             		flag = 0;
		             		System.out.println(no+"");
		             		t8.setText(rs.getString("name"));
	              	        t9.setText(rs.getString("balance"));
	              	        String m = rs.getString("balance");
	              	        t8.setEditable(false);
	              	        t9.setEditable(false);
	              	        mark = Integer.parseInt(m);
	              	        System.out.println(mark+"");
	              	        break;

 	             	    }
 	             	    else
 	             	    {
 	             	    	flag++;

 	             	    }

		   	          }


		   	         if(flag! = 0)
		   	         {
		   	         	if(no <  0|| flag != 0 && c2 == 0)
		   	         	{
		   	         		JOptionPane.showMessageDialog(jif3,"Invalid Account No. Please Enter again","Alert",JOptionPane.PLAIN_MESSAGE);
		   	          	t7.setText("");

		   	         	}
		   	          	//	t11.setText("");
		   	         }
		   	         else
		   	         {
		   	         	System.out.println("MOhit Bansal");
		   	         }




		    }
		    catch (Exception e1)
		    {
		    	System.out.println(e1.getMessage());
		    }

	}



		if(str.equals("Next2"))
	{
		try
		{
			name = t11.getText();
		System.out.println(name);
		no = Integer.parseInt(name);
		System.out.println(no+"");

		}
		 catch(NumberFormatException e2)
		 {
		 	c2 = 1;
		 	JOptionPane.showMessageDialog(jif4,"Please Enter Integer Value","Alert",JOptionPane.PLAIN_MESSAGE);
		       t11.setText("");  t12.setText("");t13.setText("");t14.setText("");
		 }
		 try
		    {


    		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               Connection con = DriverManager.getConnection("Jdbc:Odbc:Bank");
    	     Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
               ResultSet rs = stmt.executeQuery("SELECT * from bank1");


             while(rs.next())
              {
              	no1 = rs.getInt("Account_No");



            if(no== no1)
             	{
             		flag = 0;
             		System.out.println(no+"");
             		t12.setText(rs.getString("name"));
            	        t13.setText(rs.getString("balance"));
            	        String m = rs.getString("balance");
            	        t12.setEditable(false);
            	        t13.setEditable(false);
            	        mark = Integer.parseInt(m);
            	        System.out.println(mark+"");

            	        System.out.println(mark+"");
            	        break;

             	    }
             	    else
             	    {
             	    	flag++;

             	    }

   	          }


   	         if(flag! = 0)
   	         {
   	         	if(no <  0|| flag! = 0 && c2== 0)
   	         	{
   	         		JOptionPane.showMessageDialog(jif4,"Invalid Account No. Please Enter again","Alert",JOptionPane.PLAIN_MESSAGE);
   	         // 	t7.setText("");
   	          	t11.setText("");

   	         	}
   	        }
   	         else
   	         {
   	         	System.out.println("MOhit Bansal");
   	         }

    }
    catch (Exception e1)
    {
    	System.out.println(e1.getMessage());
    }

	}

	if(str.equals("Deposit"))
		{
				count++;

	     p7 = new JPanel();
	     p8 = new JPanel(new GridLayout(4,2));
	     p9 = new JPanel(new GridLayout(1,3));
	     l7 = new JLabel("Account_No");         l8 = new JLabel("Name");  l9 = new JLabel("Balance");   l10 = new JLabel("Amount");
	     t7 = new JTextField(20);               t8 = new JTextField(20);  t9 = new JTextField(20);      t10 = new JTextField(20);
	     p8.add(l7); p8.add(t7);              p8.add(l8); p8.add(t8); p8.add(l9); p8.add(t9);     p8.add(l10); p8.add(t10);
	     b8 = new JButton("Next1");    b9 = new JButton("Update");  b10 = new JButton("Reset");  b11 = new JButton("Close");
	     p9.add(b8); p9.add(b9);   p9.add(b10); p9.add(b11);
	     p7.add(p8);  p7.add(p9);
	     jif3.add(p7);


			 jif3.setVisible(true);
	         jif3.setSize(500,300);



	    	b8.addActionListener(this);
		    b9.addActionListener(this);
		    b10.addActionListener(this);
		    b11.addActionListener(this);

		   // t8.setEditable(false);
		   // t9.setEditable(false);





		}


		if(str.equals("Withdraw"))
		{
					count++;

			fl1++;

         p10 = new JPanel();
	     p11 = new JPanel(new GridLayout(4,2));
	     p12 = new JPanel(new GridLayout(1,3));
	     l11 = new JLabel("Account_No");    l12 = new JLabel("Name");  l13 = new JLabel("Balance");   l14 = new JLabel("Amount");
	     t11 = new JTextField(20);          t12 = new JTextField(20);  t13 = new JTextField(20);      t14 = new JTextField(20);
	     p11.add(l11); p11.add(t11);         p11.add(l12); p11.add(t12); p11.add(l13); p11.add(t13);     p11.add(l14); p11.add(t14);
	     b12 = new JButton("Next2");         b13 = new JButton("With_Draw");  b14 = new JButton("Reset");  b15 = new JButton("Close");
	     p12.add(b12); p12.add(b13);         p12.add(b14); p12.add(b15);
	     p10.add(p11);  p10.add(p12);
	     jif4.add(p10);


			System.out.println("hiiiii");
	    	b12.addActionListener(this);
		    b13.addActionListener(this);
		    b14.addActionListener(this);
		    b15.addActionListener(this);

	    jif4.setVisible(true);
	    jif4.setSize(500,300);

	    //t12.setEditable(false);
	    //t13.setEditable(false);


		}

			if(str.equals("Save"))
		{
			try
		    {
		    	try{
		    		 System.out.println(t2.getText()+" "+t3.getText());
		    	     String s1 = t3.getText();
		    	      n1 = Integer.parseInt(s1);
		    	     System.out.println(n1+"");

		    	}
		    	catch(NumberFormatException e2)
		    	{
		    		JOptionPane.showMessageDialog(jif1,"Please Enter Integer Value","Alert",JOptionPane.PLAIN_MESSAGE);
		    		t3.setText("");
		    	}

		    	     	if(n1> = 0)
		    	     {
		    	     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	                 Connection con = DriverManager.getConnection("Jdbc:Odbc:Bank");
		    	     Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    	     String insert_Query = "insert into bank1 values(" + accountno + ",' " + t2.getText() +" ',' " + t3.getText() + " ')";
			         stmt.execute(insert_Query);
			         JOptionPane.showMessageDialog(jif1,"Your Account has been created!","Thank You",JOptionPane.PLAIN_MESSAGE);
			         accountno = accountno+1;
			         t1.setText(accountno+"");
			         t2.setText("");
			         t3.setText("");

		    	     }
		    	     else
		    	     {
		    	     	JOptionPane.showMessageDialog(jif1,"Please Enter Positive value","Alert!!!",JOptionPane.PLAIN_MESSAGE);
		    	     	t3.setText("");
		    	     }
			}
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
			}


		}


		if(str.equals("Delete"))
		{
			try
			{


				     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	                 Connection con = DriverManager.getConnection("Jdbc:Odbc:Bank");
		    	     Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    	     String delete_Query = "Delete from bank1 where Account_No = "+name;
			         stmt.execute(delete_Query);
			         JOptionPane.showMessageDialog(jif2,"Your Account has been Deleted","Thank You",JOptionPane.PLAIN_MESSAGE);

			         if(t4.getText().equals(t7.getText()))
			         {
			         	t7.setText("");
			         	t8.setText("");
			         	t9.setText("");
			         	t10.setText("");
			         }

			         if(t4.getText().equals(t11.getText()))
			         {
			         	t11.setText("");
			         	t12.setText("");
			         	t13.setText("");
			         	t14.setText("");
			         }

			          if(t13.getText().equals(t9.getText()))
                     {
                     	t9.setText(r);
                     	t6.setText(r);
                     }
                      if(t9.getText().equals(t13.getText()))
                     {
                     	t13.setText(t);
                     	t6.setText(t);
                     }
			         t4.setText("");
			         t5.setText("");
			         t6.setText("");



			}
			catch(Exception e4)
			{
				e4.printStackTrace();
			}

		}



		if(str.equals("Update"))
		{
				 try
				 {
				 	account = t10.getText();
				     no = Integer.parseInt(account);
				     System.out.println(no+"")	;


				 }
				 catch(NumberFormatException e2)
				 {
				 	c2 = 1;
				 	JOptionPane.showMessageDialog(jif3,"Please Enter Integer Value","Alert",JOptionPane.PLAIN_MESSAGE);
		    		t10.setText("");

				 }
				 try
			{



				     if(no> = 0 && c2== 0)
				     {
				     	System.out.println(mark+"");
				     	total = no+mark;                      // values(" + rollno + ",' " + name +" ',' " + marks + " ')";
	                 System.out.println(total+"");

	                  t = total+"";
	                 System.out.println(t);


				     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	                 Connection con = DriverManager.getConnection("Jdbc:Odbc:Bank");
		    	     Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		             String where = "where Account_No = "+name;

		             String update_Query = "Update bank1 set balance = "+t+" "+"where Account_No = "+name;


		          // String update_Query = "Update bank1 set balance = " + total+"  "+"where Accont_No = "+name;
			         stmt.execute(update_Query);
                     JOptionPane.showMessageDialog(jif3,"Your Account has been Updated","Thank You",JOptionPane.PLAIN_MESSAGE);


                     if(t9.getText().equals(t13.getText()))
                     {
                     	t13.setText(t);
                     }
			         t7.setText("");
			         t8.setText("");
			         t9.setText("");
			         t10.setText("");


				     }

				     if(no <  0)
				     {
				     	JOptionPane.showMessageDialog(jif3,"Please Enter Positive value","Alert!!!",JOptionPane.PLAIN_MESSAGE);
		    	     	t10.setText("");

				     }

			}
			catch(Exception e5)
			{
				e5.printStackTrace();
			}
		  c2 = 0;
		}


		if(str.equals("With_Draw"))
		{
			try
			{
				try
				{
					account = t14.getText();
				    no = Integer.parseInt(account);
				}

				catch(NumberFormatException e2)
				{
					c2 = 1;
					JOptionPane.showMessageDialog(jif4,"Please Enter Integer Value","Alert!!",JOptionPane.PLAIN_MESSAGE);
					t14.setText("");
				}
				     if(no> = 0 && c2== 0)
				    {
				    	 total = mark-no;
				    	  r = total+"";
				    if(total> = 0)
				    {

				    	 System.out.println(total+"");



	                String t = total+"";
	                 System.out.println(t);

				    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	                Connection con = DriverManager.getConnection("Jdbc:Odbc:Bank");
		    	    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		             String update_Query = "Update bank1 set balance = "+t+" "+"where Account_No = "+name;

		          //String update_Query = "Update bank1 set balance = total where Account_No = "+name ;
		            stmt.execute(update_Query);
                    JOptionPane.showMessageDialog(jif4,"Your Account has been Updated","Thank You",JOptionPane.PLAIN_MESSAGE);

                     if(t13.getText().equals(t9.getText()))
                     {
                     	t9.setText(r);
                     }

			        t11.setText("");
			        t12.setText("");
			        t13.setText("");
			        t14.setText("");
				    }
				    else
				    {
				    	 JOptionPane.showMessageDialog(jif4,"You don't have Rs."+no+" "+"in your Account","Alert!!",JOptionPane.PLAIN_MESSAGE);
				    	 t11.setText("");
			             t12.setText("");
			             t13.setText("");
			             t14.setText("");
				    }



				    }
				  if(no <  0)
				  {
				  	JOptionPane.showMessageDialog(jif4,"Please Enter Positive value","Alert!!!",JOptionPane.PLAIN_MESSAGE);
		    	     	t14.setText("");

				  }


			}
			catch(Exception e4)
			{
				e4.printStackTrace();
			}
			c2 = 0;

		}
		if(str.equals("Close"))
		{

			jif1.setVisible(false);
			jif2.setVisible(false);
			jif3.setVisible(false);
			jif4.setVisible(false);

		}

		if(str.equals("Reset"))
		{
			if(count== 0 && OpenClicked== 0)
			{
					t2.setText("");
			        t3.setText("");

			}
			else
				if(count== 0 && OpenClicked== 1)
				{
				    t4.setText("");
			        t5.setText("");
			        t6.setText("");
				}

			else
				if(fl1== 0)
			{
				    t7.setText("");
			        t8.setText("");
			        t9.setText("");
			        t10.setText("");



			}
			else
			{
				    t11.setText("");
			        t12.setText("");
			        t13.setText("");
			        t14.setText("");
			}

		}


		if(str.equals("Exit"))
		{
			f.setVisible(false);
		}



	}

public static void main(String args[])
	{
		FinalBank i = new FinalBank();
	}
}
