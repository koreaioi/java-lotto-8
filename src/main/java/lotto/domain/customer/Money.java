package lotto.domain.customer;

import lotto.exception.MoneyIsNegativeException;
import lotto.exception.MoneyIsNotThousandUnitException;
import lotto.exception.MoneyIsZeroException;

public class Money {

    private static final int LOTTO_PRICE_UNIT = 1000;

    private final int symbol;

    private Money(int money) {
        validate(money);
        this.symbol = money;
    }

    public static Money from(int money) {
        return new Money(money);
    }

    private void validate(int money) {
        validateZero(money);
        validateNegative(money);
        validateMoneyUnit(money);
    }

    private void validateZero(int money) {
        if (money == 0) {
            throw new MoneyIsZeroException();
        }
    }

    private void validateNegative(int money) {
        if (money < 0) {
            throw new MoneyIsNegativeException();
        }
    }

    private void validateMoneyUnit(int money) {
        if (money % LOTTO_PRICE_UNIT != 0) {
            throw new MoneyIsNotThousandUnitException();
        }
    }

}
