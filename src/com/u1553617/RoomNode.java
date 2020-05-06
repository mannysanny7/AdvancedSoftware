package com.u1553617;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RoomNode<T> {

    String room;
    RoomNode<T> next;

    Integer roomSize;
    String roomType;
    boolean roomAvailable = true; //make room available by default

    public RoomNode(String ID, Integer size, String type, boolean isAvailable) {
        room = ID;
        roomSize = size;
        roomType = type;
        roomAvailable = isAvailable;


        next = null;
    }

    public RoomNode<T> getNext() {
        return next;
    }

    public boolean isRoomAvailable() {
        return roomAvailable;
    }

    public void setRoomAvailable(boolean isAvail){
        roomAvailable = isAvail;
    }

    public String getRoomName(){
        return room;
    }

    /*String roomID;
    Integer roomSize;
    enum TypesOfRooms {
        LAB,
        TUTORIAL,
        LECTURE
    }
    String roomType;
    boolean roomAvailable;

    RoomNode(String ID, Integer size, String type, boolean isAvailable) {
        roomID = ID;
        roomSize = size;
        roomType = type;
        roomAvailable = isAvailable;
        next = null;
    }*/

    /*String dataItem;
    RoomNode left, right;

    String roomID; //room letter + number?
    Integer roomSize;
    ArrayList<String> typesOfRooms;
    enum TypesOfRooms {
        LAB,
        TUTORIAL,
        LECTURE
    }
    String roomType;
    Calendar roomDateTime; //availability of room to book
    boolean roomAvailable = true; //by default, room is available

    RoomNode(String ID, Integer size, String type, boolean isAvailable){
        dataItem = ID;

        roomID = ID;
        roomSize = size;
        roomType = type;

        roomAvailable = isAvailable;
        roomDateTime = new GregorianCalendar();

        roomDateTime.set(Calendar.HOUR_OF_DAY, 18);
        roomDateTime.set(Calendar.DAY_OF_WEEK, 2);

        left = null;
        right = null;
    }*/

}
