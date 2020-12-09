package com.zeta.vehicle.factory;


import com.zeta.vehicle.dao.IServiceCenterDao;
import com.zeta.vehicle.dao.impl.ServiceCenterDao;

/**
 * @author nikhil sharma created on 09/12/20
 *
 * Description : This class will return object which are required common accross service
 */
public class AppFactory {

    private static IServiceCenterDao SERVICE_CENTER_DAO = new ServiceCenterDao();

    public static IServiceCenterDao getServiceCenterDao() {
        return SERVICE_CENTER_DAO;
    }

}
