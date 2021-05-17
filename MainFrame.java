package ProjectBatman;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class MainFrame extends JFrame
{	
	private BatmanModel model;
	private BatmanControls controller;
	private BatmanView view;
	
	public MainFrame() {
		super(Constants.GAME_NAME);
		model = new BatmanModel();
		view = new BatmanView(model);
		controller = new BatmanControls(model, view);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		add(view, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
	    setVisible(true);
	}
}
