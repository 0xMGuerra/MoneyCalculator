package software.ulpgc.moneycalculator.model;

import java.math.BigDecimal;

public record Money(BigDecimal amount, Currency currency) {
    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
