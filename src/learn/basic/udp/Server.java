package learn.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 使用UDP协议通讯的客户端
 * 
 * @author tarena
 *
 */
public class Server {
	public static void main(String[] args) {
		/*
		 * 1:创建socket，并指定服务端口2:准备一个接收数据的包
		 * 3:接收数据，这个过程做完后，接收包会有一些变化，首先需要包中就有客户端发送过来的数据了， 并且包也知道实际发送过来的数据有多长，
		 * 　包还知道了这些数据是从哪里来的（客户端的地址信息）4:拆包拿数据
		 */
		try{
			//1
			DatagramSocket socket = new DatagramSocket(8088);
			//2
			byte[] buf = new byte[100];
			DatagramPacket packet = new DatagramPacket(buf,buf.length);
			//3
			socket.receive(packet);
			
			//4
//			byte[] data = packet.getData();
			String str = new String(buf,0,packet.getLength(),"UTF-8");
			System.out.println("客户端说：" + str);
			
			/*
			 * 回复客户端
			 */
			str = "你好客户端！";
			byte[] data = str.getBytes("UTF-8");
			// 打包
			// 远程计算机的地址
			InetAddress address = packet.getAddress();
			// 远程计算机的端口
			int port = packet.getPort();
			
			packet = new DatagramPacket(data,data.length,address,port);
			// 发送
			socket.send(packet);
			socket.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}