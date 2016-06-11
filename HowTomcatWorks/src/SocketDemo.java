import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketDemo {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("localhost",8081);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out=null;
		BufferedReader in=null;
		try {
			out = new PrintWriter(socket.getOutputStream(),true);
		    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//send the data to the server.
		
		out.println("GET / HTTP/1.1");
		out.println("Host: localhost:8080");
		out.println("Connection: Close");
		out.println();
		
		//Read the response
		
		boolean loop = true;
		StringBuffer sb = new StringBuffer(8096);
		
		try{
			while(loop){
				if(in.ready()){
					int i=0;
					while(i!=-1){
						i=in.read();
						sb.append((char)i);
						
					}
					loop=false;
				}
				
			}
		}catch(Exception e){
			
		}
		
//		try {
//			Thread.currentThread().sleep(50);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println(sb.toString());
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
