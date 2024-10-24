package sample.cafekiosk.spring.api.service.mail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
        // mock 객체는 기본적으로 Default Return Value를 반환
        when(mailSendClient.sendEmail(anyString(), anyString(), anyString(), anyString()))
                .thenReturn(true);

        // when
        boolean result = mailService.sendMail("", "", "", "");

        // then
        assertThat(result).isTrue();
        // 객체가 몇번 불렸는지 확인 가능
        verify(mailSendHistoryRepository, times(1)).save(any(MailSendHistory.class));
    }

}