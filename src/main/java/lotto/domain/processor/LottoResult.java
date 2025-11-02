package lotto.domain.processor;

import java.util.EnumMap;
import java.util.List;

public class LottoResult {

    EnumMap<LottoRank, Integer> winningStatistics;

    private LottoResult(List<LottoRank> rankResult) {
        winningStatistics = doStatistics(rankResult);
    }

    public static LottoResult from(List<LottoRank> rankResult) {
        return new LottoResult(rankResult);
    }

    private EnumMap<LottoRank, Integer> doStatistics(List<LottoRank> rankResult) {
        EnumMap<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : rankResult) {
            statistics.put(rank, statistics.get(rank) + 1);
        }
        return statistics;
    }

}
