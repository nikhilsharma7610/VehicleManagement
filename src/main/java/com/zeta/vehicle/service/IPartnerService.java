package com.zeta.vehicle.service;

import com.zeta.vehicle.dto.ServiceCenter;

import java.util.List;

/**
 * @author nikhil sharma created on 09/12/20
 */
public interface IPartnerService {

    List<ServiceCenter> getPartnerServiceCenters();

}
