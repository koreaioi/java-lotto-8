package lotto.domain.customer;

import lotto.exception.MoneyIsNegativeException;
import lotto.exception.MoneyIsZeroException;

public class Money {

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


}
