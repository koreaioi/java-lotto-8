package lotto.domain;

import lotto.domain.customer.Lotto;
import lotto.domain.customer.Number;
import lotto.domain.customer.LottoRank;
import lotto.domain.customer.WinningLotto;
import lotto.exception.lotto.BonusNumberIsDuplicatedException;
import lotto.exception.lotto.NormalNumberIsDuplicatedException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningLottoTest {

    private static final int BONUS = 7;
    private static final int NOT_MATCH_8 = 8;
    private static final int NOT_MATCH_9 = 9;
    private static final int NOT_MATCH_10 = 10;

    @Test
    void 당첨번호에_중복이존재하면_예외가_발생한다() {
        List<Number> duplicatedNumbers = getTestLottoNumbers(List.of(1, 2, 3, 4, 5, 5));

        Assertions.assertThatThrownBy(() -> Lotto.from(duplicatedNumbers))
                .isInstanceOf(NormalNumberIsDuplicatedException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        List<Number> numbers = getTestLottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = Lotto.from(numbers);
        Number duplicatedBonusNumber = Number.from(6);

        Assertions.assertThatThrownBy(() -> WinningLotto.of(lotto, duplicatedBonusNumber))
                .isInstanceOf(BonusNumberIsDuplicatedException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또당첨순위를_테스트한다() {
        Lotto testLotto = Lotto.from(getTestLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        Number bonusNumber = Number.from(BONUS);
        WinningLotto winningLotto = WinningLotto.of(testLotto, bonusNumber);

        Lotto firstLotto = Lotto.from(getTestLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        Lotto secondLotto = Lotto.from(getTestLottoNumbers(List.of(1, 2, 3, 4, 5, BONUS)));
        Lotto thirdLotto = Lotto.from(getTestLottoNumbers(List.of(1, 2, 3, 4, 5, NOT_MATCH_8)));
        Lotto fourthLotto = Lotto.from(getTestLottoNumbers(List.of(1, 2, 3, 4, NOT_MATCH_9, NOT_MATCH_8)));
        Lotto fifthLotto = Lotto.from(getTestLottoNumbers(List.of(1, 2, 3, NOT_MATCH_10, NOT_MATCH_9, NOT_MATCH_8)));

        Assertions.assertThat(winningLotto.determineRank(firstLotto))
                .isEqualTo(LottoRank.FIRST);
        Assertions.assertThat(winningLotto.determineRank(secondLotto))
                .isEqualTo(LottoRank.SECOND);
        Assertions.assertThat(winningLotto.determineRank(thirdLotto))
                .isEqualTo(LottoRank.THIRD);
        Assertions.assertThat(winningLotto.determineRank(fourthLotto))
                .isEqualTo(LottoRank.FOURTH);
        Assertions.assertThat(winningLotto.determineRank(fifthLotto))
                .isEqualTo(LottoRank.FIFTH);
    }

    private List<Number> getTestLottoNumbers(List<Integer> numbers) {
         return numbers.stream()
                .map(Number::from)
                .toList();
    }

}
