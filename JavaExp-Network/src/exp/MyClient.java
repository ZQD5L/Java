package exp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class MyClient extends JFrame {
	private BufferedReader reader;
	private Socket socket;
	private PrintWriter writer;
	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();
	Container cc;

	public MyClient(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane();
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(ta);
		cc.add(tf, "South");
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				writer.println(tf.getText());
				ta.append("\nSend to Server:"+tf.getText()+'\n');
				ta.setSelectionEnd(ta.getText().length());
				tf.setText("");
			}

		});
	}



	private void connect() {

		ta.append("Try to connect...\n");

		try {
			socket = new Socket("127.0.0.1", 8998);
			writer = new PrintWriter(socket.getOutputStream(), true);

			ta.append("Connect successed!\n");

			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			getServerMessage();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

	private void getServerMessage() {
		try {
			while (true)
				ta.append("\nReceive from Server:" +reader.readLine()+ "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (reader != null) {
				reader.close();
			}
			if (socket != null) {
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		MyClient client = new MyClient("Client");
		client.setSize(300, 300);
		client.setVisible(true);
		client.connect();
	}

}
