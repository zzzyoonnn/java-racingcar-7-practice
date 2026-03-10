package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RaceTest {

  @Test
  void 우승자_단독() {
    Car pobi = new Car("pobi");
    Car woni = new Car("woni");
    pobi.move();

    Race race = new Race(List.of(pobi, woni));
    List<Car> winners = race.findWinners();

    assertThat(winners).containsExactly(pobi);
  }

  @Test
  void 우승자_공동() {
    Car pobi = new Car("pobi");
    Car woni = new Car("woni");
    pobi.move();
    woni.move();

    Race race = new Race(List.of(pobi, woni));
    List<Car> winners = race.findWinners();

    assertThat(winners).containsExactly(pobi, woni);
  }
}
