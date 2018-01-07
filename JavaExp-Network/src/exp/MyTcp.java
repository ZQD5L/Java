package exp;

import java.net.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MyTcp extends JFrame {

	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;

	private PrintWriter writer;
	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();

	Container cc;

	public MyTcp(String title) {
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
				ta.append("\nSend to Client:"+tf.getText()+'\n');
				ta.setSelectionEnd(ta.getText().length());
				tf.setText("");
			}
		});
	}


	void getServer() {

		try {
			server = new ServerSocket(8998);
			ta.append("Socket created !\n");
			while (true) {
				ta.append("Waitting client link......\n");
				socket = server.accept();
				writer = new PrintWriter(socket.getOutputStream(), true);
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getClientMessage() {
		try {
			while (true)
				ta.append("\nReceive from Client:" + reader.readLine() + "\n");
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
		MyTcp tcp = new MyTcp("Server");
		tcp.setSize(300, 300);
		tcp.setVisible(true);
		tcp.getServer();
	}
}
