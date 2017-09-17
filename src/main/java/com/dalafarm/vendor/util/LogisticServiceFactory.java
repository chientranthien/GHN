package com.dalafarm.vendor.util;

import com.dalafarm.vendor.service.LogisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import static com.dalafarm.vendor.util.VendorId.GHTK;
import static com.dalafarm.vendor.util.VendorId.TIN_LOGISTIC;

/**
 * Created by chien on 8/25/17.
 */
@Component
public class LogisticServiceFactory {

    @Autowired
    ApplicationContext applicationContext;

    public LogisticService getLogisticService(Integer vendorId) {
        if (vendorId == null) {
            vendorId = GHTK;
        }
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
