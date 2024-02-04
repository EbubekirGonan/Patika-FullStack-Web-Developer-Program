package business;

import core.Helper;
import dao.HotelDao;
import entity.Hotel;
import entity.User;

import java.util.ArrayList;

public class HotelManager {
    private final HotelDao hotelDao;

    public HotelManager() {
        this.hotelDao = new HotelDao();
    }

    public Hotel getById(int id){
        return this.hotelDao.getById(id);
    }

    public ArrayList<Object[]> getForTable (int size, ArrayList<Hotel> hotelList){
        ArrayList<Object[]> hotelRowList = new ArrayList<>();
        for(Hotel hotel: hotelList){
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = hotel.getId();
            rowObject[i++] = hotel.getName();
            rowObject[i++] = hotel.getAddres();
            rowObject[i++] = hotel.getEmail();
            rowObject[i++] = hotel.getPhone();
            rowObject[i++] = hotel.getStar();

            hotelRowList.add(rowObject);
        }
        return hotelRowList;
    }
    public ArrayList<Hotel> findAll(){
        return this.hotelDao.findAll();
    }
    public boolean save(Hotel hotel){
        if(hotel.getId() != 0){
            Helper.showMsg("error");
        }
        return this.hotelDao.save(hotel);
    }
    public boolean update (Hotel hotel){
        return this.hotelDao.update(hotel);
    }
    public boolean delete (int id) {
        return this.hotelDao.delete(id);
    }
}
