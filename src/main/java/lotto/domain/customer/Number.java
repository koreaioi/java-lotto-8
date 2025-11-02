package lotto.domain.customer;

public class Number {

    private final int symbol;

    private Number(int symbol) {
        // TODO(should) 검증 추가
        this.symbol = symbol;
    }

    public static Number from(int symbol) {
        return new Number(symbol);
    }

}
