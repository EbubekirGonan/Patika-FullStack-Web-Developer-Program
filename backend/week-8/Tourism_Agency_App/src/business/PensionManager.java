package business;

import dao.PensionDao;
import dao.SeasonDao;
import entity.Hotel;
import entity.Pension;
import entity.Season;

import java.util.ArrayList;

public class PensionManager {
    private final PensionDao pensionDao;

    public PensionManager() {
        this.pensionDao = new PensionDao();
    }
    public ArrayList<Pension> findPensionByHotelID (int hotelId){
        return this.pensionDao.findPensionByHotelID(hotelId);
    }
    public ArrayList<Object[]> getForTable (int hotelId){

        ArrayList<Object[]> pensionRowList = new ArrayList<>();
        for(Pension pension: this.findPensionByHotelID(hotelId)){
            Object[] rowObject = {pension.getPensionId(), pension.getPensionHotelId(), pension.getType()};
            pensionRowList.add(rowObject);
        }
        return pensionRowList;
    }

    public boolean save (Pension pension) {
        return this.pensionDao.save(pension);
    }

}
