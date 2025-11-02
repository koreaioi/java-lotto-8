package lotto.domain.processor;

import lotto.domain.customer.Lotto;
import lotto.domain.customer.Number;

public class WinningLotto {

    private final Lotto normalLotto;
    private final Number bonusNumber;

    private WinningLotto(Lotto normalLotto, Number bonusNumber) {
        validateDuplicatedBonusNumber(normalLotto, bonusNumber);
        this.normalLotto = normalLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto normalLotto, Number bonusNumber) {
        return new WinningLotto(normalLotto, bonusNumber);
    }

    private void validateDuplicatedBonusNumber(Lotto normalLotto, Number bonusNumber) {
        normalLotto.validateDuplicatedBonusNumber(bonusNumber);
    }

}
