package lotto.domain.customer;

public class WinningLotto {

    private final Lotto normalNumbers;
    private final Number bonusNumber;

    private WinningLotto(Lotto normalNumbers, Number bonusNumber) {
        validateDuplicatedBonusNumber(normalNumbers, bonusNumber);
        this.normalNumbers = normalNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto normalNumbers, Number bonusNumber) {
        return new WinningLotto(normalNumbers, bonusNumber);
    }

    private void validateDuplicatedBonusNumber(Lotto normalNumbers, Number bonusNumber) {
        normalNumbers.validateDuplicatedBonusNumber(bonusNumber);
    }

    public LottoRank determineRank(Lotto userLotto) {
        int normalCount = userLotto.countMatchingWinningLotto(normalNumbers);
        boolean hasBonus = userLotto.contains(bonusNumber);
        return LottoRank.valueOf(normalCount, hasBonus);
    }

}
