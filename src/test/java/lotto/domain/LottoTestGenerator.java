package lotto.domain;

import lotto.domain.customer.Lotto;
import lotto.domain.store.LottoGenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LottoTestGenerator implements LottoGenerator {

    private Queue<Lotto> testLottos;

    public LottoTestGenerator(List<Lotto> testLottos) {
        this.testLottos = new LinkedList<>(testLottos);
    }

    @Override
    public Lotto generateLotto() {
        return testLottos.poll();
    }

}
