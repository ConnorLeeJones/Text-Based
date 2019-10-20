package com.connor.demo.utilities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("bleh");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
    }
}