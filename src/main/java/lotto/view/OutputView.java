package lotto.view;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_PURCHASE_AMOUNT = "개를 구매했습니다.";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_RACKET = "]";

    public static void printPurchaseCount(int ticketCount) {
        System.out.println(ticketCount + OUTPUT_PURCHASE_AMOUNT);
    }

    public static String printRandomLottoNumbers(List<Integer> randomLottoNumbers) {
        //[8, 21, 23, 41, 42, 43]
        StringBuilder randomLottoNumbersResult = new StringBuilder();
        randomLottoNumbersResult.append(OPEN_BRACKET);
        for (int i : randomLottoNumbers) {
            randomLottoNumbersResult.append(i);
            randomLottoNumbersResult.append(", ");
        }
        randomLottoNumbersResult.delete(randomLottoNumbersResult.length() - 2, randomLottoNumbersResult.length());
        randomLottoNumbersResult.append(CLOSE_RACKET);
        System.out.println(randomLottoNumbersResult);
        return String.valueOf(randomLottoNumbersResult);
    }
}
