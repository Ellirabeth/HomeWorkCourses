package by.info.service;

import by.info.bean.City;
import by.info.dao.ICityDao;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class CityService implements ICityService {

    @Inject
    private ICityDao cityDao;

    @Override
    public List<City> getCities() {

        return cityDao.findAll();
    }
}