package com.u1553617;

import java.util.ArrayList;
import java.util.Date;

public class DataManipulation {

    private ArrayList<Room> allRooms = new ArrayList<Room>();
    enum TypesOfRooms {
        LAB,
        TUTORIAL,
        LECTURE
    }



    public void addRoom(RoomNode newRoom) {



    }

    public void deleteRoom(RoomNode room) {

    }

    /*
    Shows availability of specific room
     */
    public void showAvailability(RoomNode room) {

    }

    /*
    Shows availability of all rooms
     */
    public void showRoomsAvailability() {

    }

    public void markRoomUnavailable(RoomNode room) {

    }

    /*
    Enter term dates so rooms only available in the evenings and weekends during these dates
     */
    public void enterTermDates() {

    }


    /*
    Add new booking or update existing booking
     */
    public synchronized void addBooking(RoomNode room) {

    }

    public void searchAvailableLabs(Date date){

    }

    public void searchIsRoomAvailable() {

    }


    // only one thread at a time can execute a synchronised method
    public synchronized boolean viewRooms(int amount) {
        boolean result = false;

        try {
            Thread.sleep(200);
        }
        catch(Exception e) {}

        return result;
    }  // method






}
