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
			System.out.println("서버 연결됨");
			
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
			out.writeUTF("안녕 나는 클라이언트");
			System.out.println("메시지 전송완료");
			
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
			out.writeUTF("클라이언트 : " + msg2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
