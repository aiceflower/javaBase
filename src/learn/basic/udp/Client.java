package learn.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * ʹ��UDPЭ��ͨѶ�Ŀͻ���
 * 
 * @author tarena
 *
 */
public class Client {
	public static void main(String[] args) {
		try{
			/*
			 * 1:����Socket 2:׼������ 3:��� 4:����
			 */
			// ����Socket
			DatagramSocket socket = new DatagramSocket();
			// ׼������
			String str = "��÷�������";
			byte[] data = str.getBytes("UTF-8");
			// 3:���
			// Զ�̼�����ĵ�ַ
			InetAddress address = InetAddress.getByName("localhost");
			// Զ�̼�����Ķ˿�
			int port = 8088;
			
			DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
			// 4:����
			socket.send(packet);
			/*
			 * ���շ���˷��͵���Ϣ
			 */
			//2
			byte[] buf = new byte[100];
			packet = new DatagramPacket(buf,buf.length);
			//3
			socket.receive(packet);
			
			//4
//			byte[] data = packet.getData();
			str = new String(buf,0,packet.getLength(),"UTF-8");
			System.out.println("������˵��" + str);
			
			socket.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
