package business;

import dao.SeasonDao;
import entity.Pension;
import entity.Season;

import java.util.ArrayList;

public class SeasonManager {
    private final SeasonDao seasonDao;

    public SeasonManager() {
        this.seasonDao = new SeasonDao();
    }
    public ArrayList<Season> findSeasonByHotelID (int hotelId){
        return this.seasonDao.findSeasonByHotelID(hotelId);
    }

    public boolean save (Season season) {
        return this.seasonDao.save(season);
    }

    public ArrayList<Object[]> getForTable (int hotelId){

        ArrayList<Object[]> seasonRowList = new ArrayList<>();
        for(Season season: this.findSeasonByHotelID(hotelId)){
            Object[] rowObject = {season.getId(), season.getHotelId(), season.getStrtDate(), season.getFnshDate()};
            seasonRowList.add(rowObject);
        }
        return seasonRowList;
    }

}
