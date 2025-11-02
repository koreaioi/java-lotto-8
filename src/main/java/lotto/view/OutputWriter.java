package lotto.view;

public class OutputWriter {

    public void printMoneyRequestMessage() {
        System.out.println(ViewMessage.REQUEST_MONEY.getMessage());
    }

    public void printWinningNumberRequestMessage() {
        printLineSeparator();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberRequestMessage() {
        printLineSeparator();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottoQuantity(String quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void printLottoBundle(String lottoBundle) {
        System.out.println(lottoBundle);
    }

    public void printStatisticsInformationMessage(String result) {
        printLineSeparator();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(result);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private void printLineSeparator() {
        System.out.println();
    }

}
