/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

import classes.Province;
import javax.swing.JPanel;

/**
 *
 * @author eddy
 */
public class PanelProvince extends JPanel {
    Province p = new Province();

    public PanelProvince() {
    }

    @Override
    public String toString() {
        return "PanelProvince{" + "p=" + p + '}';
    }
 
}
