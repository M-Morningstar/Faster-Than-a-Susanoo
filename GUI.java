import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class GUI extends JPanel implements ActionListener {

	// Create variables
	Timer t;

	int x = 600;
	int y = 175;

	int p1X = 100;
	int p1Y = 250;

	int p2X = 100;
	int p2Y = 100;

	boolean moveRightN;
	boolean moveLeftN;
	boolean moveUpN;
	boolean moveDownN;

	boolean moveRightS;
	boolean moveLeftS;
	boolean moveUpS;
	boolean moveDownS;

	boolean moveLeftM = true;;
	boolean moveRightM;
	boolean moveUpM = true;
	boolean moveDownM;

	boolean lookLeftS;
	boolean lookRightS = true;

	boolean lookLeftN;
	boolean lookRightN = true;

	boolean lookLeftM = true;
	boolean lookRightM;

	boolean win = false;
	boolean lose = false;
	Font f1 = new Font("Times New Roman", 1, 36);
	Font f2 = new Font("Times New Roman", 1, 17);

	BufferedImage imgN, imgN1, imgN2, imgS, imgS1, imgS2, imgM, imgM1, imgM2;

	// end of variables//
	public GUI() {

		initComponents();
		t = new Timer(30, this);
		t.start();
		try {
			imgN1 = ImageIO.read(new File("src/narutoLR.png"));
		} catch (IOException e) {
		}
		;
		try {
			imgN2 = ImageIO.read(new File("src/narutoRL.png"));
		} catch (IOException e) {
		}
		;
		try {
			imgS1 = ImageIO.read(new File("src/sasukeLR.png"));
		} catch (IOException e) {
		}
		;
		try {
			imgS2 = ImageIO.read(new File("src/sasukeRL.png"));
		} catch (IOException e) {
		}
		;
		try {
			imgM1 = ImageIO.read(new File("src/madaraLR.png"));
		} catch (IOException e) {
		}
		;
		try {
			imgM2 = ImageIO.read(new File("src/madaraRL.png"));
		} catch (IOException e) {
		}
		;

	}
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// all your drawing will go in here)
		//madaraMovementLeft();
		//madaraMovementUp();

		g.drawImage(imgM, x, y, 125, 150, this);
		g.drawImage(imgN, p1X, p1Y, 125, 75, this);
		g.drawImage(imgS, p2X, p2Y, 125, 75, this);

		movement(g);
		if (win == true) {
			g.setColor(Color.white);
			g.fillRect(0, 0, 850, 600);
			g.setColor(Color.black);
			g.setFont(f1);
			g.drawString("Congrats!!", 325, 250);
			g.setFont(f2);
			g.drawString("You rescued useless Sakura once again.", 275, 275);
		}
		if (lose == true) {
			g.setColor(Color.white);
			g.fillRect(0, 0, 850, 600);
			g.setColor(Color.black);
			g.setFont(f1);
			g.drawString("Congrats!!", 325, 250);
			g.setFont(f2);
			g.drawString("You died while trying to save useless Sakura.", 275, 275);
		}

		// end of your drawing
	}

	public void movement(Graphics g) {
		if (lookLeftN == true) {
			imgN = imgN2;
		}
		if (lookRightN == true) {
			imgN = imgN1;
		}
		if (lookLeftS == true) {
			imgS = imgS2;
		}
		if (lookRightS == true) {
			imgS = imgS1;
		}
		if (lookLeftM == true) {
			imgM = imgM2;
		}
		if (lookRightM == true) {
			imgM = imgM1;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();

//		if(carX1<=bulletX2.get(i)+30 && bulletX2.get(i)<=carX1+200 && carY1<=bulletY2.get(i)+20 && bulletY2.get(i)<=carY2+100)
		if (p1X <= x + 25 && x <= p1X + 25 && p1Y <= y + 80 && y <= p1Y + 80 && p2X <= x + 25 && x <= p2X + 25 && p2Y <= y + 80 && y <= p2Y + 80) {
			win = true;
			lose = false;
		}
		else if(p1X <= x + 25 && x <= p1X + 25 && p1Y <= y + 80 && y <= p1Y + 80) {
			lose = true;
		}
		else if(p2X <= x + 25 && x <= p2X + 25 && p2Y <= y + 80 && y <= p2Y + 80) {
			lose = true;
		}

		if (moveLeftN == true) {
			lookLeftN = true;
			lookRightN = false;
			p1X = p1X - 5;
		}
		if (moveRightN == true) {
			lookRightN = true;
			lookLeftN = false;
			p1X = p1X + 5;
		}
		if (moveUpN == true) {
			p1Y = p1Y - 5;
		}
		if (moveDownN == true) {
			p1Y = p1Y + 5;
		}

		if (moveLeftS == true) {
			lookLeftS = true;
			lookRightS = false;
			p2X = p2X - 5;
		}
		if (moveRightS == true) {
			lookRightS = true;
			lookLeftS = false;
			p2X = p2X + 5;
		}
		if (moveUpS == true) {
			p2Y = p2Y - 5;
		}
		if (moveDownS == true) {
			p2Y = p2Y + 5;
		}
		if (moveLeftM == true) {

			x = x - 5;

			if (x <= 0) {
				//System.out.print("a");
				moveLeftM = false;
				lookLeftM = false;
				lookRightM = true;
				madaraMovementRight();
			}

		}
		if (moveRightM == true) {
			x = x + 5;

			if (x >= 725) {
				moveRightM = false;
				lookRightM = false;
				lookLeftM = true;
				madaraMovementLeft();
			}
		}
		if (moveUpM == true) {
			y = y - 5;

			if (y <= 0) {
				moveUpM = false;
				madaraMovementDown();
			}
		}
		if (moveDownM == true) {
			y = y + 5;

			if (y >= 425) {
				moveDownM = false;
				madaraMovementUp();
			}
		}

	}
	public void madaraMovementLeft() {
		moveLeftM = true;
	}

	public void madaraMovementRight() {
		moveRightM = true;
	}

	public void madaraMovementUp() {
		moveUpM = true;
	}

	public void madaraMovementDown() {
		moveDownM = true;
	}
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed=" + KeyEvent.getKeyText(e.getKeyCode()));
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_A) {
			moveLeftN = true;
		}
		if (key == KeyEvent.VK_W) {
			moveUpN = true;
		}
		if (key == KeyEvent.VK_D) {
			moveRightN = true;
		}
		if (key == KeyEvent.VK_S) {
			moveDownN = true;
		}
		if (key == KeyEvent.VK_LEFT) {
			moveLeftS = true;
		}
		if (key == KeyEvent.VK_UP) {
			moveUpS = true;
		}
		if (key == KeyEvent.VK_RIGHT) {
			moveRightS = true;
		}
		if (key == KeyEvent.VK_DOWN) {
			moveDownS = true;
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_A) {
			moveLeftN = false;
		}
		if (key == KeyEvent.VK_D) {
			moveRightN = false;
		}
		if (key == KeyEvent.VK_W) {
			moveUpN = false;
		}
		if (key == KeyEvent.VK_S) {
			moveDownN = false;
		}
		if (key == KeyEvent.VK_LEFT) {
			moveLeftS = false;
		}
		if (key == KeyEvent.VK_UP) {
			moveUpS = false;
		}
		if (key == KeyEvent.VK_RIGHT) {
			moveRightS = false;
		}
		if (key == KeyEvent.VK_DOWN) {
			moveDownS = false;
		}
	}

	private void formMouseClicked(java.awt.event.MouseEvent evt, Graphics g) {// GEN-FIRST:event_formMouseClicked
//        mousex=evt.getX();
//        mousey=evt.getY();
//        System.out.println(mousex+","+mousey);

	}
	// GEN-LAST:event_formMouseClicked

	private void initComponents() {
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);

		this.setLayout(layout);
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				Graphics g = null;
				formMouseClicked(evt, g);
			}
		});
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));

	}
}
