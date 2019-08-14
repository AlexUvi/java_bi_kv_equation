import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reader extends JFrame {
    JButton but_sol, but_clean;
    JLabel label_a, label_b, label_c, label_d, label_res;
    JTextField text_a, text_b, text_c, text_d;
    double koef_a, koef_b, koef_c, koef_d, Dis, x1, x2, x3, x4, t1, t2;
    String n1, n2, n3, n4;
    eHandler handler = new eHandler();

    public Reader(String s) {
        super(s);
        setLayout(new FlowLayout());
        but_sol = new JButton("Calculate");
        but_clean = new JButton("Clear");
        label_a = new JLabel("Введите коэфицент при x^4 (a):");
        label_b = new JLabel("Введите коэфицент при x^2 (b)");
        label_c = new JLabel("Введите свободный член у-ния (с):");
        label_d = new JLabel("Результат у-ния (d):");
        label_res = new JLabel("");
        text_a = new JTextField(10);
        text_b = new JTextField(10);
        text_c = new JTextField(10);
        text_d = new JTextField(10);
        add(label_a);
        add(text_a);
        add(label_b);
        add(text_b);
        add(label_c);
        add(text_c);
        add(label_d);
        add(text_d);
        add(but_sol);
        add(but_clean);
        add(label_res);
        but_sol.addActionListener(handler);
        but_clean.addActionListener(handler);
    }

    public class eHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == but_sol) {
                koef_a = Double.parseDouble(text_a.getText());
                koef_b = Double.parseDouble(text_b.getText());
                koef_c = Double.parseDouble(text_c.getText());
                koef_d = Double.parseDouble(text_d.getText());
                if (koef_d != 0)
                    koef_c = koef_c - koef_d;
                Dis = koef_b * koef_b - 4 * koef_a * koef_c;
                if (Dis < 0)
                    label_res.setText("Уравнение не имеет корней ");

                else if (Dis == 0) {
                    t1 = (-koef_b) / (2 * koef_a);
                    if (t1 < 0)
                        label_res.setText("Уравнение не имеет корней ");
                    else if (t1 >= 0)
                        label_res.setText("Корни уравнения х1= х2= x3= x4= " + Math.sqrt(t1));

                } else if (Dis > 0) {
                    t1 = (-koef_b + Math.sqrt(Dis)) / (2 * koef_a);
                    t2 = (-koef_b - Math.sqrt(Dis)) / (2 * koef_a);
                    if (t1 == 0) {
                        label_res.setText("x1 = x2 = " + 0);
                    } else if (t1 > 0) {
                        x1 = Math.sqrt(t1);
                        x2 = -Math.sqrt(t1);
                        label_res.setText("Первый корень у-ния x1 = " + x1 + ";" + "Второй корень у-ния x2 = " + x2 );
                    }
                    if (t2 == 0) {
                        label_res.setText("x3 = x4 = " + 0);
                    } else if (t2 > 0) {
                        x3 = Math.sqrt(t2);
                        x4 = -Math.sqrt(t2);
                        label_res.setText("Третий корень у-ния x3 = " + x3 + ";" + "Четвёртый корень у-ния x4 = " + x4);
                    }
                }
            }
            if (e.getSource() == but_clean) {
                text_a.setText(null);
                text_b.setText(null);
                text_c.setText(null);
                text_d.setText(null);
                label_res.setText(null);
            }

        }
    }
}
