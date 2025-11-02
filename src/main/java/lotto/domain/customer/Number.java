package lotto.domain.customer;

import lotto.exception.number.NumberIsZeroException;

public class Number {

    private final int symbol;

    private Number(int number) {
        validate(number);
        this.symbol = number;
    }

    public static Number from(int number) {
        return new Number(number);
    }

    private void validate(int number) {
        // TODO(should) 검증 추가하기
        validateZero(number);
    }

    private void validateZero(int number) {
        if (number == 0) {
            throw new NumberIsZeroException();
        }
    }

}
