package IO.Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class S8_ObjectSocketClient {

	//ObjectInput/OutputStream 보조스트림을 이용한 통신구현예제(클라이언트)
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		log.debug("main({}) invoked.", Arrays.toString(args));
		
		Member member = new Member();
		member.setId(0);
		member.setName("bibian");
		member.setAge(23);
//		---
		String serverAddress = "localhost";
		int serverPort = 7777;
		int connectTimeout = 1000*1; //milliseconds
//		---
		
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress(serverAddress,serverPort), connectTimeout); //Block I/O
		log.info("1. Connected to server, socket: {}", socket);
		
//		---
		
		try(socket){
			
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			oos.writeObject(member);
			oos.flush();
			
			log.info("2. Sended a member to server : {}", member);
//			---
			
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			member = (Member)ois.readObject();
			log.info("3. Recevied a member from server : {}", member);
			
		}//try-with-resource
		
	}//main
}//end class
