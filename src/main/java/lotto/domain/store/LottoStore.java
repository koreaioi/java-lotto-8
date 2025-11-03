package lotto.domain.store;

import lotto.domain.customer.Lotto;
import lotto.domain.customer.LottoBundle;

import java.util.List;
import java.util.stream.IntStream;

public class LottoStore implements Store {

    private static final int SALE_ATTEMPT_START = 0;

    private final LottoGenerator lottoGenerator;

    public LottoStore(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    @Override
    public LottoBundle sellLotto(int quantity) {
        List<Lotto> lottoBundle = IntStream.range(SALE_ATTEMPT_START, quantity)
                .mapToObj(i -> lottoGenerator.generateLotto())
                .toList();
        return LottoBundle.from(lottoBundle);
    }

}
