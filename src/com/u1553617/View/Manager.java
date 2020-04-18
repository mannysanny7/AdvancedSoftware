package com.u1553617.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Manager {
    private JTextField roomTF;
    private JPanel panel1;
    private JButton addRoomBtn;
    private JButton viewListBtn;
    private JComboBox roomSizeCB;
    private JComboBox roomTypeCB;

    public JPanel getPanel() {
        return panel1;
    }


    /*
    Action Listener in Controller deals with adding room.

    public void addRoomActionListener(ActionListener addRoomAL) {
        addRoomBtn.addActionListener(addRoomAL);
    }
*/

    public JButton getViewListBtn() {
        return viewListBtn;
    }

    public JButton getAddRoomBtn() {
        return addRoomBtn;
    }

    public String getRoomId() {
        return roomTF.getText();
    }

    public String getRoomTypeCB() {
        return roomTypeCB.getSelectedItem().toString();
    }

    public Integer getRoomSizeCB() {
        String size = roomSizeCB.getSelectedItem().toString();
        return Integer.parseInt(size);
    }

    /*
    public void viewListActionListener(ActionListener viewListAL) {
        viewListBtn.addActionListener(viewListAL);
        System.out.println("View List Button Pressed");
    }
    */





    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        final JLabel label1 = new JLabel();
        label1.setText("Room ID:");
        panel1.add(label1);
        roomTF = new JTextField();
        roomTF.setColumns(5);
        roomTF.setText("");
        panel1.add(roomTF);
        final JLabel label2 = new JLabel();
        label2.setText("Room Size");
        panel1.add(label2);
        roomSizeCB = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("1");
        defaultComboBoxModel1.addElement("2");
        defaultComboBoxModel1.addElement("3");
        defaultComboBoxModel1.addElement("4");
        defaultComboBoxModel1.addElement("5");
        defaultComboBoxModel1.addElement("6");
        defaultComboBoxModel1.addElement("7");
        defaultComboBoxModel1.addElement("8");
        defaultComboBoxModel1.addElement("9");
        defaultComboBoxModel1.addElement("10");
        roomSizeCB.setModel(defaultComboBoxModel1);
        panel1.add(roomSizeCB);
        final JLabel label3 = new JLabel();
        label3.setText("Room Type");
        panel1.add(label3);
        roomTypeCB = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("Computer Lab");
        defaultComboBoxModel2.addElement("Tutorial Room");
        defaultComboBoxModel2.addElement("Lecture Theatre");
        roomTypeCB.setModel(defaultComboBoxModel2);
        panel1.add(roomTypeCB);
        addRoomBtn = new JButton();
        addRoomBtn.setText("Add Room");
        panel1.add(addRoomBtn);
        viewListBtn = new JButton();
        viewListBtn.setText("View List");
        panel1.add(viewListBtn);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}
