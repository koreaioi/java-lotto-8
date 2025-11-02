package lotto.domain.customer;

public class Customer {

    private final Money money;
    private LottoBundle lottoBundle;

    private Customer(Money money) {
        this.money = money;
    }

    public static Customer of(Money money) {
        return new Customer(money);
    }

}
