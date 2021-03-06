import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jgl.GL;
import jgl.GLCanvas;
import jgl.GLUT;

public class Lanscape {

	private static final int checkImageWidth = 256;
	private static final int checkImageHeight = 256;
	private byte imageBack[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageCenter[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageBottom[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageTop[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageRight[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private byte imageLeft[][][] = new byte[checkImageWidth][checkImageHeight][4];
	private int texName[] = new int[6];

	public void makeImage() {

		int i, j;
		float ti, tj;
		File bmpBackFile = new File("img/sky.bmp");
		File bmpCenterFile = new File("img/sky.bmp");
		File bmpTopFile = new File("img/sky.bmp");
		File bmpBottomFile = new File("img/ground.bmp");
		File bmpRightFile = new File("img/sky.bmp");
		File bmpLeftFile = new File("img/sky.bmp");

		try {
			BufferedImage iBack = ImageIO.read(bmpBackFile);
			BufferedImage iCenter = ImageIO.read(bmpCenterFile);
			BufferedImage iBottom = ImageIO.read(bmpBottomFile);
			BufferedImage iTop = ImageIO.read(bmpTopFile);
			BufferedImage iRight = ImageIO.read(bmpRightFile);
			BufferedImage iLeft = ImageIO.read(bmpLeftFile);

			for (i = 0; i < checkImageWidth; i++) {
				for (j = 0; j < checkImageHeight; j++) {
					Color cBack = new Color(iBack.getRGB(i, j));
					Color cCenter = new Color(iCenter.getRGB(i, j));
					Color cBottom = new Color(iBottom.getRGB(i, j));
					Color cTop = new Color(iTop.getRGB(i, j));
					Color cRight = new Color(iRight.getRGB(i, j));
					Color cLeft = new Color(iLeft.getRGB(i, j));

					imageBack[j][i][0] = (byte) (cBack.getRed());
					imageBack[j][i][1] = (byte) (cBack.getGreen());
					imageBack[j][i][2] = (byte) (cBack.getBlue());
					imageBack[j][i][3] = (byte) (255);

					imageCenter[j][i][0] = (byte) (cCenter.getRed());
					imageCenter[j][i][1] = (byte) (cCenter.getGreen());
					imageCenter[j][i][2] = (byte) (cCenter.getBlue());
					imageCenter[j][i][3] = (byte) (255);

					imageBottom[j][i][0] = (byte) (cBottom.getRed());
					imageBottom[j][i][1] = (byte) (cBottom.getGreen());
					imageBottom[j][i][2] = (byte) (cBottom.getBlue());
					imageBottom[j][i][3] = (byte) (255);

					imageTop[j][i][0] = (byte) (cTop.getRed());
					imageTop[j][i][1] = (byte) (cTop.getGreen());
					imageTop[j][i][2] = (byte) (cTop.getBlue());
					imageTop[j][i][3] = (byte) (255);

					imageRight[j][i][0] = (byte) (cRight.getRed());
					imageRight[j][i][1] = (byte) (cRight.getGreen());
					imageRight[j][i][2] = (byte) (cRight.getBlue());
					imageRight[j][i][3] = (byte) (255);

					imageLeft[j][i][0] = (byte) (cLeft.getRed());
					imageLeft[j][i][1] = (byte) (cLeft.getGreen());
					imageLeft[j][i][2] = (byte) (cLeft.getBlue());
					imageLeft[j][i][3] = (byte) (255);

				}
			}
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void myInit(GL myGL) {
		myGL.glPixelStorei(GL.GL_UNPACK_ALIGNMENT, 1);
		myGL.glGenTextures(6, texName);
		// ground
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[0]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBottom);
		// sky
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[1]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageTop);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[2]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageRight);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[3]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageLeft);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[4]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageCenter);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, checkImageWidth, checkImageHeight, 0, GL.GL_RGBA,
				GL.GL_UNSIGNED_BYTE, imageBack);

		myGL.glEnable(GL.GL_TEXTURE_2D);

	}

	public void room(GL myGL, GLUT myUT, int t, int t2, int b) {

		myGL.glEnable(GL.GL_TEXTURE_2D);

		myGL.glPushMatrix();
		myGL.glTranslated(-10, -0.5, b);
		myGL.glScaled(10, 2, 20);

		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[0]);
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

		// sky
		myGL.glPushMatrix();
		myGL.glTranslated(0, 10, 0);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[1]);
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
		myGL.glPopMatrix();

		// right
		myGL.glPushMatrix();
		myGL.glTranslated(0, 6, 0);
		myGL.glScaled(1, 4, 1);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[2]);
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
		myGL.glPopMatrix();

		// left
		myGL.glPushMatrix();
		myGL.glTranslated(0, 6, 0);
		myGL.glScaled(1, 4, 1);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[3]);
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
		myGL.glPopMatrix();

		// center
		myGL.glPushMatrix();
		myGL.glTranslated(0, 6, 0);
		myGL.glScaled(1, 4, 1);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[4]);
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
		myGL.glPopMatrix();

		// back
		myGL.glPushMatrix();
		myGL.glTranslated(0, 6, 0);
		myGL.glScaled(1, 4, 1);
		myGL.glBindTexture(GL.GL_TEXTURE_2D, texName[5]);
		myGL.glBegin(GL.GL_QUADS);
		myGL.glTexCoord2f(0.0f, 0.0f);
		myGL.glVertex3f(-2.0f, -2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 0.0f);
		myGL.glVertex3f(2.0f, -2.0f, 2.0f);
		myGL.glTexCoord2f(1.0f, 1.0f);
		myGL.glVertex3f(2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f(0.0f, 1.0f);
		myGL.glVertex3f(-2.0f, 2.0f, 2.0f);
		myGL.glEnd();
		myGL.glPopMatrix();

		myGL.glPopMatrix();
		myGL.glDisable(GL.GL_TEXTURE_2D);

	}

}
