package com.dalafarm.vendor.model;

/**
 * Created by chien on 8/13/17.
 */
public enum TinLogisticGroup {

    HCM {
        @Override
        public int calculateServiceFee(int weight) {
            return 20000;
        }
    },
    A {
        @Override
        public int calculateServiceFee(int weight) {

            if (weight <= 300)
                return 30000;
            else if (weight <= 500)
                return 40000;
            else if (weight <= 1000)
                return 50000;
            else if (weight <= 1500)
                return 65000;
            else if (weight <= 2000)
                return 75000;
            else return addShippingCostAtExceedPrice(weight, 75000);
        }
    }, B {
        @Override
        public int calculateServiceFee(int weight) {

            if (weight <= 300)
                return 35000;
            else if (weight <= 500)
                return 45000;
            else if (weight <= 1000)
                return 55000;
            else if (weight <= 1500)
                return 70000;
            else if (weight <= 2000)
                return 80000;
            else return addShippingCostAtExceedPrice(weight, 80000);
        }
    }, C {
        @Override
        public int calculateServiceFee(int weight) {

            return B.calculateServiceFee(weight);
        }
    }, D {
        @Override
        public int calculateServiceFee(int weight) {

            if (weight <= 300)
                return 35000;
            else if (weight <= 500)
                return 45000;
            else if (weight <= 1000)
                return 60000;
            else if (weight <= 1500)
                return 75000;
            else if (weight <= 2000)
                return 85000;
            else return addShippingCostAtExceedPrice(weight, 85000);
        }
    }, E {
        @Override
        public int calculateServiceFee(int weight) {
            return D.calculateServiceFee(weight);
        }
    }, OTHERS {
        @Override
        public int calculateServiceFee(int weight) {

            if (weight <= 300)
                return 40000;
            else if (weight <= 500)
                return 50000;
            else if (weight <= 1000)
                return 65000;
            else if (weight <= 1500)
                return 80000;
            else if (weight <= 2000)
                return 85000;
            else return addShippingCostAtExceedPrice(weight, 85000);
        }
    };

    /**
     * @param weight in gram
     */
    public abstract int calculateServiceFee(int weight);

    /**
     * @param weight                in gram
     * @param lowerTierShippingCost
     * @return
     */
    public int addShippingCostAtExceedPrice(int weight, int lowerTierShippingCost) {
        if (weight > 2000) {
            int exceedWeight = weight - 2000;
            int nextTierPriceAddition = 10000;
            int shippingCost = (int) (lowerTierShippingCost + (Math.ceil(exceedWeight / 500) * nextTierPriceAddition));
            return shippingCost;
        }
        return lowerTierShippingCost;
    }
}

