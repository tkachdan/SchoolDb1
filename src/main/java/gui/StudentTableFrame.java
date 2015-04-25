package gui;

import persistence.DAO.Impl.StudentDAOImpl;
import persistence.model.Student;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

/**
 * Created by dan on 25.4.15.
 */
public class StudentTableFrame extends JFrame {

    public static void main(String[] args) {
        StudentTableFrame studentTableFrame = new StudentTableFrame();
        studentTableFrame.repaint();
    }

    public StudentTableFrame() throws HeadlessException {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel buttonPannel = new JPanel();
        buttonPannel.setLayout(new FlowLayout());

        final JTable table = new JTable(new StudentTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 400));
        table.setFillsViewportHeight(true);
        setBounds(500, 300, 200, 200);
        StudentTableModel a = (StudentTableModel) table.getModel();
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        Collection<Student> allObjects = studentDAO.getAllObjects(Student.class);
        Object[] values = new Object[a.columnNames.length];
        for (Student allObject : allObjects) {
            values[0] = allObject.getId();
            values[1] = allObject.getEmail();
            values[2] = allObject.getFirstName();
            values[3] = allObject.getLastName();
            values[4] = allObject.getMarkAverage();
            a.insertData(values);
        }


        JButton addButton = new JButton("Add");

        addButton.addActionListener(actionEvent -> {
            JFrame addJFrame = new JFrame("Add student");

            addJFrame.setSize(200, 200);
            addJFrame.setLocationRelativeTo(this);
            addJFrame.setLayout(new FlowLayout());

            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new GridLayout(6, 1));
            JLabel emailLabel = new JLabel("Email:");
            JLabel firstNameLabel = new JLabel("First name:");
            JLabel lastNameLabel = new JLabel("Last name:");

            JTextField emailField = new JFormattedTextField();
            emailField.setColumns(15);
            JTextField firstNameField = new JFormattedTextField();
            firstNameField.setColumns(15);
            JTextField lastNameField = new JFormattedTextField();
            lastNameField.setColumns(15);

            JButton addButtonInner = new JButton("Add");
            addButtonInner.addActionListener(actionEvent1 -> {
                Student student = new Student();
                student.setEmail(emailField.getText());
                student.setFirstName(firstNameField.getText());
                student.setLastName(lastNameField.getText());
                int id;
                if ((id = studentDAO.createObject(student)) != -1) {
                    JOptionPane.showMessageDialog(this,
                            "Student added.");
                    student.setId(id);
                    a.insertData(new Object[]{student.getId(), student.getEmail(), student.getFirstName()
                            , student.getLastName(), student.getMarkAverage()});
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Student already added",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                addJFrame.dispose();
            });

            JButton cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(e -> addJFrame.dispose());

            inputPanel.add(emailLabel);
            inputPanel.add(emailField);
            inputPanel.add(firstNameLabel);
            inputPanel.add(firstNameField);
            inputPanel.add(lastNameLabel);
            inputPanel.add(lastNameField);


            JPanel buttonPanel = new JPanel();
            buttonPanel.add(cancelButton);
            buttonPanel.add(addButtonInner);
            addJFrame.setLayout(new FlowLayout());
            addJFrame.getContentPane().add(inputPanel);
            addJFrame.getContentPane().add(buttonPanel);
            addJFrame.setVisible(true);
        });


        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(actionEvent -> {

            if (table.getSelectedRows().length == 0) {
                JOptionPane.showMessageDialog(this,
                        "No students to delete selected",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            JFrame deleteFrame = new JFrame("Deleting");
            deleteFrame.setLocationRelativeTo(this);
            deleteFrame.setSize(300, 100);

            JLabel label = new JLabel("Do you want to deleter rowns " + Arrays.toString(table.getSelectedRows()));
            JButton deleteButton = new JButton("Delete");
            JButton cancelButton = new JButton("Cancel");
            deleteButton.addActionListener(actionEvent1 -> {
                for (int i : table.getSelectedRows()) {
                    studentDAO.deleteObject((Integer) table.getValueAt(i, 0));
                    a.removeRow(i);
                }
                JOptionPane.showMessageDialog(this,
                        "Students have been deleted");
                deleteFrame.dispose();
            });
            cancelButton.addActionListener(actionEvent1 -> deleteFrame.dispose());
            deleteFrame.setLayout(new FlowLayout());
            deleteFrame.getContentPane().add(label);
            deleteFrame.getContentPane().add(cancelButton);
            deleteFrame.getContentPane().add(deleteButton);
            deleteFrame.setVisible(true);
        });

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(actionEvent -> {

        });
        setLayout(new GridBagLayout());

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        buttonPannel.add(addButton);
        buttonPannel.add(removeButton);
        buttonPannel.add(editButton);
        getContentPane().add(buttonPannel);

        pack();
        setVisible(true);
        repaint();
    }

    class StudentTableModel extends AbstractTableModel {
        private String[] columnNames = {"ID", "Email", "Name", "Surname", "average"};

        private Vector<Vector<Object>> data = new Vector<>();

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }


        @Override
        public Object getValueAt(int row, int col) {
            return (data.get(row)).get(col);
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public void setValueAt(Object value, int row, int col) {
            (data.get(row)).setElementAt(value, col);
            fireTableCellUpdated(row, col);
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }

        public void insertData(Object[] values) {
            data.add(new Vector<>());
            for (Object value : values) {
                (data.get(data.size() - 1)).add(value);
            }
            fireTableDataChanged();
        }

        public void removeRow(int row) {
            data.removeElementAt(row);
            fireTableDataChanged();
        }

    }

    class StudentTablePanel extends JPanel {

        public StudentTablePanel(String s) throws HeadlessException {
            super();
            setTitle(s);
            final JTable table = new JTable(new StudentTableModel());
            table.setPreferredScrollableViewportSize(new Dimension(500, 70));
            table.setFillsViewportHeight(true);

            StudentTableModel a = (StudentTableModel) table.getModel();
            StudentDAOImpl studentDAO = new StudentDAOImpl();
            Collection<Student> allObjects = studentDAO.getAllObjects(Student.class);
            Object[] values = new Object[a.columnNames.length];
            for (Student allObject : allObjects) {
                values[0] = allObject.getId();
                values[1] = allObject.getEmail();
                values[2] = allObject.getFirstName();
                values[3] = allObject.getLastName();
                values[4] = allObject.getMarkAverage();
                a.insertData(values);
            }
            //Create the scroll pane and add the table to it.
            JScrollPane scrollPane = new JScrollPane(table);

            //Add the scroll pane to this panel.
            add(scrollPane);

        }

    }


}
