package com.u1553617.Controller;

import com.u1553617.Model.Room;
import com.u1553617.Model.RoomNode;
import com.u1553617.View.Manager;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class RoomController {
    private Manager managerGUI;
    private Room<RoomNode> roomList;


    public RoomController(Manager manager, Room<RoomNode> roomList) {
        this.managerGUI = manager;
        this.roomList = roomList;

        // actionlisteners which respond to the buttons
        // the view simply calls to these functions
        this.managerGUI.addRoomActionListener((new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addRoom();
            }
        }));
        this.managerGUI.viewListActionListener((new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewListOfRoom();
            }
        }));
        this.managerGUI.removeRoomActionListener((new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                removeRoom();
            }
        }));
        this.managerGUI.getRoomAvailActionListener((new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewRoomAvailability();
            }
        }));
        this.managerGUI.markRoomUnavailableActionListener((new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                markRoomUnavailable();
            }
        }));
        this.managerGUI.viewTermDateActionListener((new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewTermDates();
            }
        }));
        this.managerGUI.submitTermDateActionListener((new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                submitTermDates();
            }
        }));
    }

    public void addRoom() {
        String newRoomText = managerGUI.getRoomId();
        Integer newRoomSize = managerGUI.getRoomSizeCB();
        String newRoomType = managerGUI.getRoomTypeCB();
        //add to list

        roomList.addRoom(newRoomText, newRoomSize, newRoomType, true);
    }

    public void viewListOfRoom(){
        ArrayList<RoomNode> all = new ArrayList<RoomNode>();
        all = roomList.displayAllRooms(roomList);
        Iterator<RoomNode> it = all.iterator();

        //clear table
        managerGUI.getTableModel().setRowCount(0);

        while(it.hasNext()) {
            RoomNode currentRoom = it.next();
            //adding relevant data about the room to table
            managerGUI.getTableModel().addRow(new Object[]
                    {
                            currentRoom.getRoomName(), currentRoom.getRoomSize(), currentRoom.getRoomType(),
                            currentRoom.isRoomAvailable(), currentRoom.getTimeUnavailable()
                    });
            //i++;
        }
    }

    public void removeRoom() {
        Integer c = managerGUI.getRoomsTable().getSelectedColumn();
        Integer r = managerGUI.getRoomsTable().getSelectedRow();

        String selectedRoom = managerGUI.getRoomsTable().getValueAt(r,c).toString();
        //System.out.println(selectedRoom);
        boolean roomRemoved = roomList.removeRoom(selectedRoom);
        //System.out.println("Removed? " + roomRemoved);
    }

    public void viewRoomAvailability() {
        Integer c = managerGUI.getRoomsTable().getSelectedColumn();
        Integer r = managerGUI.getRoomsTable().getSelectedRow();

        String selectedRoom = managerGUI.getRoomsTable().getValueAt(r,c).toString();
        //System.out.println(selectedRoom);
    }

    public void markRoomUnavailable() {
        Integer c = managerGUI.getRoomsTable().getSelectedColumn();
        Integer r = managerGUI.getRoomsTable().getSelectedRow();


        String selectedRoom = managerGUI.getRoomsTable().getValueAt(r,c).toString();
        String timeUnavailable = managerGUI.getTimeUnavailable();

        RoomNode roomToMark = roomList.getRoomByName(selectedRoom);
        //System.out.println("FOUND BY GUI:" + roomToMark.getRoomName());
        roomToMark.setRoomAvailable(false);
        roomToMark.setTimeUnavailable(timeUnavailable);
    }

    public void submitTermDates() {
        Integer c = managerGUI.getRoomsTable().getSelectedColumn();
        Integer r = managerGUI.getRoomsTable().getSelectedRow();


        //String selectedRoom = roomsTable.getValueAt(r,c).toString();
        String start = managerGUI.getStartTermDate();
        String end = managerGUI.getEndTermDate();

        roomList.setStartTermDate(start);
        roomList.setEndTermDate(end);
    }

    public void viewTermDates() {
        String start = roomList.getStartTermDate();
        String end = roomList.getEndTermDate();

        managerGUI.setTermDatesView(start + " - " + end);
    }

}
