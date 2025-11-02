package lotto.domain.processor;

import lotto.domain.customer.Lotto;
import lotto.domain.customer.Number;

public class WinningLotto {

    private final Lotto normalLotto;
    private final Number bonusNumber;

    private WinningLotto(Lotto normalLotto, Number bonusNumber) {
        // TODO 검증 추가, 일반 번호와 보너스 번호가 중복되는 지 검증
        this.normalLotto = normalLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto normalLotto, Number bonusNumber) {
        return new WinningLotto(normalLotto, bonusNumber);
    }

}
