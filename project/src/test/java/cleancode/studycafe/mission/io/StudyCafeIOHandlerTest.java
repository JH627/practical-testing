package cleancode.studycafe.mission.io;

import cleancode.studycafe.mission.exception.AppException;
import cleancode.studycafe.mission.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StudyCafeIOHandlerTest {

    @DisplayName("패스타입 선택에서 4를 선택한 경우 AppException이 발생한다.")
    @Test
    void askPassTypeSelectingException() {
        // given
        provideInput("4\n");
        StudyCafeIOHandler handler = new StudyCafeIOHandler();

        // when

        // then
        assertThatThrownBy(handler::askPassTypeSelecting)
            .isInstanceOf(AppException.class)
            .hasMessage("잘못된 입력입니다.");
    }

    @DisplayName("패스타입 선택에서 1을 선택한 경우 시간권이 선택된다.")
    @Test
    void askPassTypeSelecting() {
        // given
        provideInput("1\n");
        StudyCafeIOHandler handler = new StudyCafeIOHandler();

        // when
        StudyCafePassType passType = handler.askPassTypeSelecting();

        // then
        assertThat(passType).isEqualTo(StudyCafePassType.HOURLY);
    }

    private void provideInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

}
