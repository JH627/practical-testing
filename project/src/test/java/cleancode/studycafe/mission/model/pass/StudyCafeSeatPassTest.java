package cleancode.studycafe.mission.model.pass;

import cleancode.studycafe.mission.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudyCafeSeatPassTest {

    @DisplayName("lockerPass와 SeatPass의 패스타입, 기간이 같은지 확인한다.")
    @Test
    void isSameDurationType() {
        // given
        StudyCafeSeatPass fixedPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED,4,250000,0.1);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 10000);

        // when
        boolean sameDurationType = fixedPass.isSameDurationType(lockerPass);

        // then
        assertTrue(sameDurationType);
    }

    @DisplayName("패스의 계산된 할인 금액을 반환한다.")
    @Test
    void calculateDiscountPrice() {
        // given
        StudyCafeSeatPass weeklyPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1);

        // when
        int discountPrice = weeklyPass.getDiscountPrice();

        // then
        assertThat(discountPrice).isEqualTo((int) (100000 * 0.1));
    }
}
