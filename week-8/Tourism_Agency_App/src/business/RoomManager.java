package business;

import dao.RoomDao;
import entity.Room;

import java.util.ArrayList;

public class RoomManager {
    private final RoomDao roomDao;

    public RoomManager() {
        this.roomDao = new RoomDao();
    }
    public Room getById(int id){
        return this.roomDao.getById(id);
    }
    public ArrayList<Object[]> getForTable (){

        ArrayList<Object[]> roomRowList = new ArrayList<>();
        for(Room room: this.findAll()){
            Object[] rowObject = {room.getId(), room.getHotelId(), room.getPensionId(), room.getType(), room.getStock(), room.getAdultPrice(), room.getChildPrice(), room.getBedCount(), room.getBedCount(), room.getArea(), room.hasTV(), room.hasMiniBar(), room.hasGameConsole(), room.hasSafeCase(), room.hasProjector()};
            roomRowList.add(rowObject);
        }
        return roomRowList;
    }
    public ArrayList<Room> findAll(){
        return this.roomDao.findAll();
    }
    public boolean save (Room room){
        return this.roomDao.save(room);
    }
    public boolean update(Room room){
        return this.roomDao.update(room);
    }
}
