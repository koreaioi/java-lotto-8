package lotto.domain.store;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.customer.Lotto;
import lotto.domain.customer.Number;

import java.util.List;

public class LottoGenerator {

    public Lotto generateLotto() {
        List<Number> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .map(Number::from)
                .toList();
        return Lotto.from(numbers);
    }

}
