package lotto.domain.customer;

import lotto.domain.store.LottoStore;

public class Customer {

    private final Money money;
    private LottoBundle lottoBundle;

    private Customer(Money money) {
        this.money = money;
    }

    public static Customer of(Money money) {
        return new Customer(money);
    }

    public void buyLotto(LottoStore store) {
        int quantity = money.toLottoQuantity();
        this.lottoBundle = store.sellLotto(quantity);
    }

}
