package com.u1553617;

import com.u1553617.View.Manager;

import javax.swing.*;

public class RoomTest {
    public static void main(String[] args) {
        Room roomTree = new Room();

        roomTree.add("A1", 20, "Computer Lab");

        //roomTree.display();

        Manager managerGUI = new Manager();



        JFrame frame = new JFrame("TESTING MANAGER GUI");

        frame.setContentPane(managerGUI.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.pack();

        frame.setVisible(true);

        String roomID = managerGUI.getRoomId();
        Integer roomSize = managerGUI.getRoomSizeCB();
        String roomType = managerGUI.getRoomTypeCB();

        managerGUI.getAddRoomBtn().addActionListener(roomTree.addRoom(roomID, roomSize, roomType));
        managerGUI.getViewListBtn().addActionListener(roomTree.allRooms());

    }
}
