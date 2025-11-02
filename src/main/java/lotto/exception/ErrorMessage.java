package lotto.exception;

public enum ErrorMessage {

    MONEY_IS_ZERO("구입 금액은 0원일 수 없습니다. 1,000원 단위의 양수를 다시 입력해주세요."),
    MONEY_IS_NEGATIVE("구입 금액은 음수일 수 없습니다. 1,000원 단위의 양수를 다시 입력해주세요."),
    MONEY_IS_NOT_THOUSAND_UNIT("1,000원 단위의 구입 금액을 다시 입력해주세요."),
    MONEY_IS_NOT_INTEGER("구입 금액이 숫자가 아닙니다. 1,000원 단위의 양수를 다시 입력해주세요."),

    NUMBER_IS_NOT_LOTTO_RANGE("로또 번호는 1부터 45 사이의 정수입니다. 다시 입력해주세요."),

    LOTTO_COUNT_IS_SIX("로또 번호는 6개여야 합니다."),
    ;

    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
