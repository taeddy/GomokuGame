package gomoku.app;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gomoku.ui.DrawField;
import gomoku.ui.GUI;

public class MouseEventHandler extends MouseAdapter{
	private Field field;
	private FieldSize fs;
	private DrawField df;
	private GUI gui;
	
	public MouseEventHandler(Field f, FieldSize fs, DrawField df, GUI gui) {
		field = f;
		this.fs = fs;
		this.df = df;
		this.gui = gui;
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		super.mousePressed(arg0);
		
		int x = (int)Math.round(arg0.getX() / (double)fs.getCELL()) - 1;
		int y = (int)Math.round(arg0.getY() / (double)fs.getCELL()) - 2;
		
		// out of range
		if(x < 0 || x > 19 || y < 0 || y > 19) {
			return;
		}
		// already exist
		if(field.getXY(y, x) == field.getBlack() || field.getXY(y, x) == field.getWhite()) {
			return;
		}
		
		field.setField(y, x);
		
		// Command Line out
		if(field.getCheck() == true) {
			System.out.println("Black : " + x + " " + y);
		} else {
			System.out.println("white : " + x + " " + y);
		}
//		// Command Line out of map
//		for(int i = 0; i < fs.getSIZE(); i++) {
//			for(int j = 0; j < fs.getSIZE(); j++) {
//				System.out.print(field.getXY(i, j) + " ");
//			}
//			System.out.println("");
//		}
		
		field.changeCheck();
		df.repaint();
		if(field.checkWin(x, y))
			if(field.getCheck() == true) {
				System.out.println("White win!");
				gui.showPopUp("White win!");
			} else {
				System.out.println("Black win!");
				gui.showPopUp("Black win!");
			}
		if(field.checkFull(fs) == true) {
			System.out.println("Draw");
			gui.showPopUp("Draw");
		}
		
	}
}
