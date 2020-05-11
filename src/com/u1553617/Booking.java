package com.u1553617;

import com.u1553617.Model.RoomNode;

import java.util.ArrayList;

public class Booking<T> {

    private BookingNode<T> bookingHead;
    private int size = 0; //size of list

    private ArrayList<RoomNode> linkedRooms;

    public synchronized void addDetails(String bookingMadeBy, String bookingContact, String bookingNotes) {

    }

    public synchronized boolean viewBookings() {
        return true;
    }

}
