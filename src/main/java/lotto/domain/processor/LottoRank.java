package lotto.domain.processor;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000L, false),
    SECOND(5, 30_000_000L, true),
    THIRD(5, 1_500_000L, false),
    FOURTH(4, 50_000L, false),
    FIFTH(3, 5_000L, false),
    MISS(0,0,false);
    ;

    private final int normalCount;
    private final long prizeMoney;
    private final boolean bonus;

    LottoRank(int normalCount, long prizeMoney, boolean bonus) {
        this.normalCount = normalCount;
        this.prizeMoney = prizeMoney;
        this.bonus = bonus;
    }

    public long totalPrizeMoney(int quantity) {
        return this.prizeMoney * quantity;
    }

    static LottoRank valueOf(int normalCount, boolean bonus) {
        if (!bonus && normalCount == 5) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.normalCount == normalCount)
                .findFirst()
                .orElse(MISS);
    }

}
