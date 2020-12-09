package com.zeta.vehicle.service.impl;

import com.zeta.vehicle.dao.IServiceCenterDao;
import com.zeta.vehicle.dto.ServiceCenter;
import com.zeta.vehicle.factory.AppFactory;
import com.zeta.vehicle.partner.IPartner;
import com.zeta.vehicle.partner.Partner1;
import com.zeta.vehicle.partner.Partner2;
import com.zeta.vehicle.partner.Partner3;
import com.zeta.vehicle.service.IPartnerService;
import com.zeta.vehicle.service.IProviderService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nikhil sharma created on 09/12/20
 */
public class ProviderService implements IProviderService {

    private IServiceCenterDao serviceCenterDao = AppFactory.getServiceCenterDao();
    private IPartnerService partnerService;

    public ProviderService() {

        List<IPartner> partners = new ArrayList<>();
        partners.add(new Partner1());
        partners.add(new Partner2());
        partners.add(new Partner3());
        partnerService = new PartnerService(partners);
    }

    @Override
    public List<ServiceCenter> getServiceCenters() {

        List<ServiceCenter> serviceCenterList = new ArrayList<>();

        // fetch its own service centers from database
        List<ServiceCenter> ownedServiceCenters = serviceCenterDao.getOwnedServiceCenters();
        if (ownedServiceCenters != null && !ownedServiceCenters.isEmpty())
            serviceCenterList.addAll(ownedServiceCenters);

        // fetches partner service centers from partner service
        List<ServiceCenter> partnerServiceCenters = partnerService.getPartnerServiceCenters();
        if (partnerServiceCenters != null && !partnerServiceCenters.isEmpty())
            serviceCenterList.addAll(partnerServiceCenters);

        // return result
        return serviceCenterList;
    }

}
