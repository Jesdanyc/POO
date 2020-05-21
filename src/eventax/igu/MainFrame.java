package eventax.igu;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    JMenuItem m11;
    JMenuItem m19;
    JMenuItem m21;
    JMenuItem m29;
    

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setTitle("Registro de Asistencia ");
        setLocationRelativeTo(null);
        initMenu();
    }

    void initMenu() {
        // menu
        JMenuBar mb = new JMenuBar();
      
        JMenu m1 = new JMenu("Archivo");
        JMenu m2 = new JMenu("Asistencia");
        m11 = new JMenuItem("Nueva Clase");
        m11.addActionListener(this);
        m1.add(m11);
        m19 = new JMenuItem("Salir");
        m19.addActionListener(this);
        m1.add(m19);
        m21 = new JMenuItem("Ciclo Academico");
        m21.addActionListener(this);
        m2.add(m21);
        m29 = new JMenuItem("0bservaciones");
        m29.addActionListener(this);
        m2.add(m29);
        mb.add(m1);
        mb.add(m2);
        // setLayout(null); // null setBounds(x,y, w,h)
        add(BorderLayout.NORTH, mb);
       
    }
    @Override 
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == m11) {
            System.out.println("Menu 1.1 has press ");
            PersonDialog personDialog = new PersonDialog();
            personDialog.setVisible(true);
        }
        if (e.getSource() == m19) {
            System.out.println("By ");
            System.exit(0);
        }
    }
    public void actionPerformed1(ActionEvent a) {
       if (a.getSource() == m21) {
            System.out.println("Menu 2.1 has press ");
            PersonCicle personCicle = new PersonCicle();
            personCicle.setVisible(true);
        }
        if (a.getSource() == m29) {
            System.out.println("By ");
            System.exit(0);
        }
    }
 }

