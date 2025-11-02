package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.store.LottoGenerator;
import lotto.domain.store.LottoRandomGenerator;
import lotto.domain.store.LottoStore;
import lotto.domain.store.Store;
import lotto.view.ApplicationView;
import lotto.view.InputReader;
import lotto.view.OutputWriter;

public class ApplicationConfig {

    private static final ApplicationConfig INSTANCE = new ApplicationConfig();

    public static ApplicationConfig getInstance() {
        return INSTANCE;
    }

    public LottoController lottoController() {
        return new LottoController(applicationView(), store());
    }

    private Store store() {
        return new LottoStore(lottoGenerator());
    }

    private LottoGenerator lottoGenerator() {
        return new LottoRandomGenerator();
    }

    private ApplicationView applicationView() {
        return new ApplicationView(inputReader(), outputWriter());
    }

    private InputReader inputReader() {
        return new InputReader();
    }

    private OutputWriter outputWriter() {
        return new OutputWriter();
    }


}
