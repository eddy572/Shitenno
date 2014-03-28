/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.TransferHandler;

/**
 *
 * @author eddy
 */
class DragMouseAdapter extends MouseAdapter {
  public void mousePressed(MouseEvent e) {
    JComponent c = (JComponent) e.getSource();
    TransferHandler handler = c.getTransferHandler();
    handler.exportAsDrag(c, e, TransferHandler.COPY);
  }
}