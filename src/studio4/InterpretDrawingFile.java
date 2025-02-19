package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		String shapeType = in.next();
		int red = in.nextInt();
		int green = in.nextInt();
		int blue = in.nextInt();
		StdDraw.setPenColor(red, green, blue);
		Boolean isfilled = in.nextBoolean();
		double[] parameter = new double[10];
		int i = 0;
		while (in.hasNextDouble()) {
			parameter[i] = in.nextDouble();
			System.out.println(i);
			i++;
		}
		System.out.println(shapeType);
		if (shapeType.equals("rectangle")) {
			if (isfilled == true) {
				StdDraw.filledRectangle(parameter[0],parameter[1], parameter[2], parameter[3]);
			}
			else {
				StdDraw.rectangle(parameter[0],parameter[1], parameter[2], parameter[3]);
			}
			System.out.println("rec");
			
		}
		else if (shapeType.equals("triangle")) {
			double[] parameterX = new double[3];
			parameterX[0] = parameter[0];
			parameterX[1] = parameter[2];
			parameterX[2] = parameter[4];
			double[] parameterY = new double[3];
			parameterY[0] = parameter[1];
			parameterY[1] = parameter[3];
			parameterY[2] = parameter[5];
			if (isfilled == true) {
				StdDraw.filledPolygon(parameterX, parameterY);
			}
			else {
				StdDraw.polygon(parameterX, parameterY);
			}
			System.out.println("tri");
		}
		else if (shapeType.equals("ellipse")) {
			if (isfilled == true) {
				StdDraw.filledEllipse(parameter[0],parameter[1], parameter[2], parameter[3]);
			}
			else {
				StdDraw.ellipse(parameter[0],parameter[1], parameter[2], parameter[3]);
			}
			System.out.println("eli");
		}
		
		
	}
}
