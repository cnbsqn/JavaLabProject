package DecorateView;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HeadsTailsDecorator extends ViewDecorator {

	public HeadsTailsDecorator(InterfaceView decoratedView) {
		super(decoratedView);
		// TODO Auto-generated constructor stub
	}

	public JLabel setTheGameBackground(int WIDTH, int HEIGHT) {
		Image icon = new ImageIcon(getClass().getResource("/HaT.jpg")).getImage();

		ImageIcon bg = new ImageIcon(icon);
		JLabel background = new JLabel(bg);
		background.setOpaque(true);
		background.setBounds(0, 0, WIDTH, HEIGHT);
		return background;
	}

}
