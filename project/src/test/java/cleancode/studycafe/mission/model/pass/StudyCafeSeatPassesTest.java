package cleancode.studycafe.mission.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeSeatPassesTest {

    @DisplayName("패스 타입으로 필터링한 패스 리스트를 반환한다.")
    @Test
    void findPassByStudyCafePassType() {
        // given
        StudyCafeSeatPass pass1 = StudyCafeSeatPass.of(StudyCafePassType.HOURLY,2,4000,0.0);
        StudyCafeSeatPass pass2 = StudyCafeSeatPass.of(StudyCafePassType.HOURLY,4,6500,0.0);
        StudyCafeSeatPass pass3 = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY,1,60000,0.0);
        StudyCafeSeatPass pass4 = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY,2,100000,0.1);
        StudyCafeSeatPass pass5 = StudyCafeSeatPass.of(StudyCafePassType.FIXED,4,250000,0.1);
        StudyCafeSeatPass pass6 = StudyCafeSeatPass.of(StudyCafePassType.FIXED,12,700000,0.15);

        StudyCafeSeatPasses passes = StudyCafeSeatPasses.of(Arrays.asList(pass1, pass2, pass3, pass4, pass5, pass6));

        // when
        List<StudyCafeSeatPass> filteredPassList = passes.findPassBy(StudyCafePassType.FIXED);

        // then
        assertThat(filteredPassList).hasSize(2);
        assertThat(filteredPassList).contains(pass5);
        assertThat(filteredPassList).contains(pass6);
    }
}
