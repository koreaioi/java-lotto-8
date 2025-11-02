package lotto.domain.customer;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBundle {

    private final List<Lotto> lottoBundle;

    private LottoBundle(List<Lotto> lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public static LottoBundle from(List<Lotto> lottoBundle) {
        return new LottoBundle(lottoBundle);
    }

    public String toDisplay() {
        return lottoBundle.stream()
                .map(Lotto::toDisplay)
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
