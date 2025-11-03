package lotto.domain.customer;

import lotto.exception.money.MoneyIsNegativeException;
import lotto.exception.money.MoneyIsNotThousandUnitException;
import lotto.exception.money.MoneyIsZeroException;

public class Money {

    private static final int LOTTO_PRICE_UNIT = 1000;
    private static final int ZERO_CHECK = 0;
    private static final int NEGATIVE_BOUNDARY = 0;
    private static final int NO_REMAINDER = 0;
    private static final double PERCENTAGE = 100.0;
    private static final double TWO_DECIMAL_SCALE = 100.0;


    private final int symbol;

    private Money(int money) {
        validate(money);
        this.symbol = money;
    }

    public static Money from(int money) {
        return new Money(money);
    }

    public int toLottoQuantity() {
        return symbol / LOTTO_PRICE_UNIT;
    }

    public double toRoi(long totalProfits) {
        double roi = ((double) totalProfits / (double) symbol) * PERCENTAGE;
        return Math.round(roi * TWO_DECIMAL_SCALE) / TWO_DECIMAL_SCALE;
    }

    private void validate(int money) {
        validateZero(money);
        validateNegative(money);
        validateMoneyUnit(money);
    }

    private void validateZero(int money) {
        if (money == ZERO_CHECK) {
            throw new MoneyIsZeroException();
        }
    }

    private void validateNegative(int money) {
        if (money < NEGATIVE_BOUNDARY) {
            throw new MoneyIsNegativeException();
        }
    }

    private void validateMoneyUnit(int money) {
        if (money % LOTTO_PRICE_UNIT != NO_REMAINDER) {
            throw new MoneyIsNotThousandUnitException();
        }
    }

}
