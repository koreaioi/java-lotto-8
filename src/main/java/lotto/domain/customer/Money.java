package lotto.domain.customer;

public class Money {

    private final int symbol;

    private Money(int money) {
        this.symbol = money;
    }

    public static Money from(int money) {
        return new Money(money);
    }

}
