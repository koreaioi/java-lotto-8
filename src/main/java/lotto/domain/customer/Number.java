package lotto.domain.customer;

import lotto.exception.number.NumberIsNotLottoRangeException;

public class Number {

    private static final int LOTTO_RANGE_MIN = 1;
    private static final int LOTTO_RANGE_MAX = 45;

    private final int symbol;

    private Number(int number) {
        validateLottoRange(number);
        this.symbol = number;
    }

    public static Number from(int number) {
        return new Number(number);
    }

    private void validateLottoRange(int number) {
        if (number < LOTTO_RANGE_MIN || number > LOTTO_RANGE_MAX) {
            throw new NumberIsNotLottoRangeException();
        }
    }

    public String toDisplay() {
        return String.valueOf(symbol);
    }

}
