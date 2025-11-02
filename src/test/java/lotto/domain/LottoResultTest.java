package lotto.domain;

import lotto.domain.processor.LottoRank;
import lotto.domain.processor.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoResultTest {

    @Test
    void 로또당첨_수익금을_테스트한다() {
        LottoResult testLottoResult = LottoResult.from(List.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.SECOND));
        long testProfits = testLottoResult.calculateTotalProfits();

        Assertions.assertThat(testProfits)
                .isEqualTo(
                        LottoRank.FIRST.totalPrizeMoney(1) +
                                LottoRank.SECOND.totalPrizeMoney(2)
                );
    }

}
