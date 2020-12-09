package com.zeta.vehicle.dao;


import com.zeta.vehicle.dto.ServiceCenter;

import java.util.List;

/**
 * @author nikhil sharma created on 09/12/20
 */
public interface IServiceCenterDao {

    List<ServiceCenter> getOwnedServiceCenters();

    ServiceCenter getById(String id);
}
