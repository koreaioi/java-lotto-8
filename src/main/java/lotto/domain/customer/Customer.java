package lotto.domain.customer;

import lotto.domain.processor.LottoRank;
import lotto.domain.processor.WinningLotto;
import lotto.domain.store.Store;

import java.util.List;

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

    public void compareMyLottoWithWinningLotto(WinningLotto winningLotto) {
        List<LottoRank> lottoRanks = lottoBundle.compareAll(winningLotto);
        // LottoResult 
    }

    public String toDisplay() {
        return lottoBundle.toDisplay();
    }

}
