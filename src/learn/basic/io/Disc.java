package learn.basic.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;


public class Disc {
	private Icon icon;

	private String name;
	private String discription;
	private int usagePercent;

	public Disc(File disc){
		FileSystemView fsv = FileSystemView.getFileSystemView();
		icon = fsv.getSystemIcon(disc);
		name = "本地磁盘(" + disc.getAbsolutePath().substring(0, 2) + ")";
		String totalSpace = byteToGigabyte(disc.getTotalSpace());
		String freeSpace = byteToGigabyte(disc.getFreeSpace());
		discription = freeSpace + "GB可用,共" + totalSpace + "GB";
		usagePercent = (int) (100 * (disc.getTotalSpace() - disc.getFreeSpace()) / disc
				.getTotalSpace());
	}

	public Icon getIcon() {
		return icon;
	}

	public String getName() {
		return name;
	}

	public String getDiscription() {
		return discription;
	}

	public int getUsagePercent() {
		return usagePercent;
	}
	public static void main(String[] args) {
		File[] discs = File.listRoots();
		List<Disc> discList = new ArrayList<Disc>();
		for (File disc : discs) {
			if (disc.isDirectory()) {
				discList.add(new Disc(disc));
			}
		}
		Disc disc1 = discList.get(3);
		System.out.println((ImageIcon) disc1.getIcon());
		System.out.println(disc1.getDiscription());
		System.out.println(disc1.getName());
		System.out.println(disc1.getUsagePercent());
	}

	private String byteToGigabyte(long byteNumber) {
		double result = byteNumber / Math.pow(1024, 3);
		return String.format("%.1f", result);
	}
}
