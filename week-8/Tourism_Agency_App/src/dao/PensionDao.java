package dao;

import core.Db;
import entity.Pension;
import entity.Season;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PensionDao {
    private final Connection con;

    public PensionDao() {
        this.con = Db.getInstance();
    }

    public ArrayList<Pension> findPensionByHotelID(int hotelID){
        ArrayList<Pension> pensionList = new ArrayList<>();
        String sql = "SELECT * FROM public.hotel_pension WHERE pension_hotel_id = ? ORDER BY pension_id ASC";
        try {
            PreparedStatement pr = this.con.prepareStatement(sql);
            pr.setInt(1, hotelID);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                pensionList.add(this.match(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pensionList;
    }
    public Pension match(ResultSet rs) throws SQLException {
        Pension obj = new Pension();
        obj.setPensionId(rs.getInt("pension_id"));
        obj.setPensionHotelId(rs.getInt("pension_hotel_id"));
        obj.setType(Pension.Type.values()[rs.getInt("pension_type")]);
        return obj;
    }



    public boolean save(Pension pension){
        String query = "INSERT INTO public.hotel_pension (pension_hotel_id, pension_type) " +
                "VALUES (?,?)";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, pension.getPensionHotelId());
            pr.setString(2, String.valueOf(pension.getType().ordinal()));
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
