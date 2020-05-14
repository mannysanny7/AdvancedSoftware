package com.u1553617.Model;

public class BookingNode<T> {

    public String roomID;
    public String bookingMadeBy, bookingContact, bookingNotes;
    public boolean roomIsAvailable;
    public BookingNode<T> next;

    public BookingNode(String roomName, String bookingBy, String contact, String notes) {
        this.roomID = roomName;
        this.bookingMadeBy = bookingBy;
        this.bookingContact = contact;
        this.bookingNotes = notes;

        this.next = null;
    }

    public BookingNode<T> getNext(){
        return this.next;
    }

    public String getBookingContact() {
        return bookingContact;
    }

    public String getBookingMadeBy() {
        return bookingMadeBy;
    }

    public String getBookingNotes() {
        return bookingNotes;
    }

    public String getRoomID() {
        return roomID;
    }

}
