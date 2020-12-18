package gomoku.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import gomoku.app.Field;
import gomoku.app.FieldSize;

public class DrawField extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private FieldSize fs;
	private Field field;
	private final int STONE_SIZE=28;

	public DrawField(FieldSize fs,Field field) {
		setBackground(new Color(220, 179, 92));
		setLayout(null);
		this.fs=fs;
		this.field=field;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		drawLine(g);
		drawStone(g);
	}

	public void drawLine(Graphics g) {
		for(int i = 1; i <= fs.getSIZE(); i++){
			// Row Line
			g.drawLine(fs.getCELL(), i*fs.getCELL(), fs.getCELL()*fs.getSIZE(), i*fs.getCELL());
			// Column Line
			g.drawLine(i*fs.getCELL(), fs.getCELL(), i*fs.getCELL() , fs.getCELL()*fs.getSIZE());
		}
	}
	
	public void drawStone(Graphics g) {
		for(int i = 0; i < fs.getSIZE(); i++){
			for(int j = 0; j < fs.getSIZE(); j++){
				if(field.getXY(i, j) == field.getBlack())
					drawBlackStone(g, i, j);
				else if(field.getXY(i, j) == field.getWhite())
					drawWhiteStone(g, i, j);
			}
		}
	}

	public void drawBlackStone(Graphics g, int x, int y){
		g.setColor(Color.BLACK);
		g.fillOval((y+1)*fs.getCELL()-15, (x)*fs.getCELL()+15, STONE_SIZE, STONE_SIZE);
	}

	public void drawWhiteStone(Graphics g, int x, int y){
		g.setColor(Color.WHITE);
		g.fillOval(y*fs.getCELL()+15, x*fs.getCELL()+15, STONE_SIZE, STONE_SIZE);
	}
}