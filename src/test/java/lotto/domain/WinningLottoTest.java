package lotto.domain;

import lotto.domain.customer.Lotto;
import lotto.domain.customer.Number;
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

}
