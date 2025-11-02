package lotto.domain.processor;

import lotto.domain.customer.Lotto;
import lotto.domain.customer.Number;

public class WinningLotto {

    private final Lotto winningLotto;
    private final Number bonusNumber;

    private WinningLotto(Lotto winningLotto, Number bonusNumber) {
        validateDuplicatedBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningLotto, Number bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private void validateDuplicatedBonusNumber(Lotto winningLotto, Number bonusNumber) {
        winningLotto.validateDuplicatedBonusNumber(bonusNumber);
    }

    public LottoRank determineRank(Lotto userLotto) {
        int normalCount = userLotto.countMatchingWinningLotto(winningLotto);
        boolean hasBonus = userLotto.contains(bonusNumber);
        return LottoRank.valueOf(normalCount, hasBonus);
    }

}
