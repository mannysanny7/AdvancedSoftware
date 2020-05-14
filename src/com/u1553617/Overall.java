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

public class Overall {

    public static void main(String[] args) {
        Room<RoomNode> roomList = new Room();
        Manager managerView = new Manager();
        RoomController cont = new RoomController(managerView, roomList);

        Booking<BookingNode> bookingList = new Booking();
        Clerk clerkView = new Clerk();
        BookingController bookCont = new BookingController(clerkView, bookingList, roomList);

        managerView.showForm();
        clerkView.showForm();
    }

}
