/*
 *  bezsurf.java			
 *  This program uses evaluators to draw a Bezier surface.
 */

import java.awt.Color;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.String;
import java.lang.System;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import jgl.GL;
import jgl.GLCanvas;
import jgl.GLUT;

public class Guitar {
	
	public void display(GL myGL, GLUT myUT) {
		myGL.glPushMatrix();
		myGL.glColor3d(1, 1, 0);

		myGL.glRotated(50, 0, 0, 1);

		// rectangle
		myGL.glPushMatrix();
		myGL.glTranslated(0, 4, 0);
		myGL.glScaled(0.9, 5, 0.5);
		myGL.glColor3d(1, 1, 0);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		// rectangle sub left
		myGL.glPushMatrix();
		myGL.glRotated(90, 0, 0, 1);
		myGL.glTranslated(6.2, 0.7, 0);
		myGL.glScaled(0.2, 0.5, 0.5);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();
		// rectangle sub left
		myGL.glPushMatrix();
		myGL.glRotated(90, 0, 0, 1);
		myGL.glTranslated(5.7, 0.7, 0);
		myGL.glScaled(0.2, 0.5, 0.5);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();
		// rectangle sub right
		myGL.glPushMatrix();
		myGL.glRotated(-90, 0, 0, 1);
		myGL.glTranslated(-6.2, 0.7, 0);
		myGL.glScaled(0.2, 0.5, 0.5);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();
		// rectangle sub right
		myGL.glPushMatrix();
		myGL.glRotated(-90, 0, 0, 1);
		myGL.glTranslated(-5.7, 0.7, 0);
		myGL.glScaled(0.2, 0.5, 0.5);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		// first cir
		myGL.glPushMatrix();
		myGL.glScaled(1, 1, 0.5);
		myGL.glTranslated(0, 2.5, 0);
		myGL.glColor3d(1, 1, 0);
		myUT.glutSolidSphere(1.2, 20, 10);
		myGL.glPopMatrix();
		// second cir
		myGL.glPushMatrix();
		myGL.glScaled(2, 1.8, 0.5);
		myUT.glutSolidSphere(1, 20, 10);
		myGL.glPopMatrix();

		// cir
		myGL.glPushMatrix();
		myGL.glScaled(2, 1.8, 0.5);
		myGL.glColor3d(0, 0, 0);
		myGL.glTranslated(0, 1.4, 1);
		myUT.glutSolidSphere(0.3, 20, 10);
		myGL.glPopMatrix();

		// string 1
		myGL.glPushMatrix();
		myGL.glTranslated(-0.3, 3, 0.5);
		myGL.glScaled(0.05, 6.5, 0.5);
		myGL.glColor3d(0, 0, 0);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		// string 2
		myGL.glPushMatrix();
		myGL.glTranslated(-0., 3, 0.5);
		myGL.glScaled(0.05, 6.5, 0.5);
		myGL.glColor3d(0, 0, 0);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		// string 3
		myGL.glPushMatrix();
		myGL.glTranslated(0.3, 3, 0.5);
		myGL.glScaled(0.05, 6.5, 0.5);
		myGL.glColor3d(0, 0, 0);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		// tape
		myGL.glPushMatrix();
		myGL.glScaled(2, 0.5, 0.5);
		myGL.glTranslated(0, 0, 0.5);
		myGL.glColor3d(0, 0, 0);
		myUT.glutSolidCube(1);
		myGL.glPopMatrix();

		myGL.glPopMatrix();
	}
}