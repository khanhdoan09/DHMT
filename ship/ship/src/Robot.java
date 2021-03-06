import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import jgl.GL;
import jgl.GLCanvas;
import jgl.GLU;
import jgl.GLUT;
import jgl.glu.GLUquadricObj;

public class Robot extends GLCanvas {

	private static int elbow = 0, leftElbow, rightElbow, 
			rightKnee=-90, leftKnee=-90, rightAnkle=90, leftAnkle=90;
	private static int rotate = 0;
	private static int rightWrist = 30, leftWrist = -90;
	private static int t1 = 90;
	private static int t2 = -90;

	float ti, tj;

	double a = 0;

	double waist = 0;
	double leftShoulder = 0, rightFoot = 0, leftFoot = 0;
	double rightShoulder = 0;
	float candle = 0;
	float l = 1;
	
	Ship ship = new Ship();
	Lanscape room2 = new Lanscape();
	Guitar guitar = new Guitar();
	
	float position[] = { 1.0f, 1.0f, 1.0f, 0.0f };
	float mat_shininess[] = { 10.0f };

	int p = 0;
	int o = 0;
	int i = 0;

	private int startList;

	public void errorCallback(int errorCode) {
		String estring;

		estring = myGLU.gluErrorString(errorCode);
		System.err.println("Quadric Error: " + estring);
	}

	private void myinit() {
		GLUquadricObj qobj;

		startList = myGL.glGenLists(1);
		qobj = myGLU.gluNewQuadric();
		// body
		myGLU.gluQuadricCallback(qobj, myGLU.GLU_ERROR, "errorCallback");
		myGLU.gluQuadricDrawStyle(qobj, GLU.GLU_FILL); /* flat shaded */
		myGLU.gluQuadricNormals(qobj, GLU.GLU_SMOOTH);
		myGL.glNewList(startList + 1, GL.GL_COMPILE);
		myGLU.gluCylinder(qobj, 1, 1, 1.0, 15, 2);
		myGL.glEndList();

		myGLU.gluQuadricDrawStyle(qobj, GLU.GLU_FILL); /* flat shaded */
		myGLU.gluQuadricNormals(qobj, GLU.GLU_SMOOTH);
		myGL.glNewList(startList + 2, GL.GL_COMPILE);
		myGLU.gluCylinder(qobj, 1, 1, 1.0, 15, 2);
		myGL.glEndList();

		myGLU.gluQuadricDrawStyle(qobj, GLU.GLU_FILL); /* flat shaded */
		myGLU.gluQuadricNormals(qobj, GLU.GLU_SMOOTH);
		myGL.glNewList(startList + 3, GL.GL_COMPILE);
		myGLU.gluCylinder(qobj, 1, 1, 1.0, 15, 2);
		myGL.glEndList();

		// hat
		myGLU.gluQuadricDrawStyle(qobj, GLU.GLU_FILL); /* flat shaded */
		myGLU.gluQuadricNormals(qobj, GLU.GLU_SMOOTH);
		myGL.glNewList(startList + 4, GL.GL_COMPILE);
		myGLU.gluCylinder(qobj, 1.1, 0.6, 1.5, 15, 2);
		myGL.glEndList();

		// leg
		myGLU.gluQuadricDrawStyle(qobj, GLU.GLU_FILL); /* flat shaded */
		myGLU.gluQuadricNormals(qobj, GLU.GLU_SMOOTH);
		myGL.glNewList(startList + 5, GL.GL_COMPILE);
		myGLU.gluCylinder(qobj, 1.2, 0.6, 1, 4, 2);
		myGL.glEndList();

		myGL.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		myGL.glShadeModel(GL.GL_FLAT);
		myGL.glEnable(GL.GL_DEPTH_TEST);
		
	
		ship.myInit(myGL);

		room2.makeImage();
		room2.myInit(myGL);

		
	}
	
	public void display() {

		myGL.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		myGL.glPushMatrix();

		myGL.glTranslated(0, 0, v);
		myGL.glRotated(p, 0, 1, 0);
		myGL.glRotated(o, 1, 0, 0);
		myGL.glRotated(i, 0, 0, 1);

		myGL.glPushMatrix();
		myGL.glTranslated(0, -1, 0);
		ship.display(myGL,myUT, rotate, n, k);
		myGL.glPopMatrix();
		
		// robot
		myGL.glPushMatrix();
	
		
		myGL.glShadeModel(GL.GL_SMOOTH);
		myGL.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess);
		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glEnable(GL.GL_LIGHT0);

		myGL.glPushMatrix();
		myGL.glTranslated(0, -1, 0);
		myGL.glTranslated(0, 0, n); // robot move ahead back
		myGL.glTranslated(k, 0, 0); // robot move left right
		myGL.glRotated(a, 0, 1, 0);

		myGL.glTranslated(0, -3, 0);
		myGL.glScaled(0.2, 0.2, 0.2);

		myGL.glPushMatrix(); // push robot
		myGL.glRotated(rotate, 0, 1, 0);
		myGL.glScaled(4, 4, 4);
		robot();
		myGL.glDisable(GL.GL_LIGHTING);
		myGL.glDisable(GL.GL_LIGHT0);
		// guitar
		myGL.glPushMatrix();
		myGL.glTranslated(0, -0.5, 1.5);
		myGL.glScaled(1, 1, 0.9);
		guitar.display(myGL, myUT);
		myGL.glPopMatrix();
		myGL.glPopMatrix();
		myGL.glPopMatrix(); // pop robot

		myGL.glPopMatrix();
		myGL.glScaled(4, 2, 1);
		room2.room(myGL, myUT, t1, t2, b);
		myGL.glPopMatrix();

		myGL.glFlush();
	}

	public void robot() {
		myGL.glPushMatrix();
		// robot
		myGL.glTranslated(0, -2, 0);
		myGL.glRotated(waist, 1, 0, 0);
		myGL.glTranslated(0, 2, 0);

		// hat
		myGL.glPushMatrix();
		myGL.glPushMatrix();
		myGL.glTranslated(0, 3.8, 0);
		myGL.glRotatef(270.0f, 1.0f, 0.0f, 0.0f);
		myGL.glCallList(startList + 4);
		myGL.glPopMatrix();
		myGL.glPushMatrix();
		myGL.glScaled(2.5, 0.5, 2);
		myGL.glTranslated(0, 7.3, 0);
		myUT.glutSolidSphere(1, 10, 10);
		myGL.glPopMatrix();
		// head
		myGL.glPushMatrix(); // push body
		myGL.glTranslated(0, 3, 0);
		myGL.glScaled(1, 1.5, 1);
		myUT.glutSolidSphere(1, 6, 3);
		myGL.glPopMatrix(); // pop body
		myGL.glPopMatrix();

		// body
		myGL.glPushMatrix(); // push body
		myGL.glScaled(2, 4, 1.1);
		myGL.glTranslated(0, -0.5, 0);
		myGL.glRotatef(270.0f, 1.0f, 0.0f, 0.0f);
		myGL.glCallList(startList + 1);
		myGL.glPopMatrix(); // pop body

		// right hand
		myGL.glPushMatrix(); // push right shoulder
		// first ball right
		myGL.glTranslated(2.5, 1.5, 0);
		myGL.glTranslated(-0.5, 0, 0);
		myGL.glRotated(waist, 1, 0, 0);
		myGL.glTranslated(0.5, 0, 0);
		myGL.glPushMatrix(); // push first ball right
		myUT.glutSolidSphere(0.5, 10, 10);
		// right elbow
		myGL.glRotated(-70, 0, 0, 1);
		myGL.glTranslated(1, 0, 0);
		myGL.glTranslated(-1, 0, 0);
		myGL.glRotated(-80, 0, 1, 0);
		myGL.glRotated(-40, 0, 0, 1);
		myGL.glRotated(rightElbow, 0, 1, 0);
		myGL.glTranslated(1, 0, 0);
		myGL.glPushMatrix(); // push scale right elbow
		myGL.glScaled(2, 0.5, 0.5);
		myGL.glTranslated(-0.3, 0, 0);
		myGL.glRotatef(100.0f, 0.0f, 1.0f, 0.0f);
		myGL.glCallList(startList + 3);
		myGL.glPopMatrix(); // pop scale right elbow
		// right second ball
		myGL.glRotated(70, 0, 0, 1); // return elbow right
		myGL.glTranslated(0.5, -1.5, 0);
		myGL.glTranslated(-0.5, 0, 0);
		myGL.glRotated(waist, 1, 0, 0);
		myGL.glTranslated(0.5, 0, 0);
		myGL.glPushMatrix(); // push second ball right
		myUT.glutSolidSphere(0.5, 10, 10);
		// right wrist
		myGL.glRotated(rightWrist, 1, 0, 0);
		myGL.glPushMatrix(); // push right wrist
		myGL.glTranslated(0, -1.2, 0.5);
		myGL.glRotatef(250.0f, 1.0f, 0.0f, 0.0f);
		myGL.glScaled(0.5, 0.5, 1);
		myGL.glCallList(startList + 2);
		myGL.glPopMatrix(); // pop right wrist
		myGL.glPopMatrix(); // pop second ball right
		myGL.glPopMatrix(); // pop right elbow
		myGL.glPopMatrix(); // pop first ball right

		// left hand
		myGL.glPushMatrix(); // push left hand
		// first ball left
		myGL.glTranslated(-2.5, 1.5, 0);
		myGL.glTranslated(-0.5, 0, 0);
		myGL.glRotated(waist, 1, 0, 0);
		myGL.glTranslated(0.5, 0, 0);
		myGL.glPushMatrix(); // push first ball left
		myUT.glutSolidSphere(0.5, 10, 10);
		// left elbow
		myGL.glRotated(70, 0, 0, 1);
		myGL.glTranslated(-1, 0, 0);
		myGL.glTranslated(1, 0, 0);
		myGL.glRotated(50, 0, 1, 0);
		myGL.glRotated(-40, 0, 0, 1);
		myGL.glRotated(leftElbow, 0, 1, 0);
		myGL.glTranslated(-1, 0, 0);
		myGL.glPushMatrix(); // push scale left elbow
		myGL.glScaled(2, 0.5, 0.5);
		myGL.glTranslated(-0.7, 0, 0);
		myGL.glRotatef(100.0f, 0.0f, 1.0f, 0.0f);
		myGL.glCallList(startList + 3);
		myGL.glPopMatrix(); // pop scale left elbow
		myGL.glRotated(-70, 0, 0, 1); // return elbow left
		myGL.glTranslated(-0.5, -1.5, 0);
		myGL.glTranslated(0.5, 0, 0);
		myGL.glRotated(waist, 1, 0, 0);
		myGL.glTranslated(-0.5, 0, 0);
		myGL.glPushMatrix(); // push second ball left
		myUT.glutSolidSphere(0.5, 10, 10);
		// left wrist
		myGL.glRotated(-0, 1, 0, 0);
		myGL.glRotated(leftWrist, 1, 0, 0);
		myGL.glPushMatrix(); // push right wrist
		myGL.glTranslated(0, -1.2, 0.5);
		myGL.glRotatef(250.0f, 1.0f, 0.0f, 0.0f);
		myGL.glScaled(0.5, 0.5, 1);
		myGL.glCallList(startList + 2);
		myGL.glPopMatrix(); // pop left wrist
		myGL.glPopMatrix(); // pop second ball left
		myGL.glPopMatrix(); // pop first ball left
		myGL.glPopMatrix(); // pop left hand

		myGL.glPopMatrix(); // pop robot

		// right leg
		// knee
		myGL.glPushMatrix(); // push right knee
		myGL.glTranslated(-1, -3, 0);
		myGL.glTranslated(0, 1, 0);
		myGL.glRotated(rightKnee, 1, 0, 0);
		myGL.glTranslated(0, -1, 0);
		myGL.glPushMatrix(); // push scale right knee
		myGL.glScaled(0.8, 2, 1);
		myGL.glTranslated(0, 0.5, 0);
		myGL.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
		myGL.glCallList(startList + 5);
		myGL.glPopMatrix(); // pop scale right knee
		// first ball right knee
		myGL.glPushMatrix(); // push first ball right knee
		myGL.glTranslated(0, -1.5, 0);
		myGL.glTranslated(0, 0.5, 0);
		myGL.glRotated(elbow, 1, 0, 0);
		myGL.glTranslated(0, -0.5, 0);
		myUT.glutSolidSphere(0.5, 10, 10);
		// ankle
		myGL.glPushMatrix(); // push right ankle
		myGL.glTranslated(0, -0.5, 0);
//		myGL.glTranslated(0, 0., 0);
		myGL.glRotated(rightAnkle, 1, 0, 0);
		myGL.glTranslated(0, -0.5, 0);
		myGL.glPushMatrix(); // push scale right ankle
		myGL.glScaled(0.5, 1, 1);
		myGL.glRotatef(270.0f, 1.0f, 0.0f, 0.0f);
		myGL.glCallList(startList + 2);
		myGL.glPopMatrix(); // pop scale right ankle
		myGL.glPopMatrix(); // pop right ankle
		myGL.glPopMatrix(); // pop first ball right knee
		myGL.glPopMatrix(); // pop right knee

		// left leg
		// knee
		myGL.glPushMatrix(); // push left knee
		myGL.glTranslated(1, -3, 0);
		myGL.glTranslated(0, 1, 0);
		myGL.glRotated(leftKnee, 1, 0, 0);
		myGL.glTranslated(0, -1, 0);

		myGL.glPushMatrix(); // push scale left knee
		myGL.glScaled(0.8, 2, 1);
		myGL.glTranslated(0, 0.5, 0);
		myGL.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
		myGL.glCallList(startList + 5);
		myGL.glPopMatrix(); // pop scale left knee

		// first ball left knee
		myGL.glPushMatrix(); // push first ball left knee
		myGL.glTranslated(0, -1.5, 0);
		myGL.glTranslated(0, 0.5, 0);
		myGL.glRotated(elbow, 1, 0, 0);
		myGL.glTranslated(0, -0.5, 0);
		myUT.glutSolidSphere(0.5, 10, 10);
		// ankle
		myGL.glPushMatrix(); // push left ankle
		myGL.glTranslated(0, -0.5, 0);
//		myGL.glTranslated(0, 0., 0);
		myGL.glRotated(leftAnkle, 1, 0, 0);
		myGL.glTranslated(0, -0.5, 0);
		myGL.glPushMatrix(); // push scale left ankle
		myGL.glScaled(0.5, 1, 1);
		myGL.glRotatef(270.0f, 1.0f, 0.0f, 0.0f);
		myGL.glCallList(startList + 2);
		myGL.glPopMatrix(); // pop scale left ankle
		myGL.glPopMatrix(); // pop left ankle
		myGL.glPopMatrix(); // pop first ball right knee
		myGL.glPopMatrix(); // pop left knee

	}

	

	int b = 0;

	public void myReshape(int w, int h) {
		myGL.glViewport(0, 0, w, h);
		myGL.glMatrixMode(GL.GL_PROJECTION);
		myGL.glLoadIdentity();
		myGLU.gluPerspective(80, (double) w / (double) h, 1.0, 150.0);
		myGL.glMatrixMode(GL.GL_MODELVIEW);
		myGL.glLoadIdentity();
		myGLU.gluLookAt(0.0, 0.0, 30, 0.0, 0.0, 0, 0.0, 1.0, 0.0);
		myGL.glTranslatef(0.0f, 0.0f, 0f);

	}

	int n = -20;
	int m = 0;
	int k = 0;
	int y = 0;
	int v = 0;

	/* ARGSUSED1 */
	public void keyboard(char key, int x, int y) {
		switch (key) {
		case 'b':
			b--;
			myUT.glutPostRedisplay();
			break;
		case 'w':
			waist++;
			myUT.glutPostRedisplay();
			break;
		case 'z':
			leftElbow++;
			myUT.glutPostRedisplay();
			break;
		case 'x':
			rightElbow--;
			myUT.glutPostRedisplay();
			break;
		case 'c':
//			leftWrist--;
			rightElbow += 1;
			rightWrist += 5;
			myUT.glutPostRedisplay();
			break;
		case 'v':
			rightWrist -= 5;
			rightElbow -= 1;
			myUT.glutPostRedisplay();
			break;
		case 's':
			leftKnee--;
			myUT.glutPostRedisplay();
			break;
		case 'a':
			rightKnee--;
			myUT.glutPostRedisplay();
			break;
		case 'f':
			leftAnkle--;
			myUT.glutPostRedisplay();
			break;
		case 'd':
			rightAnkle--;
			myUT.glutPostRedisplay();
			break;
		case 'r':
			rotate++;
			myUT.glutPostRedisplay();
			break;
		// move camera
		case 'p':
			p += 5;
			myUT.glutPostRedisplay();
			break;
		case 'o':
			o += 5;
			myUT.glutPostRedisplay();
			break;
		case 'i':
			i += 5;
			myUT.glutPostRedisplay();
			break;
		// robot move ahead, back
		case 'n':
			n+= 3;
			myUT.glutPostRedisplay();
			break;
		case 'm':
			n--;
			myUT.glutPostRedisplay();
			break;
		// robot move left right
		case 'k':
			k++;
			myUT.glutPostRedisplay();
			break;
		case 'l':
			k--;
			myUT.glutPostRedisplay();
			break;
		// curtain
		case 't':
			t1 += 5;
			t2 -= 5;
			v++;
			myUT.glutPostRedisplay();
			break;

		case 27:
			System.exit(0);
		default:
			break;
		}
	}



	public void init() {
		myUT.glutInitWindowSize(500, 500);
		myUT.glutInitWindowPosition(0, 0);
		myUT.glutCreateWindow(this);
		myinit();
		myUT.glutReshapeFunc("myReshape");
		myUT.glutDisplayFunc("display");
		myUT.glutKeyboardFunc("keyboard");
		myUT.glutMainLoop();
	}

	static public void main(String args[]) throws IOException {
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(508, 527);
		Robot mainCanvas = new Robot();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
