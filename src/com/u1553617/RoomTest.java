package com.u1553617;

import com.u1553617.View.Manager;

import javax.management.DescriptorAccess;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class RoomTest {
    public static void main(String[] args) {
        Room roomTree = new Room();

        String[] header = new String[]{"Room ID", "Room Size", "Room Type", "Room Available"};

        Manager managerGUI = new Manager();
        DefaultTableModel tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(header);

        JTable roomsTable = managerGUI.getRoomsTable();
        managerGUI.getPanel().add(new JScrollPane(roomsTable));
        roomsTable.setModel(tblModel);

        JFrame frame = new JFrame("TESTING MANAGER GUI");

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

        managerGUI.getViewListBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //view all rooms and display them in table
                ArrayList<RoomNode> all = new ArrayList<RoomNode>();
                all = roomTree.display();

                Iterator<RoomNode> it = all.iterator();
                int i = 0;

                while(it.hasNext()){
                    RoomNode currentRoom = it.next();
                    //System.out.println("Element " + i + " - " + currentRoom);
                    tblModel.addRow(new Object[]{currentRoom.roomID, currentRoom.roomSize, currentRoom.roomType, currentRoom.roomAvailable});
                    i++;
                }

            }
        });


        //DefaultTableModel finalTblModel = tblModel;
        managerGUI.getAddRoomBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String newRoomText = managerGUI.getRoomId();
                Integer newRoomSize = managerGUI.getRoomSizeCB();
                String newRoomType = managerGUI.getRoomTypeCB();
                //add to table
                //System.out.println(newRoomText + " " + newRoomSize + " " + newRoomType);
                roomTree.add(newRoomText, newRoomSize, newRoomType);

                //tblModel.addRow(new Object[]{newRoomText, newRoomSize, newRoomType});

            }
        });

        managerGUI.getRemoveRoomButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer c = roomsTable.getSelectedColumn();
                Integer r = roomsTable.getSelectedRow();


                String selectedRoom = roomsTable.getValueAt(r,c).toString();
                System.out.println(selectedRoom);
            }
        });



    }
}
