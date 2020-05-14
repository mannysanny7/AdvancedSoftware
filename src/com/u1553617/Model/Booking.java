package com.u1553617.Model;

import com.u1553617.Model.BookingNode;
import com.u1553617.Model.RoomNode;

import java.util.ArrayList;

public class Booking<T> {

    private BookingNode<T> bookingHead;
    private int size = 0; //size of list

    private ArrayList<RoomNode> linkedRooms;

    public synchronized void addBooking(String roomName, String bookingMadeBy, String bookingContact, String bookingNotes) {
        BookingNode<T> tempBooking = new BookingNode<T>(roomName, bookingMadeBy, bookingContact, bookingNotes);

        //increment list
        if (this.bookingHead == null) { //if room is alone, add as head.
            this.bookingHead = tempBooking;

            System.out.println("first entry: " + bookingHead.roomID);
            //Add new room to list. It is the first one.
            bookingHead = tempBooking;
        } else { //else add to end of list
            BookingNode<T> newRoom = tempBooking;

            BookingNode<T> lastRoom = getLastBooking(bookingHead);
            lastRoom.next = newRoom; //add new room to end of list
            System.out.println("next entry: " + newRoom.roomID);
        }
        size++;
    }

    public synchronized boolean viewBookings() {
        return true;
    }

    /*
    Recursive function
     */
    public BookingNode<T> getLastBooking(BookingNode<T> bookingID) {
        BookingNode<T> lastRoom = bookingID;

        if (lastRoom.next != null) { //if room has room attached, do method on attached room.
            return getLastBooking(lastRoom.next);
        } else {
            return lastRoom;
        }

    }

    public BookingNode<T> getBookingByName(String roomName) {
        BookingNode<T> currentBooking = null;
        if (this.bookingHead != null) {
            currentBooking = this.bookingHead;
            while (!currentBooking.roomID.equals(roomName)){
                currentBooking = currentBooking.getNext();
            }
            return currentBooking;
        }
        return currentBooking;
    }

}
