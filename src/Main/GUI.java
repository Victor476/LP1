package Main;

import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**

 *

 * @author radames

 */

class GUI extends JFrame{

    Container cp;

    JPanel pnA = new JPanel();

    JPanel pnB = new JPanel();

    JPanel pnC = new JPanel();

    JPanel pnD = new JPanel();

    JPanel pnE = new JPanel();

    JLabel lbA = new JLabel("Media de uma dixciplina");
    JLabel lbB = new JLabel("notas");
    JTextField tfNota1 = new JTextField(5);
    JTextField tfNota2 = new JTextField(5);
    JTextField tfNota3 = new JTextField(5);
    JTextField tfNota4 = new JTextField(5);
    JButton btCalcular = new JButton("Calcular");

   

    public GUI() {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cp = getContentPane();

        cp.setLayout(new GridLayout(7,5));
        

        cp.add(pnA, BorderLayout.NORTH);

        cp.add(pnB,BorderLayout.SOUTH);

        cp.add(pnC,BorderLayout.WEST);

        cp.add(pnD,BorderLayout.EAST);

        cp.add(pnE,BorderLayout.CENTER);

     
        pnA.setBackground(Color.red);

        pnB.setBackground(Color.BLUE);

        pnC.setBackground(Color.yellow);

        pnD.setBackground(Color.CYAN);

       

       

        pnA.add(lbA);
        pnB.add(lbB);
        pnB.add(tfNota1);
        pnB.add(tfNota2);
        pnB.add(tfNota3);
        pnB.add(tfNota4);
        pnC.add(btCalcular);
        
        setSize(600,300);

        setLocationRelativeTo(null);//centraliza

        setVisible(true);

       

    }    

}
