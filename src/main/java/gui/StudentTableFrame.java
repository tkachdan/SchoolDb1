package gui;

import persistence.DAO.Impl.StudentDAOImpl;
import persistence.model.Student;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        JButton EditButton = new JButton("Edit");
        StudentTablePanel newContentPane = new StudentTablePanel("Student Table");
        setContentPane(newContentPane);
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
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
                values[3] = allObject.getFirstName();
                values[4] = allObject.getLastName();
                values[5] = allObject.getMarkAverage();
                a.insertData(values);
            }


            //Create the scroll pane and add the table to it.
            JScrollPane scrollPane = new JScrollPane(table);

            //Add the scroll pane to this panel.
            add(scrollPane);

        }

    }


}
