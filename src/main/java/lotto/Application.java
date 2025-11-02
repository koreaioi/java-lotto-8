package lotto;

import lotto.config.ApplicationConfig;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig = ApplicationConfig.getInstance();
        LottoController lottoController = applicationConfig.lottoController();
        lottoController.start();
    }
}
