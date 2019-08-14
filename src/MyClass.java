
import javax.swing.*;

public class MyClass{
    public static void main(String[] args) {
        Reader r = new Reader("The solution of the biquadratic equation");
        r.setVisible(true);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(220,400);
        r.setResizable(false);
        r.setLocationRelativeTo(null);

    }
}
