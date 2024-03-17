package com.myswing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	private JLabel fnameLabel;
	private JLabel lnameLabel;
	private JTextField fnameText;
	private JTextField lnameText;
	private JButton addButton;
	public MyFrame()
	{
		getContentPane().setLayout(null);
		this.setVisible(true);
		this.setSize(400, 600);
		this.setTitle("Employee Management System");
			
		fnameLabel = new JLabel("First Name : ");
		fnameLabel.setBounds(20, 20, 100, 50);
		getContentPane().add(fnameLabel);
		
		fnameText = new JTextField(30);
		fnameText.setBounds(120, 35, 100, 20);
		getContentPane().add(fnameText);
			
		lnameLabel = new JLabel("Last Name : ");
		lnameLabel.setBounds(20, 60, 100, 50);
		getContentPane().add(lnameLabel);
		
		lnameText = new JTextField(30);
		lnameText.setBounds(120, 70, 100, 20);
		getContentPane().add(lnameText);
		
		addButton = new JButton("Add");
		addButton.setBounds(63, 144, 70, 25);
		getContentPane().add(addButton);
		addButton.addActionListener(new MyActionListener(this));
		
	
	}
	public static void main(String args[]) {
		MyFrame mf=new MyFrame();
	}
	class MyActionListener implements ActionListener{
		MyFrame mf;
		
		public MyActionListener(MyFrame f) {
			this.mf=f;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Button is clicked !!!");
			System.out.println(mf.fnameText.getText());
		}
		
	}
	
	
	
	
	
}
