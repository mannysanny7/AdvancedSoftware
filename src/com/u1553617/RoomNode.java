package com.u1553617;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RoomNode {

    String dataItem;
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
    }

}
