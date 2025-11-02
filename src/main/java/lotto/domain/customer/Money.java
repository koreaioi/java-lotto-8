package lotto.domain.customer;

import lotto.exception.money.MoneyIsNegativeException;
import lotto.exception.money.MoneyIsNotThousandUnitException;
import lotto.exception.money.MoneyIsZeroException;

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

    public int toLottoQuantity() {
        // TODO(Think) 구입 금액도 구매처로부터 먼저 받아야하는 거 아닐까?
        return symbol / LOTTO_PRICE_UNIT;
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
