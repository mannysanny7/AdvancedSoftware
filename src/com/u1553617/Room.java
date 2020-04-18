package com.u1553617;

import java.util.ArrayList;

public class Room {

/*    private String roomNumber;
    private Integer roomSize;
    private String roomType;
    private Date roomDateTime; //availability of room to book
    private boolean roomAvailable;*/

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

    /*public ActionListener allRooms() {
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