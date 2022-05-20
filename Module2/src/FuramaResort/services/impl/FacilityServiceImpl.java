package FuramaResort.services.impl;

import FuramaResort.models.Facility.Facility;
import FuramaResort.services.FacilityService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityServiceImpl implements FacilityService {
    private static Map<Integer,Facility> FacilityList = new LinkedHashMap<>();


    @Override
    public List findAll() {
        return null;
    }

    @Override
    public void add(Object o) {

    }

    @Override
    public void add(Facility facility) {
        FacilityList.put(1,facility);
    }

    @Override
    public void edit(Object o) {

    }
}
