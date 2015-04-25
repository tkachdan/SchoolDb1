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

        new StudentTableFrame();

    }

    public StudentTableFrame() throws HeadlessException {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel buttonPannel = new JPanel();
        buttonPannel.setLayout(new FlowLayout());

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

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(actionEvent -> {
            JFrame addJFrame = new JFrame("Add student");
            JButton deleteButton = new JButton("Add");
            JButton cancelButton = new JButton("Cancel");
            deleteButton.addActionListener(actionEvent1 -> {
                for (int i : table.getSelectedRows()) {
                    studentDAO.readObjectById(i);
                }
                JOptionPane.showMessageDialog(this,
                        "Students with id " + Arrays.toString(table.getSelectedRows()) + " have been deleted");
            });
            cancelButton.addActionListener(actionEvent1 -> dispose());
            addJFrame.setLayout(new FlowLayout());
            addJFrame.getContentPane().add(cancelButton);
            addJFrame.getContentPane().add(deleteButton);
            addJFrame.pack();
            addJFrame.setVisible(true);
        });


        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(actionEvent -> {
            JFrame areYouSuerJFrame = new JFrame("Deleting");
            JLabel label = new JLabel("Do you want to deleter rowns " + Arrays.toString(table.getSelectedRows()));
            JButton deleteButton = new JButton("Delete");
            JButton cancelButton = new JButton("Cancel");
            deleteButton.addActionListener(actionEvent1 -> {
                for (int i : table.getSelectedRows()) {
                    studentDAO.deleteObject(i);
                }
                JOptionPane.showMessageDialog(this,
                        "Students with id " + Arrays.toString(table.getSelectedRows()) + " have been deleted");
            });
            cancelButton.addActionListener(actionEvent1 -> dispose());
            areYouSuerJFrame.setLayout(new FlowLayout());
            areYouSuerJFrame.getContentPane().add(label);
            areYouSuerJFrame.getContentPane().add(cancelButton);
            areYouSuerJFrame.getContentPane().add(deleteButton);
            areYouSuerJFrame.pack();
            areYouSuerJFrame.setVisible(true);
        });

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        buttonPannel.add(addButton);
        buttonPannel.add(removeButton);
        buttonPannel.add(editButton);
        getContentPane().add(buttonPannel);


        setLayout(new GridLayout(2, 1));
        pack();
        setVisible(true);
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
            for (int i = 0; i < values.length; i++) {
                (data.get(data.size() - 1)).add(values[i]);
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
