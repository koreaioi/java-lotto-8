package lotto.domain.store;

import lotto.domain.customer.LottoBundle;

public interface Store {

    LottoBundle sellLotto(int quantity);

}
