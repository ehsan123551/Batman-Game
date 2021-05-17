package ProjectBatman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainScreen extends JFrame implements ActionListener
{	
	JButton startBtn = new JButton("Start");
	JButton quitBtn = new JButton("Quit");
	Image front = new ImageIcon("img/Bat.jpeg").getImage();
	
	MainScreen () {	
		this.setTitle("BATMAN: ARKHAM KNIGHT");
		this.setSize(Constants.FRAME_WIDTH,Constants.FRAME_HEIGHT);
		this.setLayout(null);
		
		startBtn.setBounds(300, 420, 90, 30);
		quitBtn.setBounds(400, 420, 90, 30);

		this.add(startBtn);
		this.add(quitBtn);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		startBtn.addActionListener(this);
		quitBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == startBtn)
		{
			new MainFrame();
		}
		else if(e.getSource() == quitBtn)
		{
			Runtime.getRuntime().exit(0);
		}
	}
	
	public void paint(Graphics g )
	{
		g.drawImage(front, 0, 0, Constants.FRAME_WIDTH,Constants.FRAME_HEIGHT, null);
	}
	
	public static void main(String[] args) {
		new MainScreen();
	}
}