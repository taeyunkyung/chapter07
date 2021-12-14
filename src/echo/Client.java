package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {

		Socket socket = new Socket();

		System.out.println("<클라이언트 시작>");
		System.out.println("========================================");
		System.out.println("[서버에 연결을 요청합니다.]");

		socket.connect(new InetSocketAddress("192.168.0.4", 10001));
		System.out.println("[서버에 연결되었습니다.]");

		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		// Scanner sc = new Scanner(System.in);
		InputStream in = System.in;
		InputStreamReader sisr = new InputStreamReader(in);
		BufferedReader sbr = new BufferedReader(sisr);

		while (true) {
			// String str = sc.nextLine();
			String str = sbr.readLine();

			if ("/q".equals(str)) {
				System.out.println("종료키 입력");
				break;
			}

			bw.write(str);
			bw.newLine();
			bw.flush();

			String reMsg = br.readLine();
			System.out.println("server:[" + reMsg + "]");

		}

		System.out.println("========================================");
		// System.out.println("<클라이언트 종료>");
		OutputStream out = System.out;
		OutputStreamWriter posr = new OutputStreamWriter(out);
		BufferedWriter pbw = new BufferedWriter(posr);

		pbw.write("<클라이언트 종료> 스트림사용구현");
		pbw.newLine();
		pbw.flush();

		// sc.close();
		bw.close();
		socket.close();
	}

}
