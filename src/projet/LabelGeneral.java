/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

import classes.General;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author eddy
 */
public class LabelGeneral extends JLabel {
    General g;
    public LabelGeneral(General g, Icon icon) {
        super(icon);
        this.g = g;
    }

    public General getG() {
        return g;
    }
    
}
