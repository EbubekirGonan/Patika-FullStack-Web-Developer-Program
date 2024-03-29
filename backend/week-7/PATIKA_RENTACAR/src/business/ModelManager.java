package business;

import core.Helper;
import dao.ModelDao;
import entity.Model;

import java.util.ArrayList;

public class ModelManager {
    private final ModelDao modelDao = new ModelDao();

    public ArrayList<Object[]> getForTable(int size, ArrayList<Model> modelList) {
        ArrayList<Object[]> modelObjList = new ArrayList<>();
        for (Model obj : modelList) {
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getBrand().getName();
            rowObject[i++] = obj.getName();
            rowObject[i++] = obj.getType();
            rowObject[i++] = obj.getYear();
            rowObject[i++] = obj.getFuel();
            rowObject[i++] = obj.getGear();
            modelObjList.add(rowObject);
        }
        return modelObjList;
    }

    public ArrayList<Model> findAll() {
        return this.modelDao.findAll();
    }

    public Model getById(int id) {
        return this.modelDao.getById(id);
    }

    public boolean save(Model model) {
        if (model.getId() != 0) {
            Helper.showMsg("error");
        }
        return this.modelDao.save(model);
    }

    public boolean update(Model model) {
        if (this.getById(model.getId()) == null) {
            Helper.showMsg("notFound");
        }
        return this.modelDao.update(model);
    }

    public boolean delete(int id) {
        if (this.getById(id) == null) {
            Helper.showMsg(id + "Kayıtlı id bulunamadı.");
            return false;
        }
        return this.modelDao.delete(id);
    }

    public ArrayList<Model> getByListBrandId(int brandId) {
        return this.modelDao.getByListBrandId(brandId);
    }

    public ArrayList<Model> searchForTable(int brandId, Model.Fuel fuel, Model.Gear gear, Model.Type type) {
        String select = "SELECT * FROM public.model";
        ArrayList<String> whereList = new ArrayList<>();
        if (brandId != 0) {
            whereList.add("model_brand_id = " + brandId);
        }
        if(fuel != null){
            whereList.add("model_fuel = '" + fuel.toString() + "'");
        }
        if(gear != null){
            whereList.add("model_gear = '" + gear.toString() + "'");
        }
        if(type != null){
            whereList.add("model_type = '" + type.toString() + "'");
        }
        String wherestr = String.join(" AND ", whereList);
        String query = select;
        if(wherestr.length() > 0){
            query += " WHERE " + wherestr;
        }
        return this.modelDao.selectByQuery(query);
    }

}
