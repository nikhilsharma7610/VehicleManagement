package com.zeta.vehicle.service.impl;

import com.zeta.vehicle.dto.ServiceCenter;
import com.zeta.vehicle.partner.IPartner;
import com.zeta.vehicle.service.IPartnerService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author nikhil sharma created on 09/12/20
 */
public class PartnerService implements IPartnerService {

    private List<IPartner> partners;

    // ideally this will be autowired and all partners will be injected to partner list
    public PartnerService(List<IPartner> partners) {
        this.partners = partners;
    }

    /**
     *  Response will be cached
     *
     *  do some optimization if possible
     *       - partner SC can be cached so that partners are not bombarded with our search requests
     *       - partner SC cache be invalidated every hour
     *
     * @return
     */
    @Override
    public List<ServiceCenter> getPartnerServiceCenters() {

        List<CompletableFuture<List<ServiceCenter>>> futureResponse = new ArrayList<>();
        for (IPartner partner : partners) {

            // basically from here we are calling partner adapter & that will make call to partner
            futureResponse.add( CompletableFuture.supplyAsync( () ->  partner.getServiceCentres()) );
        }

        List<ServiceCenter> aggregatedServiceCentres = new ArrayList<>();
        for (CompletableFuture<List<ServiceCenter>> future : futureResponse) {

            try {
                List<ServiceCenter> partnerSC = future.get(10, TimeUnit.MILLISECONDS);
                if (partnerSC != null && !partnerSC.isEmpty())
                    aggregatedServiceCentres.addAll(partnerSC);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return aggregatedServiceCentres;
    }

}
