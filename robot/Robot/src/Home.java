import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jgl.GL;
import jgl.GLCanvas;
import jgl.GLUT;

public class Home {
	
	private static final int checkImageWidth = 256;
	private static final int checkImageHeight = 256;
	private byte imageCenter[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageRight[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageLeft[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageTop[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageBottom[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageWallout[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageRoofAhead[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageRoofBack[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageRoofLeft[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageRoofRight[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageDoor[][][] = new byte[checkImageWidth][checkImageHeight][4];

	private int texName[] = new int[11];
	
	public void makeImage() {

		int i, j;

		float ti, tj;

		File bmpCenterFile = new File("img/center.bmp");
		File bmpRightFile = new File("img/floor.bmp");
		File bmpLeftFile = new File("img/floor.bmp");
		File bmpTopFile = new File("img/center.bmp");
		File bmpBottomFile = new File("img/floor.bmp");
		File bmpWalloutFile = new File("img/curtain.bmp");
		File roofAheadFile = new File("img/roof.bmp");
		File roofBackFile = new File("img/roof.bmp");
		File roofLeftFile = new File("img/roof.bmp");
		File roofRightFile = new File("img/roof.bmp");
		File doorFile = new File("img/curtain.bmp");




		try {
			BufferedImage iCenter = ImageIO.read(bmpCenterFile);
			BufferedImage iRight = ImageIO.read(bmpRightFile);
			BufferedImage iLeft = ImageIO.read(bmpLeftFile);
			BufferedImage iTop = ImageIO.read(bmpTopFile);
			BufferedImage iBottom = ImageIO.read(bmpBottomFile);
			BufferedImage iWallout = ImageIO.read(bmpWalloutFile);
			BufferedImage iRoofAhead = ImageIO.read(roofAheadFile);
			BufferedImage iRoofBack = ImageIO.read(roofBackFile);
			BufferedImage iRoofLeft = ImageIO.read(roofLeftFile);
			BufferedImage iRoofRight = ImageIO.read(roofRightFile);
			BufferedImage iDoor = ImageIO.read(doorFile);


			for (i = 0; i < checkImageWidth; i++) {
				for (j = 0; j < checkImageHeight; j++) {
					Color cCenter = new Color(iCenter.getRGB(i, j));
					Color cRight = new Color(iRight.getRGB(i, j));
					Color cLeft = new Color(iLeft.getRGB(i, j));
					Color cTop = new Color(iTop.getRGB(i, j));
					Color cBottom = new Color(iBottom.getRGB(i, j));
					Color cWallout = new Color(iWallout.getRGB(i, j));
					Color cRoofAhead = new Color(iRoofAhead.getRGB(i, j));
					Color cRoofBack = new Color(iRoofBack.getRGB(i, j));
					Color cRoofLeft = new Color(iRoofLeft.getRGB(i, j));
					Color cRoofRight = new Color(iRoofRight.getRGB(i, j));
					Color cDoor = new Color(iDoor.getRGB(i, j));



					imageCenter[j][i][0] = (byte) (cCenter.getRed());
					imageCenter[j][i][1] = (byte) (cCenter.getGreen());
					imageCenter[j][i][2] = (byte) (cCenter.getBlue());
					imageCenter[j][i][3] = (byte) (255);

					imageRight[j][i][0] = (byte) (cRight.getRed());
					imageRight[j][i][1] = (byte) (cRight.getGreen());
					imageRight[j][i][2] = (byte) (cRight.getBlue());
					imageRight[j][i][3] = (byte) (255);

					imageLeft[j][i][0] = (byte) (cLeft.getRed());
					imageLeft[j][i][1] = (byte) (cLeft.getGreen());
					imageLeft[j][i][2] = (byte) (cLeft.getBlue());
					imageLeft[j][i][3] = (byte) (255);

					imageTop[j][i][0] = (byte) (cTop.getRed());
					imageTop[j][i][1] = (byte) (cTop.getGreen());
					imageTop[j][i][2] = (byte) (cTop.getBlue());
					imageTop[j][i][3] = (byte) (255);

					imageBottom[j][i][0] = (byte) (cBottom.getRed());
					imageBottom[j][i][1] = (byte) (cBottom.getGreen());
					imageBottom[j][i][2] = (byte) (cBottom.getBlue());
					imageBottom[j][i][3] = (byte) (255);
					
					imageWallout[j][i][0] = (byte) (cWallout.getRed());
					imageWallout[j][i][1] = (byte) (cWallout.getGreen());
					imageWallout[j][i][2] = (byte) (cWallout.getBlue());
					imageWallout[j][i][3] = (byte) (255);
					
					imageRoofAhead[j][i][0] = (byte) (cRoofAhead.getRed());
					imageRoofAhead[j][i][1] = (byte) (cRoofAhead.getGreen());
					imageRoofAhead[j][i][2] = (byte) (cRoofAhead.getBlue());
					imageRoofAhead[j][i][3] = (byte) (255);
					
					imageRoofBack[j][i][0] = (byte) (cRoofBack.getRed());
					imageRoofBack[j][i][1] = (byte) (cRoofBack.getGreen());
					imageRoofBack[j][i][2] = (byte) (cRoofBack.getBlue());
					imageRoofBack[j][i][3] = (byte) (255);
					
					imageRoofLeft[j][i][0] = (byte) (cRoofLeft.getRed());
					imageRoofLeft[j][i][1] = (byte) (cRoofLeft.getGreen());
					imageRoofLeft[j][i][2] = (byte) (cRoofLeft.getBlue());
					imageRoofLeft[j][i][3] = (byte) (255);
					
					imageRoofRight[j][i][0] = (byte) (cRoofRight.getRed());
					imageRoofRight[j][i][1] = (byte) (cRoofRight.getGreen());
					imageRoofRight[j][i][2] = (byte) (cRoofRight.getBlue());
					imageRoofRight[j][i][3] = (byte) (255);
					
					imageDoor[j][i][0] = (byte) (cDoor.getRed());
					imageDoor[j][i][1] = (byte) (cDoor.getGreen());
					imageDoor[j][i][2] = (byte) (cDoor.getBlue());
					imageDoor[j][i][3] = (byte) (255);
				}
			}

		} catch (IOException e) {

			// TODO Auto-generated catch block
			System.out.println(123);
			e.printStackTrace();

		}

	}
	
	public void myInit(GL myGL) {
		myGL.glPixelStorei(GL.GL_UNPACK_ALIGNMENT, 1);

		myGL.glGenTextures(11, texName);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[0]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageCenter);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[1]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageRight);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[2]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageLeft);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[3]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageTop);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[4]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBottom);
		
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, this.imageWallout);
		
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[6]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, this.imageRoofAhead);
		
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[7]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, this.imageRoofBack);
		
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[8]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, this.imageRoofLeft);
		
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[9]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, this.imageRoofRight);
		
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[10]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, this.imageDoor);

		
		myGL.glEnable(GL.GL_TEXTURE_2D);
		
	}
	public void room2(GL myGL, GLUT myUT, int t, int y, int b) {
		
	}
	public void room(GL myGL, GLUT myUT, int t1, int t2, int b, Landscape landscape) {
		
		
		
		myGL.glEnable(GL.GL_TEXTURE_2D);
		
		myGL.glPushMatrix();
		myGL.glTranslated(0, 0, b);
		myGL.glScaled(2, 2, 4);

		// center
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[0]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-2.0f, -2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(2.0f, -2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-2.0f, 2.0f, -2.0f);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[1]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(2.0f, -2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(2.f, -2.0f, 2f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(2f, 2.0f, 2);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[2]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(-2.0f, -2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(-2.f, -2.0f, 2f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-2f, 2.0f, 2);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[3]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(2.f, 2.0f, -2f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-2f, 2.0f, -2);
		myGL.glEnd();

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[4]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-2.0f, -2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(2.0f, -2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(2.f, -2.0f, -2f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-2f, -2.0f, -2);
		myGL.glEnd();
		
		// door	right	
		myGL.glPushMatrix();
		myGL.glTranslated(2, 0, 2);
		myGL.glRotated(t2, 0, 1, 0);
		myGL.glTranslated(-2, 0, -2);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(2.0f, -2.0f, 4.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(2.0f, 2.0f, 4.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(2.f, 2.0f, 2f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(2f, -2f, 2);
		myGL.glEnd();
		myGL.glPopMatrix();
		
		// roof ahead
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[6]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.0f, 4.0f, 2.0f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(0.0f, 4.0f, 2.0f);
		myGL.glEnd();
		
		// roof back
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[7]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.0f, 4.0f, -2.0f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(0.0f, 4.0f, -2.0f);
		myGL.glEnd();
		
		// roof left
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[8]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.0f, 4.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.f, 4.0f, -2f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-2f, 2f, -2);
		myGL.glEnd();
		
		// roof right
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[9]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(0.0f, 4.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(0.f, 4.0f, -2f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(2f, 2f, -2);
		myGL.glEnd();
		
		
		// door left
		myGL.glPushMatrix();
		myGL.glTranslated(-2, 0, 2);
		myGL.glRotated(t1, 0, 1, 0);
		myGL.glTranslated(2, 0, -2);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[10]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-2.0f, -2.0f, 4.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(-2.0f, 2.0f, 4.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(-2.f, 2.0f, 2f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-2f, -2f, 2);
		myGL.glEnd();
		myGL.glPopMatrix();
		
		myGL.glPopMatrix();
		
		myGL.glPushMatrix();
		myGL.glTranslated(12, 0, -1.6);
		myGL.glScaled(2, 1, 0.8);
		landscape.room(myGL, myUT, t1,t2, b);
		myGL.glPopMatrix();
		myGL.glDisable(GL.GL_TEXTURE_2D);

	}

}
