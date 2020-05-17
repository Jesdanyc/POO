package eventax.igu;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    JMenuItem m11;
    JMenuItem m19;
    JMenuItem m22;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setTitle("Main Frame");
        setLocationRelativeTo(null);
        initMenu();
    }

    void initMenu() {
        // menu
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");

        m11 = new JMenuItem("New File");
        m11.addActionListener(this);
        m1.add(m11);
        m19 = new JMenuItem("Exit");
        m19.addActionListener(this);
        m1.add(m19);
        mb.add(m1);
        JMenu m2 = new JMenu("Asistencia");
        mb.add(m2);
        // setLayout(null); // null setBounds(x,y, w,h)
        add(BorderLayout.NORTH, mb);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == m11) {//Agregar estudiantes
            PersonDialog personDialog = new PersonDialog();
            personDialog.setVisible(true);
        }
        if (e.getSource() == m19) {
            System.out.println("By ");
            System.exit(0);
        }
    }
    
}
