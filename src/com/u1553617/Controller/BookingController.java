package com.u1553617.Controller;

import com.u1553617.Model.Booking;
import com.u1553617.Model.BookingNode;
import com.u1553617.Model.Room;
import com.u1553617.Model.RoomNode;
import com.u1553617.View.Clerk;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class BookingController extends Thread{

    private Clerk clerkGUI;
    private Booking<BookingNode> bookingList;
    private Room<RoomNode> roomList;

    public BookingController(Clerk clerkGUI, Booking<BookingNode> bookingList, Room<RoomNode> roomList) {
        this.clerkGUI = clerkGUI;
        this.bookingList = bookingList;
        this.roomList = roomList;


        // actionlisteners which respond to the buttons
        // the view simply calls to these functions
        this.clerkGUI.viewRoomsActionListener((new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                showRoomsAvailable();
            }
        }));

        this.clerkGUI.addBookingActionListener((new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addBookingDetails();
            }
        }));

        this.clerkGUI.viewBookingActionListener((new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                showBookingDetails();
            }
        }));
    }

    /*
        show rooms
     */
    public void showRoomsAvailable() {
        ArrayList<RoomNode> all = new ArrayList<RoomNode>();
        all = roomList.displayAllRooms(roomList);
        Iterator<RoomNode> it = all.iterator();

        //clear table
        clerkGUI.getTableModel().setRowCount(0);

        while (it.hasNext()) {
            RoomNode currentRoom = it.next();
            //adding relevant data about the room to table
            clerkGUI.getTableModel().addRow(new Object[]
                    {
                            currentRoom.getRoomName(), currentRoom.getRoomSize(), currentRoom.getRoomType(),
                            currentRoom.isRoomAvailable(), currentRoom.getTimeUnavailable()
                    });
            //i++;
        }
    }

    /*
        Get room selected and fill details
     */
    public void showBookingDetails(){
        //clear any forms
        clerkGUI.getBookingMadeByTF().setText("");
        clerkGUI.getBookingContactTF().setText("");
        clerkGUI.getBookingNotesTF().setText("");

        Integer c = clerkGUI.getTable().getSelectedColumn();
        Integer r = clerkGUI.getTable().getSelectedRow();

        String selectedRoom = clerkGUI.getTable().getValueAt(r,c).toString();

        BookingNode selected = bookingList.getBookingByName(selectedRoom);

        if (selected != null) {
            clerkGUI.getBookingMadeByTF().setText(selected.bookingMadeBy);
            clerkGUI.getBookingContactTF().setText(selected.bookingContact);
            clerkGUI.getBookingNotesTF().setText(selected.bookingNotes);
        }
    }


    public void addBookingDetails() {
        Integer c = clerkGUI.getTable().getSelectedColumn();
        Integer r = clerkGUI.getTable().getSelectedRow();
        System.out.println(c + r);
        String selectedRoom = clerkGUI.getTableModel().getValueAt(r,c).toString();

        String madeBy = clerkGUI.getBookingMadeByTF().getText();
        String contact = clerkGUI.getBookingContactTF().getText();
        String notes = clerkGUI.getBookingNotesTF().getText();

        bookingList.addBooking(selectedRoom, madeBy, contact, notes);
    }

}
