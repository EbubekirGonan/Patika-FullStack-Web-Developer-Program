package view;

import business.RoomManager;
import entity.Room;

import javax.swing.*;

public class RoomView extends Layout{
    private JPanel contanier;
    private Room room;
    private RoomManager roomManager;

    public RoomView() {
        this.add(contanier);
        this.guiInitialise(400,500);
        this.room = new Room();
        this.roomManager = new RoomManager();

    }
}
