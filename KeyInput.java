import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    GUI g;
    
    public KeyInput(GUI game) {
        g=game;
        System.out.println("Created");
    }
    
    public void keyPressed(KeyEvent e) {
        System.out.println("T");
        g.keyPressed(e);
    }
    public void keyReleased(KeyEvent e) {
        g.keyReleased(e);
    }
}


