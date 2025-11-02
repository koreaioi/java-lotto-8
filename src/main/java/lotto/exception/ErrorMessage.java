package lotto.exception;

public enum ErrorMessage {

    MONEY_IS_ZERO("구입 금액은 0원일 수 없습니다. 1,000원 단위의 양수를 다시 입력해주세요."),
    MONEY_IS_NEGATIVE("구입 금액은 음수일 수 없습니다. 1,000원 단위의 양수를 다시 입력해주세요."),
    MONEY_IS_NOT_THOUSAND_UNIT("1,000원 단위의 구입 금액을 다시 입력해주세요."),
    MONEY_IS_NOT_INTEGER("구입 금액이 숫자가 아닙니다. 1,000원 단위의 양수를 다시 입력해주세요."),

    LOTTO_IS_ZERO("로또 번호는 0일 수 없습니다. 1과 45사이의 로또 번호를 다시 입력해주세요."),
    LOTTO_IS_NEGATIVE("로또 번호는 음수일 수 없습니다. 1과 45사이의 로또 번호를 다시 입력해주세요."),
    ;

    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
