package IO.Network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class S9_MultiThreadSocketClient {
	
	private static final String host = "127.0.0.1";		//서버의 주소
	private static final int port = 7777; 				//서버의 Listen port
	
	public static void main(String[] args) {
		log.debug("main({}) invoked.", Arrays.toString(args));
		
		try {
			//소켓 생성 및 연결 시도
			Socket sock = new Socket();
			sock.connect(new InetSocketAddress(host,port), 1000); //연결만료시간 : 1초로 설정
			
			log.info("Connected to the server addr : {}, port: {}",host, port);
//			----
			new Sender01("Sender01", sock).start();
//			new Sender07("Sender07", sock).start();
//			----
			new Receiver01("Receiver01", sock).start();
			
		} catch ( IOException e) {
			e.printStackTrace();
			
		}//try-catch 
	}//main
	
	
}//end class
