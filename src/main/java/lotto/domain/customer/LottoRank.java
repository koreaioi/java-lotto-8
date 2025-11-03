package lotto.domain.customer;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2_000_000_000L, false),
    SECOND(5, 30_000_000L, true),
    THIRD(5, 1_500_000L, false),
    FOURTH(4, 50_000L, false),
    FIFTH(3, 5_000L, false),
    MISS(0, 0L, false),
    ;;


    private final int normalCount;
    private final long prizeMoney;
    private final boolean hasBonus;

    LottoRank(int normalCount, long prizeMoney, boolean hasBonus) {
        this.normalCount = normalCount;
        this.prizeMoney = prizeMoney;
        this.hasBonus = hasBonus;
    }

    public long totalPrizeMoney(int quantity) {
        return this.prizeMoney * quantity;
    }

    static LottoRank valueOf(int normalCount, boolean hasBonus) {
        if (!hasBonus && normalCount == 5) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.normalCount == normalCount)
                .findFirst()
                .orElse(MISS);
    }

    public String toDisplay() {
        String bonusTest = "";
        if (this.hasBonus) {
            bonusTest = ", 보너스 볼 일치";
        }
        return String.format("%d개 일치%s (%,d원)", this.normalCount, bonusTest, this.prizeMoney);
    }

}
