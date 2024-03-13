package dao;

import core.Db;
import entity.Pension;
import entity.Reservation;
import entity.Room;
import entity.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;

public class ReservationDao {
    public final Connection con;

    public ReservationDao() {
        this.con = Db.getInstance();
    }

    public ArrayList<Reservation> findAll(){
        ArrayList<Reservation> reservationList = new ArrayList<>();
        String sql = "SELECT * FROM public.reservation ORDER BY reservation_id ASC";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while(rs.next()){
                reservationList.add(this.match(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reservationList;
    }

    public Reservation getById (int id){
        Reservation obj = null;
        String query = "SELECT * FROM public.reservation WHERE reservation_id = ?";
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

    public boolean save(Reservation reservation){
        String query = "INSERT INTO public.reservation (" +
                "reservation_room_id, check_in_date," +
                " check_out_date, total_price, guest_count, " +
                "guest_name, guest_citizen_id, guest_mail," +
                "guest_phone, num_of_adult, num_of_child) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, reservation.getReservationRoomId());
            pr.setDate(2, Date.valueOf(reservation.getCheckInDate().toString()));
            pr.setDate(3, Date.valueOf(reservation.getCheckOutDate().toString()));
            pr.setInt(4, reservation.getTotalPrice());
            pr.setInt(5, reservation.getGuestCount());
            pr.setString(6, reservation.getGuestName());
            pr.setString(7, reservation.getGuestCitizenId());
            pr.setString(8, reservation.getGuestMail());
            pr.setString(9, reservation.getGuestPhone());
            pr.setInt(10, reservation.getNumOfAdult());
            pr.setInt(11, reservation.getNumOfChild());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean update(Reservation reservation){
        String query = "UPDATE public.reservation SET guest_name = ?, " +
                " guest_citizen_id = ?, " +
                " guest_mail = ?, " +
                " guest_phone = ?, " +
                " num_of_adult = ?, " +
                " num_of_child = ?" +
                " WHERE reservation_id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1, reservation.getGuestName());
            pr.setString(2, reservation.getGuestCitizenId());
            pr.setString(3, reservation.getGuestMail());
            pr.setString(4, reservation.getGuestPhone());
            pr.setInt(5, reservation.getNumOfAdult());
            pr.setInt(6, reservation.getNumOfChild());
            pr.setInt(7, reservation.getReservationId());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }


    public boolean delete(int id){
        String query = "DELETE FROM public.reservation WHERE reservation_id = ?";
        try{
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public Reservation match(ResultSet rs) throws SQLException {
        Reservation obj = new Reservation();
        obj.setReservationId(rs.getInt("reservation_id"));
        obj.setReservationRoomId(rs.getInt("reservation_room_id"));
        obj.setCheckInDate(rs.getDate("check_in_date").toLocalDate());
        obj.setCheckOutDate(rs.getDate("check_out_date").toLocalDate());
        obj.setTotalPrice(rs.getInt("total_price"));
        obj.setGuestCount(rs.getInt("guest_count"));
        obj.setGuestName(rs.getString("guest_name"));
        obj.setGuestCitizenId(rs.getString("guest_citizen_id"));
        obj.setGuestMail(rs.getString("guest_mail"));
        obj.setGuestPhone(rs.getString("guest_phone"));
        obj.setNumOfAdult(rs.getInt("num_of_adult"));
        obj.setNumOfChild(rs.getInt("num_of_child"));
        return obj;
    }
}
