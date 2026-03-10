package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  void 자동차_생성_성공() {
    Car car = new Car("pobi");
    assertThat(car.getName()).isEqualTo("pobi");
    assertThat(car.getPosition()).isEqualTo(0);
  }

  @Test
  void 이름이_5자_초과면_예외() {
    assertThatThrownBy(() -> new Car("pobiii"))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 이름이_공백이면_예외() {
    assertThatThrownBy(() -> new Car("  "))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 이름이_null이면_예외() {
    assertThatThrownBy(() -> new Car(null))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void move_호출시_position_증가() {
    Car car = new Car("pobi");
    car.move();
    assertThat(car.getPosition()).isEqualTo(1);
  }
}
