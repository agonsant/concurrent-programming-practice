package parte1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileClient {
	
	public static void main(String[] args) {
		PrintWriter writer = null;
		BufferedReader br = null;
		Socket socket = null;
		try {
			//Create the socket to the server
			socket = new Socket("localhost", 4026);
			//Create the output stream to send information to the server
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("C:/Users/agonsant/Desktop/Proyectos/Universidad/concurrent-programming-practice/practice-5-sockets/README.md");
			//Create the input stream to receive the data from the server
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (writer != null) {
				writer.close();
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
