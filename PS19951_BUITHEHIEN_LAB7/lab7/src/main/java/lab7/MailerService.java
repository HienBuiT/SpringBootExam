package lab7;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

@Service
public interface MailerService {
	/**
	 * Gửi email
	 */
	void send(MailInfo mail) throws MessagingException;

	/**
	 * Gửi email đơn giản
	 */
	void send(String to, String subject, String body) throws MessagingException;

	/**
	 * Xếp mail vào hàng đợi* @param mail thông tin email
	 */
	void queue(MailInfo mail);

	/**
	 * Tạo MailInfo và xếp vào hàng đợi
	 */
	void queue(String to, String subject, String body);

}
