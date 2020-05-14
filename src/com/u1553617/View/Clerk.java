package com.u1553617.View;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Clerk {

    private JFrame frame;
    private JTable table;
    private JTextField bookingMadeByTF;
    private JTextField bookingContactTF;
    private JTextField bookingNotesTF;
    private JTable table_1;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JButton btnAddBooking;
    private JButton btnShowRoomAvailability;
    private JButton btnSearch;
    private JButton btnShowBookingDetails;

    /**
     * Create the application.
     */
    public Clerk() {
        initialize();
    }

    public void showForm() {
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 592, 441);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        btnShowBookingDetails = new JButton("Show Booking Availability");
        btnShowBookingDetails.setBounds(346, 210, 190, 23);
        frame.getContentPane().add(btnShowBookingDetails);

        btnAddBooking = new JButton("Add Booking");
        btnAddBooking.setBounds(346, 234, 109, 23);
        frame.getContentPane().add(btnAddBooking);

        btnShowRoomAvailability = new JButton("Show Room Availability");
        btnShowRoomAvailability.setBounds(29, 33, 180, 23);
        frame.getContentPane().add(btnShowRoomAvailability);

        table = new JTable();
        table.setBounds(32, 69, 516, 87);
        //frame.getContentPane().add(table);
        String[] header = new String[]{"Room ID", "Room Size", "Room Type", "Room Available", "Time Unavailable"};
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(header);
        table.setModel(tableModel);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(32, 69, 516, 87);
        scrollPane.setViewportView(table);

        frame.getContentPane().add(scrollPane);

        JLabel lblBookingMadeBy = new JLabel("Booking made by:");
        lblBookingMadeBy.setBounds(32, 185, 110, 14);
        frame.getContentPane().add(lblBookingMadeBy);

        JLabel lblContactDetail = new JLabel("Contact Detail:");
        lblContactDetail.setBounds(29, 210, 87, 14);
        frame.getContentPane().add(lblContactDetail);

        JLabel lblNotes = new JLabel("Notes:");
        lblNotes.setBounds(29, 233, 46, 14);
        frame.getContentPane().add(lblNotes);

        bookingMadeByTF = new JTextField();
        bookingMadeByTF.setBounds(130, 182, 187, 20);
        frame.getContentPane().add(bookingMadeByTF);
        bookingMadeByTF.setColumns(10);

        bookingContactTF = new JTextField();
        bookingContactTF.setBounds(121, 210, 187, 20);
        frame.getContentPane().add(bookingContactTF);
        bookingContactTF.setColumns(10);

        bookingNotesTF = new JTextField();
        bookingNotesTF.setBounds(121, 235, 187, 20);
        frame.getContentPane().add(bookingNotesTF);
        bookingNotesTF.setColumns(10);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"All Computer Labs", "All Tutorial Rooms", "All Lecture Theatres"}));
        comboBox.setBounds(29, 282, 143, 20);
        frame.getContentPane().add(comboBox);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(459, 281, 89, 23);
        frame.getContentPane().add(btnSearch);

        table_1 = new JTable();
        table_1.setBounds(29, 323, 516, 55);
        frame.getContentPane().add(table_1);


        JLabel lblAvailableOn = new JLabel("available on:");
        lblAvailableOn.setBounds(182, 285, 77, 14);
        frame.getContentPane().add(lblAvailableOn);
    }

    /*
    Action Listeners in Controller*/
    public void viewRoomsActionListener(ActionListener viewRoomsAL) {
        btnShowRoomAvailability.addActionListener(viewRoomsAL);
    }

    public void addBookingActionListener(ActionListener addBookingAL) {
        btnAddBooking.addActionListener(addBookingAL);
    }

    public void viewBookingActionListener(ActionListener viewBookingAL) {
        btnShowBookingDetails.addActionListener(viewBookingAL);
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getTableModel(){
        return tableModel;
    }

    public JTextField getBookingMadeByTF() {
        return bookingMadeByTF;
    }

    public JTextField getBookingContactTF() {
        return bookingContactTF;
    }

    public JTextField getBookingNotesTF() {
        return bookingNotesTF;
    }
}