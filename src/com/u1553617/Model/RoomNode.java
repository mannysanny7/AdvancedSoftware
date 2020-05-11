package com.u1553617.Model;

public class RoomNode<T> {

    public String room;
    public RoomNode<T> next;

    public Integer roomSize;
    public String roomType;
    public boolean roomAvailable = true; //make room available by default
    public String timeUnavailable;

    //date time
    public String roomTermStart, roomTermEnd;

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

    public void setNext(RoomNode<T> newRoom) {
        this.next = newRoom;
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

    public Integer getRoomSize() {
        return roomSize;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomTermStart() {
        return roomTermStart;
    }

    public void setRoomTermStart(String roomTermStart) {
        this.roomTermStart = roomTermStart;
    }

    public String getRoomTermEnd() {
        return roomTermEnd;
    }

    public void setRoomTermEnd(String roomTermEnd) {
        this.roomTermEnd = roomTermEnd;
    }

    public String getTimeUnavailable(){
        return timeUnavailable;
    }

    public void setTimeUnavailable(String timeUnavailable) {
        this.timeUnavailable = timeUnavailable;
    }
}
