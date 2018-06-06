package chat.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import chat.server.ServerGui;

public class ClientGui extends JFrame implements ActionListener {

	private JTextArea jta = new JTextArea(40,25);
	private JTextField jtf = new JTextField(25);
	private ClientBackground client = new ClientBackground();
	
	public ClientGui() {
		
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200,100,400,600);
		setTitle("Ŭ���̾�Ʈ");
		
		client.setGui(this);
		client.connect();
	}
	
	public static void main(String[] args) {
		new ClientGui();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String msg = jtf.getText() + "\n";
		jta.append("Ŭ���̾�Ʈ : " + msg);
		System.out.println(msg);
		client.sendMessage(msg);
		jtf.setText("");
	}
	
	public void appendMsg(String msg) {
		jta.append(msg);
	}
}
