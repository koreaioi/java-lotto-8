package lotto.domain;

import lotto.domain.customer.*;
import lotto.domain.customer.Number;
import lotto.domain.store.LottoStore;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoStoreTest {

    @Test
    void 로또_구매_테스트() {
        Lotto testLotto = Lotto.from(List.of(
                Number.from(1),
                Number.from(2),
                Number.from(3),
                Number.from(4),
                Number.from(5),
                Number.from(6)
        ));

        Customer customer = Customer.from(Money.from(1000));
        LottoTestGenerator lottoTestGenerator = new LottoTestGenerator(List.of(testLotto));
        LottoStore lottoStore = new LottoStore(lottoTestGenerator);
        customer.buyLotto(lottoStore);

        Assertions.assertThat(customer.toLottoBundleDisplay())
                .isEqualTo(testLotto.toDisplay());
    }

}
