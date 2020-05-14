package com.u1553617;

import com.u1553617.*;
import com.u1553617.Controller.BookingController;
import com.u1553617.Model.Booking;
import com.u1553617.Model.BookingNode;
import com.u1553617.Model.Room;
import com.u1553617.Controller.RoomController;
import com.u1553617.Model.RoomNode;
import com.u1553617.View.Clerk;
import com.u1553617.View.Manager;

public class Overall{

    public static void main(String[] args) {
        Room<RoomNode> roomList = new Room();
        Manager managerView = new Manager();
        RoomController cont = new RoomController(managerView, roomList);

        Booking<BookingNode> bookingList = new Booking();

        BookingController bookCont1, bookCont2, bookCont3;
        Clerk clerkView1 = new Clerk();
        Clerk clerkView2 = new Clerk();
        Clerk clerkView3 = new Clerk();

        bookCont1 = new BookingController(clerkView1, bookingList, roomList);
        bookCont2 = new BookingController(clerkView2, bookingList, roomList);
        bookCont3 = new BookingController(clerkView3, bookingList, roomList);

        bookCont1.start();
        bookCont2.start();
        bookCont3.start();

        managerView.showForm();
        clerkView1.showForm();
        clerkView2.showForm();
        clerkView3.showForm();
    }

}
