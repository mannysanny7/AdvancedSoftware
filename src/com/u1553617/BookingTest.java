package com.u1553617;

import com.u1553617.View.Clerk;

public class BookingTest extends Thread{
   /* public static void main(String[] args) {
        Booking<BookingNode> bookingList = new Booking();

        Clerk clerkGUI = new Clerk();
        clerkGUI.showForm();


    }*/
    private Clerk clerkGUI;


    public BookingTest() {
        clerkGUI = new Clerk();
        clerkGUI.showForm();
    }

    public void run() {
        System.out.println("thread is running...");
    } // method run


}
