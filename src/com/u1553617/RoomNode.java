package com.u1553617;

import java.util.ArrayList;
import java.util.Date;

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
    Date roomDateTime; //availability of room to book
    boolean roomAvailable = true; //by default, room is available

    RoomNode(String ID, Integer size, String type, boolean isAvailable){
        dataItem = ID;

        roomID = ID;
        roomSize = size;
        roomType = type;

        roomAvailable = isAvailable;


        left = null;
        right = null;
    }

}
