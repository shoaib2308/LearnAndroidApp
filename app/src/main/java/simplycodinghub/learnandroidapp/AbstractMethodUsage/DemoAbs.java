package simplycodinghub.learnandroidapp.AbstractMethodUsage;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DemoAbs {

    /**
     * Date 07-05-2020 By shoaib Ahmed
     * Ex:- Understanding How Abstract class usage and working
     *  Single Concrete Class which will become difficult for two reason
     *  1. Some of our class fields don't make sense for certain orders (an online order doesn't need a store ID or store rep)
     *  2. The validate() and process() methods need to check the order type before executing any business logic.
     **** IF NEED TO UPADTE FOR type THEN NEED TO UPDATE THIS CONCRETE CLASS THATS MAKE DIFFICULT ****
     */
    public enum OrderType {
        ONLINE, STORE, WAREHOUSE;
    }

    private long id;
    private long storeId;
    //private Employee storeRep;
    private long warehouseId;
    private LocalDate createdOn;
    private BigDecimal amount;
    private OrderType type;
    //private List<Product> products;

    public void validate() {
        if (type == OrderType.STORE) {
            // code for store order validation
        } else if (type == OrderType.WAREHOUSE) {
            // code for warehouse order validation
        } else if (type == OrderType.ONLINE) {
            // code for online order validation
        }
    }

    public void process() {
        if (type == OrderType.STORE) {
            // code for store order validation
        } else if (type == OrderType.WAREHOUSE) {
            // code for warehouse order validation
        } else if (type == OrderType.ONLINE) {
            // code for online order validation
        }
    }

    public void cancel() {
        // universal code for order cancellations
    }


}
