/*
 * KeyboardListener.java
 *
 * Created on September 17, 2007, 11:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.jfugue.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import org.netbeans.modules.musician.gui.score.ScoreTopComponent;

/**
 *
 * @author mvaleri
 */
public class KeyboardListener  implements MouseListener, MouseMotionListener, KeyListener {

    
    /** Creates a new instance of KeyboardListener */
    public KeyboardListener() {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {        
        try {
            switch(e.getKeyCode()) {
                
                case KeyEvent.VK_1:
                    // when 64th notes get implemented
                    break;
                
                case KeyEvent.VK_2:
                    // when 32nd note get implemented
                    break;
                    
                case KeyEvent.VK_3:
//                    currentScoreTopComponent.doClickBtnCompositionSixteenthNote();
                    break;
                    
                case KeyEvent.VK_4:
//                    currentScoreTopComponent.doClickBtnCompositionEighthNote();
                    break;

                case KeyEvent.VK_5:
//                    currentScoreTopComponent.doClickBtnCompositionQuarterNote();
                    break;

                case KeyEvent.VK_6:
//                    currentScoreTopComponent.doClickBtnCompositionHalfNote();
                    break;

                case KeyEvent.VK_7:
//                    currentScoreTopComponent.doClickBtnCompositionWholeNote();
                    break;
            }
        } catch (Exception ex) {
        
        }
    }

    public void keyReleased(KeyEvent e) {
    }

}
