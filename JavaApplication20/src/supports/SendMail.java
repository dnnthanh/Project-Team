package supports;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Ngọc Thanh
 */
public class SendMail {

    public static String sendMail(String to) {
        String from = "dangngocthanh720@gmail.com";
        String host = "ehsfuagjkkdhdssm";

        Properties properties = new Properties();

        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, host);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Mật khẩu mới của bạn là: ");
            String matkhau = "";
            for (int i = 0; i < 6; ++i) {
                double random = Math.random();
                random = random * 10;
                matkhau += String.valueOf((int) random);
            }
            message.setText(matkhau + ". Vui lòng không cung cấp mật khẩu cho người khác. Nếu"
                    + " không có chuyện gì xảy ra bạn phải chịu trách nhiệm với cửa hàng. \nTrân trọng cảm ơn!");
            Transport.send(message);
            return matkhau;
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return null;
    }
    
//    public static void main(String[] args) {
//        String mail = "";
//        String PASS = SendMail.sendMail(mail);
//        System.out.println(PASS);
//    }
}
