package lotto.controller;

import lotto.domain.customer.Customer;
import lotto.domain.customer.Money;
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
        printLottoSet(customer);

    }

    private Money getMoney() {
        return applicationView.getMoney();
    }

    private void printLottoSet(Customer customer) {
        applicationView.printLottoSet(customer.toLottoQuantity(), customer.toLottoBundleDisplay());
    }

}
