package dao;

import core.Db;
import entity.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    public final Connection con;

    public UserDao() {
        this.con = Db.getInstance();
    }

    //Değerlendirme formu 1
    public ArrayList<User> findUserByRole (User.UserRole role){
        ArrayList<User> filteredUserList = new ArrayList<>();
        //int roleOrdinal = role.ordinal();
        String query = "SELECT * FROM public.user WHERE user_role = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1, String.valueOf(role.ordinal()));
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                filteredUserList.add(this.match(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filteredUserList;
    }


    public User getById (int id){
        User obj = null;
        String query = "SELECT * FROM public.user WHERE user_id = ?";
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

    public ArrayList<User> findAll(){
        ArrayList<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM public.user ORDER BY user_id ASC";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while(rs.next()){
                userList.add(this.match(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public User findByLogin(String username, String password){
        User obj = null;
        String query = "SELECT * FROM public.user WHERE user_name = ? AND user_password = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1, username);
            pr.setString(2, password);
            ResultSet rs  = pr.executeQuery();
            if (rs.next()){
                obj = this.match(rs);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }return obj;
    }





    public boolean save(User user){
        String query = "INSERT INTO public.user (user_name, user_password, user_role) VALUES (?,?,?)";
        try {
            PreparedStatement pr = initUserPreparedStatement(query, user);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean update(User user){
        String query = "UPDATE public.user SET user_name = ?, " +
                "user_password = ?, " +
                "user_role = ? " +
                " WHERE user_id = ?";
        try {
            PreparedStatement pr = initUserPreparedStatement(query, user);
            pr.setInt(4, user.getId());
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    private PreparedStatement initUserPreparedStatement(String query, User user) throws SQLException {
        PreparedStatement pr = this.con.prepareStatement(query);
        pr.setString(1, user.getUsername());
        pr.setString(2, user.getPassword());
        pr.setString(3, String.valueOf(user.getRole().ordinal()));
        return pr;
    }

    public boolean delete(int id){
        String query = "DELETE FROM public.user WHERE user_id = ?";
        try{
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }


    public User match(ResultSet rs) throws SQLException {
        User obj = new User();
        obj.setId(rs.getInt("user_id"));
        obj.setUsername(rs.getString("user_name"));
        obj.setPassword(rs.getString("user_password"));
        obj.setRole(User.UserRole.values()[rs.getInt("user_role")]);
        return obj;
    }
}

