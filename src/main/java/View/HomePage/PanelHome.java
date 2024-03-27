/*
 * Author: Dương Thành Trưởng
 */

package View.HomePage;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class PanelHome extends JPanel {

    public PanelHome(int width, int height) {
        init(width, height);
    }

    public void init(int width, int height) {
        setLayout(new BorderLayout());
        add(new ImageSliderPanel(new String[]{"/View/images/slide1.png", "/View/images/slide2.png","/View/images/slide3.png"}, width, height),BorderLayout.CENTER);
    }
}
