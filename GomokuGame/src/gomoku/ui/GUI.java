package gomoku.ui;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gomoku.app.Field;
import gomoku.app.FieldSize;
import gomoku.app.MouseEventHandler;

public class GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private Container c;
	FieldSize size = new FieldSize();
	
	public GUI(String title) {
		setTitle(title);
		c = getContentPane();
		setBounds(200, 20, 620, 645);
		c.setLayout(null);
		Field map = new Field(size);
		DrawField df = new DrawField(size, map);
		setContentPane(df);
		addMouseListener(new MouseEventHandler(map, size, df, this));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void showPopUp(String message) {
		JOptionPane.showMessageDialog(this, message, " ", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
