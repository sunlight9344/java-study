package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		
//		buttonSend.addActionListener((ActionEvent e) -> {
//
//		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
			
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		// IOStream 받아오기
		//ChatClientThread 생성하고 실행
	}
	
	private void finish() {
		// quit 프로코톨 구현
		// exit java(JVM)
		System.exit(0);
	}

	private void sendMessage() {
		// 비어있으면 안되게
		String message = textField.getText();
		if(!message.isEmpty()) {
			System.out.println("메세지를 보내는 프로토콜 구현:" + message);
		}
		textField.setText("");
		textField.requestFocus();
		
		// ChatClientThread 에서 서버로부터 받은 메세지가 있다고 치고~~고치고치도슴고치고슴고치
		// 여기서 부르는거 아니다잉
		updateTextArea("마이콜: " + message);
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	// 이렇게 하는 이유 여기서 자기 위에 있는 outer class 의 method 를 사용할 수 있다.
	private class ChatClientThread extends Thread{

		@Override
		public void run() {
			updateTextArea("마이콜:안녕~");
		}
		
	}
}
