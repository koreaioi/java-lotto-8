package lotto.controller;

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
    }

}
