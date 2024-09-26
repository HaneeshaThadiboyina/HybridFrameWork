//Screenshots using JAVA
package ScreenShots;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

public class Sample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello World");
		try {
			Robot robot = new Robot();
			Date currentDate = new Date();
			String Datefile = currentDate.toString().replace(" ", "-").replace(":", "-"); 
			String path = "C://Users//2082500//Workspace_For_Eclipse//MvnProject//screenShot//"+Datefile+".png";
			Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenShot = robot.createScreenCapture(rect);
			try {
				ImageIO.write(screenShot, "PNG", new File(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
