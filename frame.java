package Swing;

import javax.swing.JFrame;

public class Frame {

    public static void main(String[] args) {
        JFrame f = new JFrame(); // Create a new JFrame object
        f.setSize(400, 400); // Set the size of the JFrame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the frame is closed
        f.setVisible(true); // Make the frame visible
    }
}
