package view;

import javax.swing.*;
import controller.LoginService;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
public class loginFrame2 extends JFrame implements ActionListener{

	ImageIcon icon =null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton bt;
	
	
	//������
	public loginFrame2(){
		setTitle("kw로그인");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		//GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(this);
		
		
		//Mypanel Mypanel = new Mypanel();
		//Mypanel.setBounds(0,0, 1000, 600);
		
		loginTextField = new JTextField(15);
		loginTextField.setBackground(Color.white);
        loginTextField.setBounds(700, 400, 200, 30);
        loginTextField.setForeground(Color.green);
		
        
		setContentPane(new Mypanel());
		contentPane.add(loginTextField);
		setSize(1000,600);
		setResizable(false);
		setVisible(true);
	}
	
	class Mypanel extends JPanel{
		ImageIcon icon = new ImageIcon("img/img/loginview.png"); //img/img/login.png
		Image img = icon.getImage();
	    	
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			g.drawImage(img,0,0,getWidth(), getHeight(),this);
		}
	}
	
	public static void main(String[] args) {
		new loginFrame2();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
*/