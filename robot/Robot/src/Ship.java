import jgl.GL;
import jgl.GLUT;

public class Ship {

	private static final float ctrlpoints[][][] = {
			{ { -1f, 0f, 2f }, { -1f, 0f, 2.0f }, { 1f, 2f, 1.0f }, { 2f, 0f, 2f } },

			{ { -1f, 0f, 2f }, { -1f, 0f, 2f }, { 1f, 2f, -2.0f }, { 2f, 0f, 2f } },

			{ { -1f, 0f, 2f }, { -1f, 0f, 2.0f }, { 1f, -2f, -2 }, { 2f, 0f, 2f } },

			{ { -1f, 0f, 2.0f }, { -1f, 0f, 2.0f }, { 1f, -2f, 1f }, { 2f, 0f, 2f } },

	};
	
	public void myInit(GL myGL) {
		myGL.glShadeModel(GL.GL_FLAT);
		myGL.glEnable(GL.GL_DEPTH_TEST);
		myGL.glMap2f(GL.GL_MAP2_VERTEX_3, 0.0f, 1.0f, 3, 4, 0.0f, 1.0f, 12, 4, ctrlpoints);
		myGL.glEnable(GL.GL_MAP2_VERTEX_3);
		myGL.glEnable(GL.GL_AUTO_NORMAL);
		myGL.glEnable(GL.GL_NORMALIZE);
		myGL.glMapGrid2f(20, 0.0f, 1.0f, 20, 0.0f, 1f);
	}
	
	public void display(GL myGL,GLUT myUT, int rotate, int n, int k) {

		float position[] = { 0.0f, 0.0f, 1.0f, 0.0f };
		float mat_specular[] = { 1.0f, 1.0f, 1.0f, 1.0f };
		float mat_shininess[] = { 10.0f };

		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glEnable(GL.GL_LIGHT0);

		myGL.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess);

		myGL.glPushMatrix();
		
		
		myGL.glTranslated(k, 0, 0); // ship move left right
		myGL.glTranslated(0, 0, n); // ship move ahead back
		
		myGL.glPushMatrix();
		myGL.glTranslated(3.7, -6, 2);
		myGL.glRotated(90 + rotate, 0, 1, 0);
		myGL.glScaled(1, 1, 1);
		myUT.glutSolidTorus(0.8, 1.2, 10, 10);
		myGL.glPopMatrix();
	
		myGL.glPushMatrix();
		myGL.glTranslated(-3.7, -6, 2);
		myGL.glRotated(90 + rotate, 0, 1, 0);
		myGL.glScaled(1, 1, 1);
		myUT.glutSolidTorus(0.8, 1.2, 10, 10);
		myGL.glPopMatrix();
		
		myGL.glTranslated(0, -9, 0);
		myGL.glScaled(4, 3.5, 3.5);
		myGL.glRotated(-90, 0, 1, 0);
		myGL.glRotated(-90, 1, 0, 0);
		myGL.glRotated(rotate, 0, 0, 1);
		myGL.glEvalMesh2(GL.GL_FILL, 0, 20, 0, 20);
		
		
		myGL.glPopMatrix();	
		
		myGL.glDisable(GL.GL_LIGHTING);
		myGL.glDisable(GL.GL_LIGHT0);
		
		

		myGL.glShadeModel(GL.GL_SMOOTH);
		myGL.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, mat_specular);
		myGL.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, mat_shininess);
		myGL.glEnable(GL.GL_LIGHTING);
		myGL.glEnable(GL.GL_LIGHT0);
	}
}
