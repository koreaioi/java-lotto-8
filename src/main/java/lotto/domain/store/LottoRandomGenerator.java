package lotto.domain.store;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.customer.Lotto;
import lotto.domain.customer.Number;

import java.util.List;

public class LottoRandomGenerator implements LottoGenerator {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    @Override
    public Lotto generateLotto() {
        List<Number> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_COUNT)
                .stream()
                .map(Number::from)
                .toList();
        return Lotto.from(numbers);
    }

}
