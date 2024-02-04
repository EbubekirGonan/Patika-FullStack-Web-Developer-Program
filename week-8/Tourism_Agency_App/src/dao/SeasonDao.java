package dao;

import core.Db;
import entity.Season;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SeasonDao {
    private final Connection con;

    public SeasonDao() {
        this.con = Db.getInstance();
    }

    public ArrayList<Season> findSeasonByHotelID(int hotelID){
        ArrayList<Season> seasonList = new ArrayList<>();
        String sql = "SELECT * FROM public.hotel_season WHERE hotel_id = ? ORDER BY season_id ASC";
        try {
            PreparedStatement pr = this.con.prepareStatement(sql);
            pr.setInt(1, hotelID);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                seasonList.add(this.match(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return seasonList;
    }

    public boolean save(Season season){
        String query = "INSERT INTO public.hotel_season (hotel_id, season_strt_date, season_fnsh_date) VALUES (?,?::date,?::date)";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, season.getHotelId());
            pr.setString(2, LocalDate.parse(season.getStrtDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
            pr.setString(3, LocalDate.parse(season.getFnshDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Season match(ResultSet rs) throws SQLException {
        Season obj = new Season();
        obj.setId(rs.getInt("season_id"));
        obj.setHotelId(rs.getInt("hotel_id"));
        obj.setStrtDate(rs.getString("season_strt_date"));
        obj.setFnshDate(rs.getString("season_fnsh_date"));
        return obj;
    }
}
