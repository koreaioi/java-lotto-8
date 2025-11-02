package lotto.view;

public enum ViewMessage {

    REQUEST_MONEY("구입금액을 입력해 주세요.", false),
    WINNING_NUMBER("당첨 번호를 입력해 주세요.", false),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.", false),
    LOTTO_QUANTITY("%s개를 구매했습니다.", true),
    WINNING_STATISTIC("당첨 통계", true),
    DASH("---", false),
    LOTTO_STATISTIC("%s - %s개", true),
    LOTTO_ROI("총 수익률은 %s%%입니다.", true),
    ;

    private final String message;
    private final boolean isFormatted;

    ViewMessage(String message, boolean isFormatted) {
        this.message = message;
        this.isFormatted = isFormatted;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(String... messages) {
        if (isFormatted) {
            return String.format(message, messages);
        }
        return message;
    }

}
