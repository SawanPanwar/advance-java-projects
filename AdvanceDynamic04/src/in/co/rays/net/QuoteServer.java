package in.co.rays.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class QuoteServer {

	public static void main(String[] args) throws IOException {

		String[] quotes = { "Bura Mat Dekho", "Bura Mat kaho", "Bura Mat suno" };

		DatagramSocket socket = new DatagramSocket(4445);

		byte[] buf = new byte[256];

		DatagramPacket packet = new DatagramPacket(buf, buf.length);

		boolean flag = true;

		while (flag) {

			socket.receive(packet);

			InetAddress address = packet.getAddress();

			int port = packet.getPort();

			int ind = (int) (Math.random() * 2);

			byte[] quote = quotes[ind].getBytes();

			DatagramPacket quotePkt = new DatagramPacket(quote, quote.length, address, port);

			socket.send(quotePkt);
		}

		socket.close();
	}
}
