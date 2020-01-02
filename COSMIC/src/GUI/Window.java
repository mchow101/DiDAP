package GUI;

import FrameProcess.*;
import Function.*;

public class Window {

	static int count = 1;
	
	public static void create(String name, String file, int[][] arr, int cenN, int type) {
		
		Frame p = new Frame(name + " " + count++);
		p.draw(file, arr, cenN);
		
		int x = 625*((type - 1)%4);
		int y = type <= 3 ? 0 : 700;
		p.frame.setLocation(x, y);
	}
	
	public static void display(String file, int cenN, String name) {
		
		if (name.equals("Topograph") || name.equals("Plane"))
			create(name, file, Format.cenArea(Cluster.tmap, Cluster.cens), cenN, name.equals("Topograph") ? 1 : 5);
		if (name.equals("Scan"))
			create(name, file, Format.Area(Scan.tmap), cenN, 6);
		if (name.equals("Color Reduce"))
			create(name, file, Format.blinkArea(Sift.map), cenN, 2);
		if (name.equals("Cut"))
			create(name, file, Format.blinkArea(Polish.rmap), 1, 7);
		if (name.equals("Box"))
			create(name, file, Format.boxArea(Box.bmap), cenN, 8);
	}
}
