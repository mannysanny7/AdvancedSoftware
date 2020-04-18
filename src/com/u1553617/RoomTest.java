package com.u1553617;

import com.u1553617.View.Manager;

import javax.swing.*;
import java.awt.event.*;

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

        System.out.println(roomID + " " + roomSize + " " + roomType);

        //managerGUI.getAddRoomBtn().addActionListener(roomTree.addRoom(managerGUI.getRoomId(), managerGUI.getRoomSizeCB(), managerGUI.getRoomTypeCB()));
        managerGUI.getViewListBtn().addActionListener(roomTree.allRooms());


        managerGUI.getAddRoomBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String newRoomText = managerGUI.getRoomId();
                Integer newRoomSize = managerGUI.getRoomSizeCB();
                String newRoomType = managerGUI.getRoomTypeCB();
                // .... do some operation on value ...
                System.out.println(newRoomText + " " + newRoomSize + " " + newRoomType);
                roomTree.add(newRoomText, newRoomSize, newRoomType);
            }
        });



    }
}
