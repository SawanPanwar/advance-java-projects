package in.co.rays.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(1234);

		Socket client = server.accept();

		DataInputStream in = new DataInputStream(client.getInputStream());

		String line = in.readLine();

		System.out.println(line);

		DataOutputStream out = new DataOutputStream(client.getOutputStream());

		out.writeBytes("Hello Client\n");

		client.close();

		server.close();

	}
}
