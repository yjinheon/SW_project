package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBackground {

	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ClientGui gui;
	private String msg;
	
	
	public void connect() {
		try {
			socket = new Socket("127.0.0.1",7777);
			System.out.println("���� �����");
			
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
			out.writeUTF("�ȳ� ���� Ŭ���̾�Ʈ");
			System.out.println("�޽��� ���ۿϷ�");
			
			while(in!=null) {
				msg= in.readUTF();
				gui.appendMsg(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void setGui(ClientGui gui) {
		this.gui = gui;
	}
	public static void main(String[] args) {
		ClientBackground clientBackground = new ClientBackground();
		clientBackground.connect();

	}
	public void sendMessage(String msg2) {
		try {
			out.writeUTF("Ŭ���̾�Ʈ : " + msg2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
