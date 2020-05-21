package eventax.igu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import eventax.data.PersonData;
import eventax.entities.Person;

public class PersonDialog extends JDialog {
     private static final long serialVersionUID = 1L;
    JTextField dniField = new JTextField(30);
    JTextField nameField = new JTextField(30);
    JTextField cicleField = new JTextField(30);
    JTextField sexField = new JTextField(30);
    JButton goButton = new JButton("Salir");
    JButton addButton = new JButton("Añadir");
    JButton delButton = new JButton("Eliminar");
 //   JButton saveButton = new JButton("Eliminar");
    JTable jTable;
    JScrollPane jSP;
    PersonData personData = new PersonData();

    public PersonDialog() {
        setSize(600, 400);
        setTitle("Nueva Clase");
        setLocationRelativeTo(null);

        initForm();
        paintTable();
    }

    private void paintTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        List<Person> lis = personData.list();
        while (modelo.getRowCount() > 0)
            modelo.removeRow(0);
        for (Person d : lis) {
            modelo.addRow(new Object[] { d.getId(),d.getDni(), d.getName(), d.getCicle(),d.getSex() });
        }
    }

    void initForm() {

        jTable = new JTable();
        jTable.setModel(new DefaultTableModel(new Object[][] {
                // { 1, 2 },
                // { 3, 4 }
        }, new String[] { "ID", "DNI", "Nombres y Apellidos","Ciclo Academico","Sexo" }));
        jSP = new JScrollPane();
        jSP.setViewportView(jTable);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("DNI:"));
        add(dniField);
        add(new JLabel("Nombres y Apellidos:"));
        add(nameField);
        add(new JLabel("Ciclo Academico:"));
        add(cicleField);
        add(new JLabel("Sexo:"));
        add(sexField);
        add(addButton);
        add(delButton);
       // add(saveButton);
        add(jSP);
        add(goButton);

        // Manejo de eventos
        final JDialog outer = this;
        goButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println(" goButton has press ");
                outer.setVisible(false);
            }
        });
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPerson(e);
            }
        });
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delPerson(e);
            }
        }); 
    }

    void addPerson(ActionEvent event) {
        if (dniField.getText().equals(""))
        JOptionPane.showMessageDialog(this, "Falta ingresar el DNI");
        else if (this.nameField.getText().equals(""))
         JOptionPane.showMessageDialog(this, "Falta ingresar los Nombres y apellidos");
        else if (this.cicleField.getText().equals(""))
         JOptionPane.showMessageDialog(this, "Falta ingresar el Ciclo Academico");
        else if (this.sexField.getText().equals(""))
         JOptionPane.showMessageDialog(this, "Falta ingresar el Sexo");
        
       
        else{
        JOptionPane.showMessageDialog(this, "Añadido correctamente");
        Person d = new Person();
        d.setDni(dniField.getText());
        d.setName(nameField.getText());
        d.setCicle(cicleField.getText());
        d.setSex(sexField.getText());
        personData.create(d);
        paintTable();
    }}

    void delPerson(ActionEvent e) {
        if (jTable.getSelectedRow() != -1) {
            System.out.println(" delButton has press ");
            int[] row = jTable.getSelectedRows();
            String ids = jTable.getValueAt(row[0], 0).toString();
            System.out.println("selected: " + ids);
            int id = Integer.parseInt(ids);
            personData.delete(id);
            paintTable();
        }
    }    
}
