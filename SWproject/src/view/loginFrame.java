package view;
import javax.imageio.ImageIO;

import javax.swing.*;

import Signup.MemberProc;
import controller.LoginService;
import java.awt.GraphicsEnvironment;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;

public class loginFrame extends JFrame implements ActionListener{
	  //
	BufferedImage img = null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton bt;
	JButton bt2;
	int fheight = 700;
	int fweight = 1024;
	
    public static void main(String[] args) {
        new loginFrame();
    }
 
    // ������
    public loginFrame() {
        setTitle("로그인");
        setSize(fweight, fheight);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //
        setLayout(null);
        setLocation(200,20);
        
        //GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(this);
        //
        try {
        	img = ImageIO.read(new File("img/kwlogin.jpg"));
        }catch (IOException e) {
        	System.out.println(e.getMessage());
        	System.exit(0);
        }
        //ImageIcon icon = new ImageIcon("img/kwlogin.png"); //img/img/login.png
        //Image img = icon.getImage();	
        
        //layout
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0, fweight, fheight);
        layeredPane.setLayout(null);
        
        //panel
        Mypanel panel = new Mypanel();
        panel.setBounds(0,0, fweight, fheight);
        panel.setLayout(null);
        
        loginTextField = new JTextField(15);
        loginTextField.setBounds(400, 390, 280, 30);
        //loginTextField.setOpaque(false);
        loginTextField.setForeground(Color.green);
        
        panel.add(loginTextField);
        
        passwordField = new JPasswordField(15);
        passwordField.setBounds(400, 485, 280, 30);
        
        panel.add(passwordField);
        
        bt = new JButton(new ImageIcon("img/img/btlogin_hud.png"));
        bt.setBounds(610, 550, 104, 48);
        
        bt.setBorderPainted(false);
        bt.setFocusPainted(false);
        bt.setContentAreaFilled(false);
        bt.addActionListener(this);
        layeredPane.add(bt);
        
        bt2 = new JButton(new ImageIcon("img/img/signup_g.png"));
        bt2.setSize(20,20);
        bt2.setBounds(340, 550, 104, 48);
        bt2.setBorderPainted(false);
        bt2.setFocusPainted(false);
        bt2.setContentAreaFilled(false);
        bt2.addActionListener(this);
        layeredPane.add(bt2);
        //layeredPane.add(bt2);
        
        layeredPane.add(panel);
        add(layeredPane);
        
        setVisible(true);
    }
    
    class Mypanel extends JPanel{
    	public void paintComponent(Graphics g) {
    		
    		g.drawImage(img,0,0,getWidth(), getHeight(),this);
    	}
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = loginTextField.getText();
		char[] pass = passwordField.getPassword();
		String password = new String(pass);
		
		if(e.getSource()==bt2) {
			JOptionPane.showMessageDialog(null, "버튼2!");
			new MemberProc();
		}
		
		if(e.getSource()==bt) {
		if(id.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(null, "빈칸이 있음");
		}else {
			boolean existLogin = LoginService.loginTest(id, password);
			
			if(existLogin) {
				JOptionPane.showMessageDialog(null, "환영합니다");
			}else {
				JOptionPane.showMessageDialog(null, "로그인 실패");
			}
		}
		
	}
   }
}

