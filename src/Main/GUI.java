package Main;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author radames
 */
class GUI extends JFrame {
    Container cp;
    JLabel lbValorA = new JLabel("Valor A");
    JLabel lbValorB = new JLabel("Valor B");
    JLabel lbValorC = new JLabel("Resposta");
    JLabel lbNada= new JLabel("");
    JTextField tfValorA = new JTextField(10);
    JTextField tfValorB = new JTextField(10);
    JTextField tfValorC = new JTextField(10);
    JButton btCalcular = new JButton("Calcule");
    public GUI() {
        cp = getContentPane();
        cp.setLayout(new GridLayout(4,2));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        cp.add(lbValorA);
        cp.add(tfValorA);
        cp.add(lbValorB);
        cp.add(tfValorB);
        cp.add(lbNada);
        cp.add(btCalcular);
        cp.add(lbValorC);
        cp.add(tfValorC);
        
        setSize(300,300);
        setVisible(true);
        
        btCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a = Double.valueOf(tfValorA.getText());
                double b = Double.valueOf(tfValorB.getText());
                double resposta = a+b;
                tfValorC.setText(String.valueOf(resposta));
            }
        });
        
    }   
    
    
}
