package com.data.structure;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 磁盘容量排序
 * 3
 * 1T
 * 20M
 * 3G
 * @author Taoweidong
 */
public class HuaWei_Test20200331_02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			//输入参数
			int count = Integer.valueOf(sc.nextLine());

			PriorityQueue<Disk> disks = new PriorityQueue<Disk>((x, y) -> x.mv - y.mv);

			for (int i = 0; i < count; i++) {
				String str = sc.nextLine();

				Integer m = Integer.valueOf(str.substring(0, str.length() - 1));
				String v = str.substring(str.length() - 1);

				Disk disk = new Disk(m, v);
				disks.add(disk);
			}

			for (Disk disk : disks) {
				System.out.println(disk.m + disk.v);
			}

		}
	}

}

class Disk {

	/**
	 * 容量大小
	 */
	public Integer m;

	/**
	 * 单位
	 */
	public String v;

	/**
	 * 单位换算后的大小
	 */
	public int mv;

	public Disk(Integer m, String v) {

		this.m = m;
		this.v = v;
		if ("G".equals(v)) {
			this.mv = m * 1000;
		} else if ("T".equals(v)) {
			this.mv = m * 1000 * 1000;
		} else {
			this.mv = m;
		}
	}

	@Override public String toString() {

		return "Disk{" + "m=" + m + ", v='" + v + '\'' + ", mv=" + mv + '}';
	}
}
