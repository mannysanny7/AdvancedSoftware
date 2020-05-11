package com.u1553617.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Clerk {

    private JFrame frame;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTable table_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Clerk window = new Clerk();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Clerk() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 592, 441);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnAddBooking = new JButton("Add Booking");
        btnAddBooking.setBounds(346, 234, 109, 23);
        frame.getContentPane().add(btnAddBooking);

        JButton btnShowRoomAvailability = new JButton("Show Room Availability");
        btnShowRoomAvailability.setBounds(29, 33, 143, 23);
        frame.getContentPane().add(btnShowRoomAvailability);

        table = new JTable();
        table.setBounds(32, 69, 516, 87);
        frame.getContentPane().add(table);

        JLabel lblBookingMadeBy = new JLabel("Booking made by:");
        lblBookingMadeBy.setBounds(29, 185, 100, 14);
        frame.getContentPane().add(lblBookingMadeBy);

        JLabel lblContactDetail = new JLabel("Contact Detail:");
        lblContactDetail.setBounds(29, 210, 87, 14);
        frame.getContentPane().add(lblContactDetail);

        JLabel lblNotes = new JLabel("Notes:");
        lblNotes.setBounds(29, 233, 46, 14);
        frame.getContentPane().add(lblNotes);

        textField = new JTextField();
        textField.setBounds(121, 182, 187, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(121, 210, 187, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(121, 235, 187, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"All Computer Labs", "All Tutorial Rooms", "All Lecture Theatres"}));
        comboBox.setBounds(29, 282, 143, 20);
        frame.getContentPane().add(comboBox);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(459, 281, 89, 23);
        frame.getContentPane().add(btnSearch);

        table_1 = new JTable();
        table_1.setBounds(29, 323, 516, 55);
        frame.getContentPane().add(table_1);

        JLabel lblAvailableOn = new JLabel("available on:");
        lblAvailableOn.setBounds(182, 285, 77, 14);
        frame.getContentPane().add(lblAvailableOn);
    }
}