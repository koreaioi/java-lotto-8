package lotto.domain.customer;

import lotto.exception.number.NumberIsNotLottoRangeException;

public class Number {

    private final int symbol;

    private Number(int number) {
        validateLottoRange(number);
        this.symbol = number;
    }

    public static Number from(int number) {
        return new Number(number);
    }

    private void validateLottoRange(int number) {
        if (number < 1 || number > 45) {
            throw new NumberIsNotLottoRangeException();
        }
    }

}
