package com.dalafarm.vendor.util;

import com.dalafarm.vendor.model.*;
import com.dalafarm.vendor.service.LogisticService;
import com.dalafarm.vendor.service.impl.GhtkService;
import com.dalafarm.vendor.service.impl.TinLogisticService;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import static com.dalafarm.vendor.util.VendorId.*;

/**
 * Created by chien on 8/25/17.
 */
@Component
public class LogisticServiceFactory {

    @Autowired
    ApplicationContext applicationContext;

    public LogisticService getLogisticService(int vendorId) {
        switch (vendorId) {
            case TIN_LOGISTIC:

                return (LogisticService) applicationContext.getBean("tinLogisticService");
            case GHTK:
            default:
                return (LogisticService) applicationContext.getBean("ghtkService");
        }
    }

    public LogisticService getDefaultLogisticService(){
        return getLogisticService(VendorId.GHTK);
    }
}
