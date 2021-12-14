package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.0.4", 10001));

		System.out.println("<서버 시작>");
		System.out.println("========================================");
		System.out.println("[신호를 기다리고 있습니다.]");

		while (true) { // 얼마나 많이 연결될지 모름

			Socket socket = serverSocket.accept();

			Thread thread = new ServerThread(socket); // 전화번호 전달
			thread.start(); // 출장나감, [run: 선보강, 메세지 주고받기], 출장종료

		}

		/*
		System.out.println("========================================");
		System.out.println("<서버종료>");

		socket.close();
		serverSocket.close();
		*/
	}

}
