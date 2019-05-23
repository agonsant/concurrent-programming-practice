package parte1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//Extends from Thread for accepting multiple connections at the same time
//The server opens a socket with the client and gives it the requested file(s)
public class FileServer extends Thread {

	private final int PORT = 4026;

	private ServerSocket s;

	public FileServer() {
		// Create the server in the constructor given a port
		this.startServer();
	}

	public void run() {
		// Infinite loop trying to accept new connections and processing it
		while (true) {
			try {
				// accept the client socket
				Socket clientSocket = s.accept();
				System.out.println("Connected client " + s.getInetAddress());
				// process the client connection
				this.processClientConnection(clientSocket);
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void processClientConnection(Socket clientSocket) {
		PrintWriter pr = null;
		BufferedReader br = null, bfr = null;

		try {
			br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			pr = new PrintWriter(clientSocket.getOutputStream());
			String file = br.readLine();
			System.out.println("Message for client: " + file);
			bfr = new BufferedReader(new FileReader(file));
			String strCurrentLine;
			while ((strCurrentLine = bfr.readLine()) != null) {
				pr.write(strCurrentLine + "\n");
			}
			pr.flush();
		} catch (IOException e) {
			e.printStackTrace();
			if(pr!=null) {
				pr.write(e.getMessage());
				pr.flush();
			}
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bfr != null) {
				try {
					bfr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (pr != null) {
				pr.close();
			}
		}
	}

	public void startServer() {
		try {
			this.s = new ServerSocket(this.PORT);
			System.out.println("Server started at port " + this.PORT + ". " + this.s.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void stopServer() {
		if (this.s != null) {
			try {
				this.s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
