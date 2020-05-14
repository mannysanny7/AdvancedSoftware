package com.u1553617.Model;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

class BookingTest {

    @org.junit.jupiter.api.Test
    void addBooking() {
        Booking<BookingNode> bookingList = new Booking();

        int sizeBefore = bookingList.getSize(); //should be 0

        String selectedRoom = "A1";
        String madeBy = "John Cristopher";
        String contact = "email: jcris@email.com";
        String notes = "Requires 2 hours";

        bookingList.addBooking(selectedRoom, madeBy, contact, notes);

        int sizeAfter = bookingList.getSize(); //should be 1

        Assertions.assertNotEquals(sizeBefore, sizeAfter); //testing adding booking works as size should be greater
    }
}