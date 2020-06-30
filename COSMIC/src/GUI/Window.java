package GUI;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import FrameProcess.*;
import Function.*;

/**
 * Display steps of processing
 *
 */
public class Window {

	/**Number of windows created */ static int count = 1;
		
	/** 
	 * Create a window 
	 * @param name window name
	 * @param file 
	 * @param arr
	 * @param cenN
	 * @param type window location
	 */
	public static void create(String name, String file, int[][] arr, int cenN, int type, boolean save) {
		name = name + " " + count++;
		Frame p = new Frame(name);
		p.pane.draw(file, arr, cenN);
		
		if (save) p.capture(name);
		
		int x = 625*((type - 1)%4);
		int y = type <= 3 ? 0 : 700;
		p.setLocation(x, y);
		
		if (!save) { 
			double time = System.currentTimeMillis();
			while(System.currentTimeMillis() - time < 100)
				continue;
			p.cleanup();
		}
	}
	
	/**
	 * Show step in window
	 * @param file
	 * @param cenN
	 * @param name
	 */
	public static void display(String file, int cenN, String name, boolean save) {
		
		if (name.equals("Topograph") || name.equals("Plane"))
			create(name, file, Format.cenArea(Cluster.tmap, Cluster.cens), cenN, name.equals("Topograph") ? 1 : 5, save);
		if (name.equals("Scan"))
			create(name, file, Format.Area(Scan.tmap), cenN, 6, save);
		if (name.equals("Color Reduce"))
			create(name, file, Format.blinkArea(Sift.map), cenN, 2, save);
		if (name.equals("Cut"))
			create(name, file, Format.blinkArea(Polish.rmap), 1, 7, save);
		if (name.equals("Box"))
			create(name, file, Format.boxArea(Box.bmap), cenN, 8, save);
		
	}
	
}
