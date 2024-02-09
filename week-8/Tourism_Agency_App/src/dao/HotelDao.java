package dao;

import core.Db;
import entity.Hotel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HotelDao {
    private final Connection con;

    public HotelDao() {
        this.con = Db.getInstance();
    }

    public Hotel getById (int id){
        Hotel obj = null;
        String query = "SELECT * FROM public.hotel WHERE hotel_id = ?";
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

    public ArrayList<Hotel> findAll(){
        ArrayList<Hotel> hotelList = new ArrayList<>();
        String sql = "SELECT * FROM public.hotel ORDER BY hotel_id ASC";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while(rs.next()){
                hotelList.add(this.match(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hotelList;
    }

    public boolean save(Hotel hotel){
        String query = "INSERT INTO public.hotel " +
                "(hotel_name, hotel_address, hotel_email, hotel_phone, hotel_star," +
                "free_parking, free_wifi, pool, fitness_center," +
                "concierge, spa, room_service) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1, hotel.getName());
            pr.setString(2, hotel.getAddres());
            pr.setString(3, hotel.getEmail());
            pr.setString(4, hotel.getPhone());
            pr.setString(5, hotel.getStar());
            pr.setBoolean(6, hotel.hasFreeParking());
            pr.setBoolean(7, hotel.hasFreeWifi());
            pr.setBoolean(8, hotel.hasPool());
            pr.setBoolean(9, hotel.hasFitnessCenter());
            pr.setBoolean(10, hotel.hasConcierge());
            pr.setBoolean(11, hotel.hasSpa());
            pr.setBoolean(12, hotel.hasRoomService());

            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean update(Hotel hotel){
        String query = "UPDATE public.hotel SET hotel_name = ?, " +
                "hotel_address = ?, " +
                "hotel_email = ?," +
                "hotel_phone = ?," +
                "hotel_star = ?," +
                "free_parking = ?," +
                "free_wifi = ?," +
                "pool = ?," +
                "fitness_center = ?," +
                "concierge = ?," +
                "spa = ?," +
                "room_service = ?" +
                " WHERE hotel_id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1, hotel.getName());
            pr.setString(2, hotel.getAddres());
            pr.setString(3, hotel.getEmail());
            pr.setString(4, hotel.getPhone());
            pr.setString(5, hotel.getStar());
            pr.setInt(6, hotel.getId());
            pr.setBoolean(7, hotel.hasFreeParking());
            pr.setBoolean(8, hotel.hasFreeWifi());
            pr.setBoolean(9, hotel.hasPool());
            pr.setBoolean(10, hotel.hasFitnessCenter());
            pr.setBoolean(11, hotel.hasConcierge());
            pr.setBoolean(12, hotel.hasSpa());
            pr.setBoolean(13, hotel.hasRoomService());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean delete(int id){
        String query = "DELETE FROM public.hotel WHERE hotel_id = ?";
        try{
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public Hotel match(ResultSet rs) throws SQLException {
        Hotel obj = new Hotel();
        obj.setId(rs.getInt("hotel_id"));
        obj.setName(rs.getString("hotel_name"));
        obj.setAddres(rs.getString("hotel_address"));
        obj.setEmail(rs.getString("hotel_email"));
        obj.setPhone(rs.getString("hotel_phone"));
        obj.setStar(rs.getString("hotel_star"));
        obj.setHasFreeParking(rs.getBoolean("free_parking"));
        obj.setHasFreeWifi(rs.getBoolean("free_wifi"));
        obj.setHasPool(rs.getBoolean("pool"));
        obj.setHasFitnessCenter(rs.getBoolean("fitness_center"));
        obj.setHasConcierge(rs.getBoolean("concierge"));
        obj.setHasSpa(rs.getBoolean("spa"));
        obj.setHasRoomService(rs.getBoolean("room_service"));
        return obj;
    }


}
