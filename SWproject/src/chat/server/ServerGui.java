package chat.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ServerGui extends JFrame implements ActionListener {
	
	private JTextArea jta = new JTextArea(40,25);
	private JTextField jtf = new JTextField(25);
	//����
	private ServerBackground server = new ServerBackground();
	
	public ServerGui() {
		
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200,100,400,600);
		setTitle("서버");
		
		server.setGui(this);
		server.setting();
	}
	
	public static void main(String[] args) {
		new ServerGui();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String msg = jtf.getText() + "\n";
		jta.append("관리자메시지: " + msg);
		System.out.println(msg);
		
		server.sendMessage(msg);
		
		jtf.setText("");
	}

	public void appendMsg(String msg) {
		jta.append(msg);
		System.out.print("����� �޽��� : " + msg);
		
	}
	

}
