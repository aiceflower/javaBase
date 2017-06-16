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
public class Server {
	public static void main(String[] args) {
		/*
		 * 1:����socket����ָ������˿�2:׼��һ���������ݵİ�
		 * 3:�������ݣ������������󣬽��հ�����һЩ�仯��������Ҫ���о��пͻ��˷��͹����������ˣ� ���Ұ�Ҳ֪��ʵ�ʷ��͹����������ж೤��
		 * ������֪������Щ�����Ǵ��������ģ��ͻ��˵ĵ�ַ��Ϣ��4:���������
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
			System.out.println("�ͻ���˵��" + str);
			
			/*
			 * �ظ��ͻ���
			 */
			str = "��ÿͻ��ˣ�";
			byte[] data = str.getBytes("UTF-8");
			// ���
			// Զ�̼�����ĵ�ַ
			InetAddress address = packet.getAddress();
			// Զ�̼�����Ķ˿�
			int port = packet.getPort();
			
			packet = new DatagramPacket(data,data.length,address,port);
			// ����
			socket.send(packet);
			socket.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}