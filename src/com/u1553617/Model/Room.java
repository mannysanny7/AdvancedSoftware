package com.u1553617.Model;

import java.util.ArrayList;

public class Room<T> {
    private RoomNode<T> roomHead; //head of list
    private int size = 0; //size of list
    private String startTermDate, endTermDate;

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
            size++;
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

    public RoomNode<T> getRoomByName(String roomName) {
        RoomNode<T> currentRoom = null;
        if (this.roomHead != null) {
            currentRoom = this.roomHead;
            while (!currentRoom.room.equals(roomName)){
                currentRoom = currentRoom.getNext();
            }
            return currentRoom;
        }
        return currentRoom;
    }

    public boolean removeRoom(String roomName) {
        RoomNode<T> currentRoom = null;
        System.out.println("size before: " + size);
        if (size == 1){//if only 1 room in list
            this.roomHead = null;
            return true;
        }

        if (this.roomHead != null) {
            currentRoom = this.roomHead;
            if (!currentRoom.room.equals(roomName)){
                currentRoom = currentRoom.getNext();
            }
            System.out.println("Room to remove: " + currentRoom.getRoomName());
            //remove the correct selected room

            //get next value to replace current room
            roomHead.setNext(currentRoom.getNext());
            size--;
            System.out.println("size after: " + size);
            return true;
        }
        return false;
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

    public void setStartTermDate(String date) {
        this.startTermDate = date;
    }

    public void setEndTermDate(String date) {
        this.endTermDate = date;
    }

    public String getStartTermDate() {
        return this.startTermDate;
    }

    public String getEndTermDate() {
        return endTermDate;
    }
}