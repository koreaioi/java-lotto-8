package lotto.exception;

public enum ErrorMessage {

    MONEY_IS_ZERO("구입 금액은 0원일 수 없습니다. 1,000원 단위의 양수를 입력해주세요.")
    ;

    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
