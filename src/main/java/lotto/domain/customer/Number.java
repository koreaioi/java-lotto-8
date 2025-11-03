package lotto.domain.customer;

import lotto.exception.number.NumberIsNotLottoRangeException;

import java.util.Objects;

public class Number implements Comparable<Number>{

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final int symbol;

    private Number(int number) {
        validateLottoRange(number);
        this.symbol = number;
    }

    public static Number from(int number) {
        return new Number(number);
    }

    private void validateLottoRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new NumberIsNotLottoRangeException();
        }
    }

    public String toDisplay() {
        return String.valueOf(symbol);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return symbol == ((Number) other).symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol);
    }

    @Override
    public int compareTo(Number number) {
        return symbol - number.symbol;
    }

}
