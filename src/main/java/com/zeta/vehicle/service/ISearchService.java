package com.zeta.vehicle.service;


import com.zeta.vehicle.dto.ServiceCenter;
import com.zeta.vehicle.exception.ServiceCenterException;

import java.time.LocalDate;
import java.util.List;

/**
 * @author nikhil sharma created on 09/12/20
 */
public interface ISearchService {

    List<ServiceCenter> searchByLocation(String location) throws ServiceCenterException;

    List<ServiceCenter> searchBySlotsInDay(LocalDate date, int to, int from) throws ServiceCenterException;

}
