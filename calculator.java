package calculator;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTextField;

public class calculator {

	private JFrame frame;
	private JTextField textField;
	static double total = 0;
	static String num1 = "";
	static String num2 = "";
	static double val;
	static double val2;
	static int c_flag = 0;
	static boolean dec = false;
	static boolean dec2 = false;
	static boolean total_flag = false;
	static boolean edit_flag = false;
	static ArrayList list = new ArrayList();
	static int editing = 0;
	static int pos;
	char operator;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculator window = new calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number("1");
			}
		});
		btnNewButton.setBounds(6, 69, 58, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number("2");
			}
		});
		button.setBounds(58, 69, 58, 29);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("3");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number("3");
			}
		});
		button_1.setBounds(111, 69, 58, 29);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("4");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number("4");
			}
		});
		button_2.setBounds(6, 98, 58, 29);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("5");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number("5");
			}
		});
		button_3.setBounds(58, 98, 58, 29);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("6");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number("6");
			}
		});
		button_4.setBounds(111, 98, 58, 29);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("7");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number("7");
			}
		});
		button_5.setBounds(6, 127, 58, 29);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("8");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number("8");
			}
		});
		button_6.setBounds(58, 127, 58, 29);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("9");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number("9");
			}
		});
		button_7.setBounds(111, 127, 58, 29);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton(".");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(edit_flag == true)
				{
					if(editing ==1)
					{
						dec = true;
						num1 = num1+".";
						val = Double.parseDouble(num1);
					//System.out.println(val);
						textField.setText(""+(int)val);
					}
					else
					{
						dec2 = true;
						num2 = num2+".";
						val2 = Double.parseDouble(num2);
					//System.out.println(val2);
						textField.setText(""+(int)val2);
					}
				}
				else
				{
					if(c_flag == 0)//go in val
					{
						dec = true;
						num1 = num1+".";
						val = Double.parseDouble(num1);
					//System.out.println(val);
						textField.setText(""+(int)val);
					}
					else
					{
						dec2 = true;
						num2 = num2+".";
						val2 = Double.parseDouble(num2);
					//System.out.println(val2);
						textField.setText(""+(int)val2);
					}
				}
			}
		});
		button_8.setBounds(6, 157, 58, 29);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("0");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number("0");
			}
		});
		button_9.setBounds(58, 157, 58, 29);
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("=");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				print();
				total_flag = true;
				dec = false;
				dec2 = false;
				c_flag = 0;
				//val = 0;
				//val2 = 0;
				num1 = "";
				num2 = "";
			}
		});
		button_10.setBounds(111, 157, 58, 29);
		frame.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("+");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(pos);
				c_flag++;
				//System.out.println("You have pressed +");
				operator = '+';
			}
		});
		button_11.setBounds(181, 69, 85, 29);
		frame.getContentPane().add(button_11);
		
		JButton button_12 = new JButton("-");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c_flag++;
				//System.out.println("You have pressed -");
				operator = '-';
			}
		});
		button_12.setBounds(181, 98, 85, 29);
		frame.getContentPane().add(button_12);
		
		JButton button_13 = new JButton("/");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c_flag++;
				//System.out.println("You have pressed /");
				operator = '/';
			}
		});
		button_13.setBounds(181, 127, 85, 29);
		frame.getContentPane().add(button_13);
		
		JButton button_14 = new JButton("*");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c_flag++;
				//System.out.println("You have pressed *");
				operator = '*';
			}
		});
		button_14.setBounds(181, 157, 85, 29);
		frame.getContentPane().add(button_14);
		
		textField = new JTextField();
		textField.setBounds(6, 29, 260, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCe = new JButton("CE");
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dec = false;
				dec2 = false;
				edit_flag = false;
				c_flag = 0;
				val = 0;
				val2 = 0;
				total = 0;
				num1 = "";
				num2 = "";
				textField.setText("");
				list.clear();
			}
		});
		btnCe.setBounds(6, 191, 58, 29);
		frame.getContentPane().add(btnCe);
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < list.size()-3; i++)
				{
					list.remove(i);
				}
				System.out.println("size = "+list.size());
				theList(-1);
			}
		});
		btnNewButton_1.setBounds(68, 191, 43, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(">");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < list.size()-3; i++)
				{
					list.remove(i);
				}
				theList(1);
			}
		});
		btnNewButton_2.setBounds(121, 191, 43, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("EDIT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				edit_flag = true;
			}
		});
		btnNewButton_3.setBounds(181, 191, 85, 29);
		frame.getContentPane().add(btnNewButton_3);
	}
	public void number(String a)
	{
		if(total_flag )
		{
			if(edit_flag == true)
			{System.out.println("Value 1= "+val+" val2 = "+val2);}
			else{
			val = total;
			addList(val);
			num2 = num2+a;
			val2 = Double.parseDouble(num2);
			//System.out.println(val2);
			if(dec2 == false)
			{
				textField.setText(""+(int)val2);
			}
			else
			{
				textField.setText(""+val2);
			}
			addList(val2);
			}
		}
		else if(edit_flag == false)
		{
			if(c_flag == 0)//go in val
			{
				num1 = num1+a;
				//System.out.println("num1 - "+num1);
				val = Double.parseDouble(num1);
				if(dec == false)
				{
					textField.setText(""+(int)val);
				}
				else
				{
					textField.setText(""+val);
				}
				addList(val);
			}
			else
			{
				num2 = num2+a;
				//System.out.println("num2 - "+num2);
				val2 = Double.parseDouble(num2);
				if(dec2 == false)
				{
					textField.setText(""+(int)val2);
				}
				else
				{
					textField.setText(""+val2);
				}
				addList(val2);
			}
		}
		if(edit_flag == true)
		{
			System.out.println("Size of list = "+list.size());
			double v= (double) list.get(pos);
			System.out.println("here");
			if(v == val)
			{
				System.out.println("in else ");
				editing = 1;
				num1 = "";
				num1 = num1+a;
				//System.out.println("num1 - "+num1);
				val = Double.parseDouble(num1);
				if(dec == false)
				{
					textField.setText(""+(int)val);
				}
				else
				{
					textField.setText(""+val);
				}
				System.out.println("in else "+val);
				list.remove(pos);
				addList(val);
			}
			else
			{
				editing = 2;
				num2 = "";
				num2 = num2+a;
					//System.out.println("num2 - "+num2);
				val2 = Double.parseDouble(num2);
				if(dec2 == false)
				{
					textField.setText(""+(int)val2);
				}
				else
				{
					textField.setText(""+val2);
				}
				System.out.println("in else "+val2);
				list.remove(pos);
				addList(val2);
			}
		}
	}
	public void print()
	{
		System.out.println("val1 = "+val);
		System.out.println("val2 = "+val2);
		switch(operator)
		{
		case '+':
			total = val + val2;
			textField.setText(""+total);
			//System.out.println(pos);
			//c_flag = 0;
			break;
		case '-':
			total = val - val2;
			//System.out.println("-");
			textField.setText(""+total);
			//c_flag = 0;
			break;
		case '/':
			total = val / val2;
			//System.out.println("/");
			textField.setText(""+total);
			//c_flag = 0;
			break;
		case '*':
			total = val * val2;
			//System.out.println("*");
			textField.setText(""+total);
			//c_flag = 0;
			break;
		}
	}
	public void addList(double value)
	{
		list.add(value);
		//System.out.println("Size = "+list.size());
		pos = list.size();
		//System.out.println("POS = "+pos);
	}
	public void theList(int a)
	{
		if(a == -1)
		{
			pos--;
			if(pos < 0)
			{
				pos++;
			}
			if(pos > -1)
			{
				textField.setText(""+list.get(pos));
				System.out.println(pos+" = pos");
			}
		}
		else
		{
			pos++;
			if(pos >= list.size())
			{
				pos = list.size()-1;
			}
			if(pos <= list.size()-1)
			{
				textField.setText(""+list.get(pos));
				System.out.println(pos+" = pos");
			}
		}
	}
}

