package lotto.domain.customer;

import lotto.domain.store.Store;

import java.util.List;
import java.util.Map;

public class Customer {

    private final Money money;
    private LottoBundle lottoBundle;
    private LottoResult lottoResult;

    private Customer(Money money) {
        this.money = money;
    }

    public static Customer from(Money money) {
        return new Customer(money);
    }

    public void buyLotto(Store store) {
        int quantity = money.toLottoQuantity();
        this.lottoBundle = store.sellLotto(quantity);
    }

    public void compareMyLottoWithWinningLotto(WinningLotto winningLotto) {
        List<LottoRank> lottoRanks = lottoBundle.compareAll(winningLotto);
        this.lottoResult = LottoResult.from(lottoRanks);
    }

    public double toRoi() {
        long totalProfits = lottoResult.calculateTotalProfits();
        return money.toRoi(totalProfits);
    }

    public Map<LottoRank, Integer> getStatistics() {
        return lottoResult.getStatistics();
    }

    public String toLottoQuantity() {
        return String.valueOf(money.toLottoQuantity());
    }

    public String toLottoBundleDisplay() {
        return lottoBundle.toDisplay();
    }

}
