package com.u1553617;

import java.awt.*;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

public class Room<T> {

    private RoomNode<T> roomHead; //head of list
    private int size = 0; //size of list

    //private ArrayList<RoomNode> allRooms = new ArrayList<RoomNode>();

    public Room() {
        this.roomHead = null;
    }

    public void addRoom(String roomID, Integer roomSize, String type, boolean isAvailable) {
        //System.out.println(roomToAdd.toString());

        RoomNode<T> tempRoom = new RoomNode<T>(roomID, roomSize, type, isAvailable);
        System.out.println(tempRoom.room);

        if (this.roomHead == null) { //if room is alone, add as head.
            this.roomHead = tempRoom;

            System.out.println("first entry: " + roomHead.room);
            //Add new room to list. It is the first one.
            roomHead = tempRoom;
        } else { //else add to end of list
            RoomNode<T> newRoom = tempRoom;

            RoomNode<T> lastRoom = getLastRoom(roomHead);
            lastRoom.next = newRoom; //add new room to end of list
            System.out.println("next entry: " + newRoom.room);
            size++; //increment list
        }
    }

    public RoomNode<T> getLastRoom(RoomNode<T> room) {
        RoomNode<T> lastRoom = room;

        if (lastRoom.next != null) { //if room has room attached, do method on attached room.
            return getLastRoom(lastRoom.next);
        } else {
            return lastRoom;
        }

    }

    public RoomNode<T> getSpecificRoom(int index) {
        if (index < 0) {
            return null;
        }
        RoomNode<T> currentRoom = null;
        if (this.roomHead != null) {
            currentRoom = roomHead;
            for (int i=0;i<index;i++) {
                if (currentRoom.next == null){
                    //no next room
                    return currentRoom;
                }
                currentRoom = currentRoom.next;
                System.out.println("found room: " + currentRoom.getRoomName());
            }
            return currentRoom;
        }
        return currentRoom;
    }

    public ArrayList<RoomNode> displayAllRooms(Room<T> room) {
        ArrayList<RoomNode> allRooms = new ArrayList<RoomNode>();
        RoomNode<T> currentRoom = room.roomHead;
        while (currentRoom != null){
            allRooms.add(currentRoom);
            currentRoom = currentRoom.next;
        }
        return allRooms;
    }

    public int getSize() {
        return size;
    }
}

    /*void addRoom(T newRoom) {
        RoomNode<T> temporary = topRoom;
        topRoom = new RoomNode<T>(newRoom);
        topRoom.next = temporary;
    }

    public T pop() {
        RoomNode<T> oldTop = topRoom;
        //if (size == 0) {
        //    return null;
        //}
        topRoom = topRoom.getNext();
        return oldTop.getValue();
    }

    public T peek() {
        //if (size == 0){
        //    return null;
        //}
        return topRoom.getValue();
    }

    public T getEntry() throws EmptyStackException {
        if (topRoom == null)
            throw new EmptyStackException();
        else {
            T result = topRoom.room;
            topRoom = topRoom.next;
            return result;
        }
    }

    public void empty() {
        topRoom = null;
    }

    public ArrayList<T> display() {
        displayAllRooms();
        return allRooms;
    }

    private void displayAllRooms() {
        while (true) {
            try {
                //System.out.println(getEntry());
                allRooms.add(getEntry());
            } catch (EmptyStackException e) {
                break;
            }
        }
    }*/

/*    private String roomNumber;
    private Integer roomSize;
    private String roomType;
    private Date roomDateTime; //availability of room to book
    private boolean roomAvailable;*//*

    private RoomNode root;
    private ArrayList<RoomNode> allRooms = new ArrayList<RoomNode>();

    Room(){
        root = null;
    }

    void add(String newRoom, Integer size, String type){
        root = addNewNode(root, newRoom, size, type);
    }

    private RoomNode addNewNode(RoomNode R, String Id, Integer size, String type){
        if (R == null)
            return new RoomNode(Id, size, type , true);
        else if (R.roomID.compareTo(Id) > 0){
            R.left = addNewNode(R.left, Id, size, type);
            return R;
        } else {
            R.right = addNewNode(R.right, Id, size, type);
            return R;
        }
    }

    ArrayList<RoomNode> display(){
        displayTree(root);
        return (allRooms);
    }

    private void displayTree(RoomNode R){
        if (R != null) {
            displayTree(R.left);
            System.out.println(R.roomID + R.roomSize + R.roomType + R.roomAvailable);
            allRooms.add(R);
            displayTree(R.right);
        }
    }



}*/