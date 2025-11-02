package lotto.domain.customer;

import java.util.List;

public class LottoBundle {

    private final List<Lotto> lottoBundle;

    private LottoBundle(List<Lotto> lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public static LottoBundle from(List<Lotto> lottoBundle) {
        return new LottoBundle(lottoBundle);
    }

}
