package business;

import dao.RoomDao;
import entity.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RoomManager {
    private final RoomDao roomDao;

    public RoomManager() {
        this.roomDao = new RoomDao();
    }
    public Room getById(int id){
        return this.roomDao.getById(id);
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
    public boolean stockUpdate (Room room) {
        return this.roomDao.stockUpdate(room);
    }


    public ArrayList<Object[]> filterRooms(String hotel, String address,
                                       String strt_date, String fnsh_date,
                                       String adult_number, String child_number){
        String query = "SELECT DISTINCT room_id, hotel_name, pension_type, room_type, stock, adult_price, " +
                "child_price, bed_count, area, tv, minibar, game_console, safe_case, projector " +
                "FROM public.room r " +
                "JOIN public.hotel h ON r.room_hotel_id = h.hotel_id " +
                "JOIN public.hotel_pension p ON r.room_pension = p.pension_type " +
                "JOIN public.hotel_season s ON h.hotel_id = s.season_hotel_id " +
                "WHERE stock > 0";

        if(hotel != null){
            query += " AND hotel_name ILIKE '%" + hotel + "%'";
        }
        if(address != null){
            query += " AND hotel_address ILIKE '%" + address + "%'";
        }
        if(!(strt_date.isEmpty()) && !(fnsh_date.isEmpty())){
            strt_date = LocalDate.parse(strt_date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
            fnsh_date = LocalDate.parse(fnsh_date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
            query += " AND '" + strt_date + "' BETWEEN season_strt_date AND season_fnsh_date AND '" + fnsh_date + "' BETWEEN season_strt_date AND season_fnsh_date";
        }
        int bed_count = 0;
        if(!adult_number.isEmpty() && Integer.parseInt(adult_number) != 0){
            bed_count += Integer.parseInt(adult_number);
        }
        if(!child_number.isEmpty() && Integer.parseInt(child_number) != 0){
            bed_count += Integer.parseInt(child_number);
        }

        query += " AND bed_count >=" + bed_count;

        query += " ORDER BY room_id ASC;";

        ArrayList<Object[]> filteredRoomList = new ArrayList<>();
        try {
            ResultSet rs = this.roomDao.con.createStatement().executeQuery(query);
            while(rs.next()){
                filteredRoomList.add(getFilteredRooomObjects(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return filteredRoomList;
    }

    public ArrayList<Object[]> filterRooms() {
        return this.filterRooms("", "", "", "", "", "");
    }

    private Object[] getFilteredRooomObjects(ResultSet rs) throws SQLException {

        return new Object[]{rs.getInt("room_id"), rs.getString("hotel_name"), rs.getString("pension_type"),
                rs.getInt("room_type"), rs.getInt("stock"), rs.getInt("adult_price"), rs.getInt("child_price"),
                rs.getInt("bed_count"), rs.getInt("area"), rs.getBoolean("tv"), rs.getBoolean("minibar"),
                rs.getBoolean("game_console"), rs.getBoolean("safe_case"), rs.getBoolean("projector")
        };

    }


}
