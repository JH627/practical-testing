package cleancode.studycafe.mission.model.order;

import cleancode.studycafe.mission.model.pass.StudyCafePassType;
import cleancode.studycafe.mission.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.mission.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyCafePassOrderTest {

    @DisplayName("seatPass와 lockerPass가 포함된 Order는 총 금액을 정확하게 계산한다.")
    @Test
    void getTotalPriceWithLockerPass() {
        // given
        StudyCafeSeatPass fixedPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED,4,250000,0.1);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 10000);

        StudyCafePassOrder passOrder = StudyCafePassOrder.of(fixedPass, lockerPass);

        // when
        int totalPrice = passOrder.getTotalPrice();

        // then
        assertEquals(totalPrice, 10000 + 250000 * (1 - 0.1));
    }

    @DisplayName("lockerPass가 포함되지 않은 Order는 총 금액을 정확하게 계산한다.")
    @Test
    void getTotalPriceWithoutLockerPass() {
        // given
        StudyCafeSeatPass fixedPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED,4,250000,0.1);

        StudyCafePassOrder passOrder = StudyCafePassOrder.of(fixedPass, null);

        // when
        int totalPrice = passOrder.getTotalPrice();

        // then
        assertEquals(totalPrice, 250000 * (1 - 0.1));
    }
}
