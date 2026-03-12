package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
  public List<String> getCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    validateCarNames(input);
    return Arrays.asList(input.split(","));
  }

  private void validateCarNames(String input) {
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
    }

    if (!input.matches("^[a-zA-Z가-힣,]+$")) {
      throw new IllegalArgumentException("이름과 쉼표(,)로만 이루어진 문자열을 입력해주세요.");
    }
  }

  public int getCount() {
    System.out.println("시도할 횟수는 몇 회인가요?(최대 100회)");
    String input = Console.readLine();
    validateCount(input);
    return Integer.parseInt(input);
  }

  private void validateCount(String input) {
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException("횟수를 입력해주세요.");
    }
    if (!input.matches("\\d+")) {
      throw new IllegalArgumentException("횟수는 숫자여야 합니다.");
    }
    int count = Integer.parseInt(input);
    if (count < 1 || count > 100) {
      throw new IllegalArgumentException("횟수는 1 이상 100 이하여야 합니다.");
    }
  }
}
