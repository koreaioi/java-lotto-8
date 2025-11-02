package lotto.controller;

import lotto.domain.customer.Customer;
import lotto.domain.customer.Money;
import lotto.domain.customer.WinningLotto;
import lotto.domain.store.Store;
import lotto.view.ApplicationView;

public class LottoController {

    private final ApplicationView applicationView;
    private final Store store;

    public LottoController(ApplicationView applicationView, Store store) {
        this.applicationView = applicationView;
        this.store = store;
    }

    public void start() {
        Money money = getMoney();
        Customer customer = Customer.of(money);

        customer.buyLotto(store);
        printLottoBundle(customer);

        WinningLotto winningLotto = getWinningLotto();
        customer.compareMyLottoWithWinningLotto(winningLotto);

        printStatistics(customer);
        printRoi(customer);
    }

    private Money getMoney() {
        return applicationView.getMoney();
    }

    private void printLottoBundle(Customer customer) {
        applicationView.printLottoSet(customer.toLottoQuantity(), customer.toLottoBundleDisplay());
    }

    private WinningLotto getWinningLotto() {
        return applicationView.getWinningLotto();
    }

    private void printStatistics(Customer customer) {
        applicationView.printWinningStatistics(customer.getStatistics());
    }

    private void printRoi(Customer customer) {
        double roi = customer.toRoi();
        applicationView.printLottoRoi(String.valueOf(roi));
    }

}
