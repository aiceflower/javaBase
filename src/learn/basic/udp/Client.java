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
public class Client {
	public static void main(String[] args) {
		try{
			/*
			 * 1:创建Socket 2:准备数据 3:打包 4:发送
			 */
			// 创建Socket
			DatagramSocket socket = new DatagramSocket();
			// 准备数据
			String str = "你好服务器！";
			byte[] data = str.getBytes("UTF-8");
			// 3:打包
			// 远程计算机的地址
			InetAddress address = InetAddress.getByName("localhost");
			// 远程计算机的端口
			int port = 8088;
			
			DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
			// 4:发送
			socket.send(packet);
			/*
			 * 接收服务端发送的消息
			 */
			//2
			byte[] buf = new byte[100];
			packet = new DatagramPacket(buf,buf.length);
			//3
			socket.receive(packet);
			
			//4
//			byte[] data = packet.getData();
			str = new String(buf,0,packet.getLength(),"UTF-8");
			System.out.println("服户端说：" + str);
			
			socket.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
