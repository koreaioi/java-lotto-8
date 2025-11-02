package lotto.domain;

import lotto.domain.customer.Lotto;
import lotto.domain.customer.Number;
import lotto.domain.processor.WinningLotto;
import lotto.exception.number.BonusNumberIsDuplicatedException;
import lotto.exception.number.NormalNumberIsDuplicatedException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningLottoTest {

    @Test
    void 당첨번호에_중복이존재하면_예외가_발생한다() {
        List<Number> duplicatedNumbers = List.of(
                Number.from(1),
                Number.from(2),
                Number.from(3),
                Number.from(4),
                Number.from(5),
                Number.from(5)
        );

        Assertions.assertThatThrownBy(() -> Lotto.from(duplicatedNumbers))
                .isInstanceOf(NormalNumberIsDuplicatedException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        List<Number> numbers = List.of(
                Number.from(1),
                Number.from(2),
                Number.from(3),
                Number.from(4),
                Number.from(5),
                Number.from(6)
        );
        Lotto lotto = Lotto.from(numbers);
        Number duplicatedBonusNumber = Number.from(6);

        Assertions.assertThatThrownBy(() -> WinningLotto.of(lotto, duplicatedBonusNumber))
                .isInstanceOf(BonusNumberIsDuplicatedException.class)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
