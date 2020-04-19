package com.u1553617;

import java.awt.*;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

public class Room<T> {

    private RoomNode<T> topRoom;

    private ArrayList<T> allRooms = new ArrayList<T>();

    public Room() {
        topRoom = null;
    }

    void addRoom(T newRoom) {
      /*  RoomNode<T> temp = new RoomNode<T>(newRoom, topRoom);
        topRoom = temp;
        size++;*/
        //System.out.println("new room:" + newRoom);
        RoomNode<T> temporary = topRoom;
        //System.out.println("temporary" + temporary);
        topRoom = new RoomNode<T>(newRoom);
        //System.out.println("top room"+topRoom.room);
        topRoom.next = temporary;
        //System.out.println("top room next:" + topRoom.next.room);
    }

    public T pop() {
        RoomNode<T> oldTop = topRoom;
        //if (size == 0) {
        //    return null;
        //}
        topRoom = topRoom.getNext();
        return oldTop.getValue();
    }

    public T peek(){
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

    public void empty(){
        topRoom = null;
    }

    public ArrayList<T> display() {
       displayAllRooms();
       System.out.println(allRooms);
       return allRooms;
    }

    private void displayAllRooms(){
        /*System.out.println("Array:" + this.allRooms);
        Iterator<T> it = allRooms.iterator();
        int i = 0;
        while (it.hasNext()){
            T nextRoom = it.next();
            System.out.println(nextRoom);
            allRooms.add(nextRoom);
            System.out.println(allRooms);
            i++;
        }*/
        /*while(topRoom.next != null){
            System.out.println(topRoom.next);
        }*/
       // System.out.println(topRoom);
        //System.out.println(topRoom.next);
        //System.out.println(getEntry());
        while (true) {
            try{
                //System.out.println(getEntry());
                allRooms.add(getEntry());
            } catch (EmptyStackException e) {
                break;
            }
        }
    }


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

    private void removeRoomNode(){

    }

    *//*public ActionListener allRooms() {
        ActionListener e = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display();
            }
        };
    return e;
    }

    public ActionListener addRoom(String newRoom, Integer size, String type) {
        ActionListener e = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(newRoom + " " +size+ " " + type);
                add(newRoom, size, type);
            }
        };
        return e;
    }*/



}