package lotto.view;

public enum ViewMessage {

    REQUEST_MONEY("구입금액을 입력해 주세요.", false),
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
