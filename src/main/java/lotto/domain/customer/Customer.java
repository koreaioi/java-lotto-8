package lotto.domain.customer;

import lotto.domain.store.LottoStore;
import lotto.domain.store.Store;

public class Customer {

    private final Money money;
    private LottoBundle lottoBundle;

    private Customer(Money money) {
        this.money = money;
    }

    public static Customer of(Money money) {
        return new Customer(money);
    }

    public void buyLotto(Store store) {
        int quantity = money.toLottoQuantity();
        this.lottoBundle = store.sellLotto(quantity);
    }

    public String toDisplay() {
        return lottoBundle.toDisplay();
    }

}
