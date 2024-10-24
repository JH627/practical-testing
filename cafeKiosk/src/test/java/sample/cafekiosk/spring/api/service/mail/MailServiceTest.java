package sample.cafekiosk.spring.api.service.mail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import sample.cafekiosk.spring.client.mail.MailSendClient;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistory;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistoryRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


// Mock 어노테이션을 사용할 때 필요
@ExtendWith(MockitoExtension.class)
class MailServiceTest {

    // MailSendClient mailSendClient = mock(MailSendClient.class);와 같은 효과
    @Mock
    private MailSendClient mailSendClient;

    // MailSendHistoryRepository mailSendHistoryRepository = mock(MailSendHistoryRepository.class);와 같은 효과
    @Mock
    private MailSendHistoryRepository mailSendHistoryRepository;

    // 생성자를 보고 Mock 객체로 선언된 객체를 Inject 해줌
    // MailService mailService = new MailService(mailSendClient, mailSendHistoryRepository);
    @InjectMocks
    private MailService mailService;

    @DisplayName("메일 전송 테스트")
    @Test
    void sendMail() {
        // given
        BDDMockito.given(mailSendClient.sendEmail(anyString(), anyString(), anyString(), anyString()))
                .willReturn(true);

        // mock 객체는 기본적으로 Default Return Value를 반환
        // 스파이는 실제 객체를 기반으로 만들어지기 때문에 stubbing이 되지 않음
//        when(mailSendClient.sendEmail(anyString(), anyString(), anyString(), anyString()))
//                .thenReturn(true);

        // 대신 이 문법 사용
//        doReturn(true)
//                .when(mailSendClient)
//                .sendEmail(anyString(), anyString(), anyString(), anyString());

        // when
        boolean result = mailService.sendMail("", "", "", "");

        // then
        assertThat(result).isTrue();
        // 객체가 몇번 불렸는지 확인 가능
        verify(mailSendHistoryRepository, times(1)).save(any(MailSendHistory.class));
    }

}