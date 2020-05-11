package com.u1553617;

import com.u1553617.Model.Room;
import com.u1553617.Model.RoomNode;
import com.u1553617.View.Manager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class RoomTest {
    public Manager managerGUI;
    Room<RoomNode> roomList = new Room();

    public static void main(String[] args) {
        Room<RoomNode> roomList = new Room();

        Manager managerGUI = new Manager();

        String[] header = new String[]{"Room ID", "Room Size", "Room Type", "Room Available", "Time Unavailable"};
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(header);

        JTable roomsTable = managerGUI.getRoomsTable();
        managerGUI.getPanel().add(new JScrollPane(roomsTable));
        roomsTable.setModel(tblModel);

        JFrame frame = new JFrame("MANAGER GUI");

        frame.setContentPane(managerGUI.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.pack();

        frame.setVisible(true);


        String roomID = managerGUI.getRoomId();
        Integer roomSize = managerGUI.getRoomSizeCB();
        String roomType = managerGUI.getRoomTypeCB();

        System.out.println(roomID + " " + roomSize + " " + roomType);

        //managerGUI.getAddRoomBtn().addActionListener(roomTree.addRoom(managerGUI.getRoomId(), managerGUI.getRoomSizeCB(), managerGUI.getRoomTypeCB()));
        //managerGUI.getViewListBtn().addActionListener(roomTree.allRooms());

        //Add rooms
        managerGUI.getAddRoomBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String newRoomText = managerGUI.getRoomId();
                Integer newRoomSize = managerGUI.getRoomSizeCB();
                String newRoomType = managerGUI.getRoomTypeCB();
                //add to list

                roomList.addRoom(newRoomText, newRoomSize, newRoomType, true);
            }
        });

        //View List of Rooms
        managerGUI.getViewListBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<RoomNode> all = new ArrayList<RoomNode>();
                all = roomList.displayAllRooms(roomList);
                Iterator<RoomNode> it = all.iterator();

                //clear table
                tblModel.setRowCount(0);

                while(it.hasNext()) {
                    RoomNode currentRoom = it.next();
                    //adding relevant data about the room to table
                    tblModel.addRow(new Object[]
                            {
                                    currentRoom.getRoomName(), currentRoom.getRoomSize(), currentRoom.getRoomType(),
                                    currentRoom.isRoomAvailable(), currentRoom.getTimeUnavailable()
                            });
                    //i++;
                }
            }
        });

        //remove room(s)
        managerGUI.getRemoveRoomButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer c = roomsTable.getSelectedColumn();
                Integer r = roomsTable.getSelectedRow();

                String selectedRoom = roomsTable.getValueAt(r,c).toString();
                //System.out.println(selectedRoom);
                boolean roomRemoved = roomList.removeRoom(selectedRoom);
                //System.out.println("Removed? " + roomRemoved);
                
            }
        });

        //view availability of room
        managerGUI.getViewAvailabiltyOfRoomButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer c = roomsTable.getSelectedColumn();
                Integer r = roomsTable.getSelectedRow();

                String selectedRoom = roomsTable.getValueAt(r,c).toString();
                //System.out.println(selectedRoom);
            }
        });

        //mark room as unavailable
        managerGUI.getMarkRoomAsUnavailableButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer c = roomsTable.getSelectedColumn();
                Integer r = roomsTable.getSelectedRow();


                String selectedRoom = roomsTable.getValueAt(r,c).toString();
                String timeUnavailable = managerGUI.getTimeUnavailable();

                RoomNode roomToMark = roomList.getRoomByName(selectedRoom);
                //System.out.println("FOUND BY GUI:" + roomToMark.getRoomName());
                roomToMark.setRoomAvailable(false);
                roomToMark.setTimeUnavailable(timeUnavailable);
            }
        });

        //Enter term dates
        managerGUI.getSubmitTermDateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer c = roomsTable.getSelectedColumn();
                Integer r = roomsTable.getSelectedRow();


                //String selectedRoom = roomsTable.getValueAt(r,c).toString();
                String start = managerGUI.getStartTermDate();
                String end = managerGUI.getEndTermDate();

                roomList.setStartTermDate(start);
                roomList.setEndTermDate(end);
            }
        });

        managerGUI.getViewTermDatesBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String start = roomList.getStartTermDate();
                String end = roomList.getEndTermDate();

                managerGUI.setTermDatesView(start + " - " + end);
            }
        });

    }
}
