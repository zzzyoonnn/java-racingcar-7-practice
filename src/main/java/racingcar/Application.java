package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현
    //Game game = new Game();
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    System.out.println("시도할 횟수는 몇 회인가요?(최대 100회)");
    int count = Integer.parseInt(Console.readLine());

    String[] carName = input.split(",");

    Map<String, Integer> car = new HashMap<>();
    for (String name : carName) {
      car.put(name, 0);
    }

    Random random = new Random();
    StringBuilder sb;
    for (int i = 0; i < count; i++) {
      for (int j = 0; j < carName.length; j++) {
        String name = carName[j];
        int num = random.nextInt(10);

        if (num >= 4) {
          car.put(name, car.get(name) + 1);
        }
      }

      sb = new StringBuilder();
      for (String s : carName) {
        sb.append(s).append(" : ");
        sb.append("-".repeat(Math.max(0, car.get(s))));
        sb.append("\n");
      }
      System.out.println(sb);
    }

    int maxDistance = car.values().stream().mapToInt(Integer::intValue).max().orElse(0);

    ArrayList<String> result = new ArrayList<>();
    for (String cn : carName) {
      if (car.get(cn) == maxDistance) result.add(cn);
    }

    sb = new StringBuilder();
    sb.append("최종 우승자 : ");
    for (int i = 0; i < result.size(); i++) {
      sb.append(result.get(i));

      if (i != result.size() - 1) {
        sb.append(", ");
      }
    }
    System.out.print(sb);
  }
}
