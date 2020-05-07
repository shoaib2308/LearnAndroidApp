package simplycodinghub.learnandroidapp.AbstractMethodUsage;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Order {

    /**
     * GOOD WAY TO ABSTRACT
     * cancel() is common for all so we maked final so it cannot be override
     */
    private long id;
    private LocalDate createdOn;
    private BigDecimal amount;

    public abstract void validate();
    public abstract void process();

    public final void cancel() {
        // universal code for order cancellations
    }


}
