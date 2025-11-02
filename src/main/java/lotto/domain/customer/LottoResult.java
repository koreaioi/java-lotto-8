package lotto.domain.customer;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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
        for (LottoRank rank : LottoRank.values()) {
            statistics.put(rank, 0);
        }

        for (LottoRank rank : rankResult) {
            statistics.put(rank, statistics.get(rank) + 1);
        }

        return statistics;
    }

    public long calculateTotalProfits() {
        return winningStatistics.entrySet().stream()
                .mapToLong(e -> e.getKey().totalPrizeMoney(e.getValue()))
                .sum();
    }

    public Map<LottoRank, Integer> getStatistics() {
        return Collections.unmodifiableMap(winningStatistics);
    }

}
