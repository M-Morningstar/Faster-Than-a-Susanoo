import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame w = new JFrame();
         w.setSize(850,600);
    //if you want the title to change, alter the text in the quotes below
         w.setTitle("Title Change");
//         w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         w.setExtendedState(JFrame.MAXIMIZED_BOTH);
         GUI m = new GUI();
         w.add(m);
         w.addKeyListener(new KeyInput(m));
         w.setVisible(true);
         
        
        
    }

}


