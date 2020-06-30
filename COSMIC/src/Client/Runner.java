package Client;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;

import Function.ColorEdit;
import Function.Format;
import GUI.Window;
import Image.ImageArrEdit;
import MacroProcess.Slide;

/**
 * @author Seth Knoop, Pyojeong Kim, Mitali Chowdhury
 *
 */
public class Runner {

	public static void main(String[] args) throws IOException {
		ArrayList<String> files = Function.Util.findAllFiles(Function.Constants.in_path,
				"png");
//		int[] images = { 54, 87, 129, 153, 351, 468, 474, 183, 273 };
		for (int i = 0; i < files.size(); i++) {
			System.out.println("Image: " + files.get(i));
			slide(files.get(i));
		}
//		int i = 1;
//		for (String file : files) {
//			System.out.println("Image " + (3*i++) + ": " + file);
//			slide(file);
//		}
	}

	public static void test() throws IOException {
		FrameProcess.Master.findMine("", true);
		// FrameProcess.Master.findMine("sonar3.png", true);
	}

	public static void slide(String file) throws IOException {
		MacroProcess.Master.findMine(file);
	}

	public static void image() throws IOException {

		int[][] arr = new int[][] { { -2 } };

		Window.create("Image", "sonar2.png", arr, 1, 1, true);
	}
}
