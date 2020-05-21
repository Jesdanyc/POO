package eventax.igu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import eventax.data.PersonData;
import eventax.entities.Person;
import eventax.entities.PersonCi;
import eventax.igu.MainFrame;
import eventax.data.PersonAsistence;

public class PersonCicle extends JDialog {
     private static final long serialVersionUID = 11;
     JTextField cicleField = new JTextField(30);
   
    JButton addButton = new JButton("Añadir");
   
 //   JButton saveButton = new JButton("Eliminar");
    JTable jTable2;
    JScrollPane jSP;
    PersonAsistence personAsistence = new PersonAsistence();

    public PersonCicle() {
        setSize(100, 100);
        setTitle("Ciclos");
        setLocationRelativeTo(null);

        initForm();
        paintTable2();
    }

    private void paintTable2() {
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        List<Person> lis = personAsistence.list();
        while (modelo.getRowCount() > 0)
            modelo.removeRow(0);
        for (Person d : lis) {
            modelo.addRow(new Object[] { d.getId(),d.getCicle() });
        }
    }

    void initForm() {

        jTable2 = new JTable();
        jTable2.setModel(new DefaultTableModel(new Object[][] {
                // { 1, 2 },
                // { 3, 4 }
        }, new String[] { "ID", "DNI"}));
        jSP = new JScrollPane();
        jSP.setViewportView(jTable2);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Cicle:"));
        add(cicleField);
      
        // Manejo de eventos
        final JDialog outer = this;
       
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                addPerson(a);
            }
        });
    }

    void addPerson(ActionEvent event) {
        if (cicleField.getText().equals(""))
        JOptionPane.showMessageDialog(this, "Falta ingresar el DNI");
        else{
        JOptionPane.showMessageDialog(this, "Añadido correctamente");
        PersonCi d = new PersonCi();
        d.setCicle(cicleField.getText());
        paintTable2();
    }}

  
    }    
