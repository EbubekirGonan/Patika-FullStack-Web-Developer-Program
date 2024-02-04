package dao;

import core.Db;
import entity.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDao {
    private final Connection con;

    public RoomDao() {
        this.con = Db.getInstance();
    }

    public Room getById (int id){
        Room obj = null;
        String query = "SELECT * FROM public.room WHERE room_id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                obj = this.match(rs);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return obj;
    }
    public ArrayList<Room> findAll(){
        ArrayList<Room> roomList = new ArrayList<>();
        String sql = "SELECT * FROM public.room ORDER BY room_id ASC";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while(rs.next()){
                roomList.add(this.match(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roomList;
    }

    public boolean save(Room room){
        String query = "INSERT INTO public.room (" +
                "room_hotel_id, room_pension, room_type," +
                " stock, adult_price, child_price, " +
                "room_season_id, bed_count, area," +
                "tv, minibar, game_console," +
                "safe_case, projector) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


        try {
            PreparedStatement pr = initRoomPreparedStatement(query, room);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean update(Room room){
        String query = "UPDATE public.room SET (" +
                "room_hotel_id = ?, room_pension = ?, room_type = ?," +
                " stock = ? , adult_price = ?, child_price = ? , " +
                "room_season_id = ? , bed_count = ?, area = ?," +
                "tv = ?, minibar = ?, game_console = ?," +
                "safe_case = ?, projector = ?) WHERE room_id = ?";
        try {
            PreparedStatement pr = initRoomPreparedStatement(query, room);
            pr.setInt(15, room.getId());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    private PreparedStatement initRoomPreparedStatement(String query, Room room) throws SQLException {
        PreparedStatement pr = this.con.prepareStatement(query);
        pr.setInt(1, room.getHotelId());
        pr.setInt(2, room.getPensionId());
        pr.setString(3, String.valueOf(room.getType()));
        pr.setInt(4, room.getStock());
        pr.setInt(5, room.getAdultPrice());
        pr.setInt(6, room.getChildPrice());
        pr.setInt(7, room.getSeasonId());
        pr.setInt(8, room.getBedCount());
        pr.setInt(9, room.getArea());
        pr.setBoolean(10, room.hasTV());
        pr.setBoolean(11, room.hasMiniBar());
        pr.setBoolean(12, room.hasGameConsole());
        pr.setBoolean(13, room.hasSafeCase());
        pr.setBoolean(14, room.hasProjector());
        return pr;
    }

    public Room match(ResultSet rs) throws SQLException {
        Room obj = new Room();
        obj.setId(rs.getInt("room_id"));
        obj.setHotelId(rs.getInt("room_hotel_id"));
        obj.setPensionId(rs.getInt("room_pension"));
        obj.setType(Room.Type.values()[rs.getInt("room_type")]);
        obj.setStock(rs.getInt("stock"));
        obj.setAdultPrice(rs.getInt("adult_price"));
        obj.setChildPrice(rs.getInt("child_price"));
        obj.setSeasonId(rs.getInt("room_season_id"));
        obj.setBedCount(rs.getInt("bed_count"));
        obj.setArea(rs.getInt("area"));
        obj.setHasTV(rs.getBoolean("tv"));
        obj.setHasMiniBar(rs.getBoolean("minibar"));
        obj.setHasGameConsole(rs.getBoolean("game_console"));
        obj.setHasSafeCase(rs.getBoolean("safe_case"));
        obj.setHasProjector(rs.getBoolean("projector"));
        return obj;
    }
}
