package ui;

import db.EmployeeDataHolder;
import db.PhoneNumbersDataHolder;
import entities.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppFrame extends JFrame {

    private final String[] employeeColumnNames = {"employee_id", "employee_name"};
    private final String[] numbersColumnNames = {"employee_id", "employee_number"};

    private EmployeeDataHolder employeeData = new EmployeeDataHolder();
    private PhoneNumbersDataHolder numbersData = new PhoneNumbersDataHolder();
    private Employee alex, john, mike;

    private final DefaultTableModel employeeModel = new DefaultTableModel(employeeColumnNames, 0);
    private final DefaultTableModel numbersModel = new DefaultTableModel(numbersColumnNames, 0);

    private final PaintedPanel paintedPanel;

    public AppFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        paintedPanel = new PaintedPanel();

        paintedPanel.add(new JScrollPane(populateEmployeeTable()));
        paintedPanel.add(new JScrollPane(populateNumbersTable()));

        getContentPane().add(paintedPanel, BorderLayout.CENTER);
        getContentPane().add(buildControlPanel(), BorderLayout.SOUTH);
    }

    private JPanel buildControlPanel() {
        JPanel controlPanel = new JPanel();
        JButton button = new JButton("Name");
        controlPanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(null, "Enter name");
                if (name != null) {
                    showNumberInfo(name);
                }
            }
        });

        return controlPanel;
    }

    private void showNumberInfo(String name) {
        Employee employee = new Employee(name);
        int id = employeeData.getEmployeeData().indexOf(employee);
        String message = !numbersData.getNumbersData().containsKey(id)
                ? "No such employee"
                : numbersData.getNumbersData().get(id).toString();

        JOptionPane.showMessageDialog(this,
                message, "Number info", JOptionPane.INFORMATION_MESSAGE);

        paintedPanel.setDrawTriangle(false);
    }

    private JTable populateEmployeeTable() {
        employeeData.addEmployee(alex = new Employee("Alex"));
        employeeData.addEmployee(john = new Employee("John"));
        employeeData.addEmployee(mike = new Employee("Mike"));

        for (Employee employee : employeeData.getEmployeeData()) {
            Object[] data = {employeeData.getEmployeeData().indexOf(employee), employee.getName()};
            employeeModel.addRow(data);
        }

        return new JTable(employeeModel);
    }

    private JTable populateNumbersTable() {
        ArrayList<String> alexNumber = new ArrayList<>();
        alexNumber.add("123-456");

        ArrayList<String> johnNumber = new ArrayList<>();
        johnNumber.add("456-789");
        johnNumber.add("987-654");

        ArrayList<String> mikeNumber = new ArrayList<>();
        mikeNumber.add("1478-254");
        mikeNumber.add("6547-487");
        mikeNumber.add("1954-478");

        numbersData.addNumber(employeeData.getEmployeeData().indexOf(alex), alexNumber);
        numbersData.addNumber(employeeData.getEmployeeData().indexOf(john), johnNumber);
        numbersData.addNumber(employeeData.getEmployeeData().indexOf(mike), mikeNumber);

        for (int i = 0; i < numbersData.getNumbersData().size(); i++) {
            Object[] data = {i, numbersData.getNumbersData().get(i)};
            numbersModel.addRow(data);
        }

        return new JTable(numbersModel);
    }
}
