package com.email.mt;

import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.HtmlEmail;

import javax.annotation.PostConstruct;
import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mahl
 * @date 2018-04-26
 */
public class EmailTest {

    private static final String MAIL_DEFAULT_CHARSET = "UTF-8";
    // 默认的连接等待时间（ms）
    private static final int MAIL_DEFAULT_CONNECTION_TIMEOUT = 5000;
    // 默认的数据等待时间（ms）
    private static final int MAIL_DEFAULT_SOCKET_TIMEOUT = 30000;


    private static String MAIL_SMTP_HOST = "";
    public static Integer MAIL_SMTP_PORT = Integer.valueOf(587);
    public static Integer MAIL_TIME_OUT = Integer.valueOf(5000);
    private static String MAIL_SENDER = "";
    private static String MAIL_SENDER_NAME = "";
    private static String MAIL_SENDER_ID = "";
    private static String MAIL_SENDER_PWD = "";

    public static boolean sendHtmlEmail(String emailTitle, String emailContent, String recipient) {

        if (!isEmail(recipient)) {
            return false;
        }

        HtmlEmail email = new HtmlEmail();
        email.setCharset(MAIL_DEFAULT_CHARSET);
        email.setHostName(MAIL_SMTP_HOST);
        email.setSmtpPort(MAIL_SMTP_PORT);
        email.setSocketConnectionTimeout(MAIL_DEFAULT_CONNECTION_TIMEOUT);
        email.setSocketTimeout(MAIL_DEFAULT_SOCKET_TIMEOUT);
        String sendResult = "";
        try {
            email.addTo(recipient);
            if (StringUtils.isNotBlank(MAIL_SENDER_ID)) {
                email.setAuthentication(MAIL_SENDER_ID, MAIL_SENDER_PWD);
            }
            email.setFrom(MAIL_SENDER, MAIL_SENDER_NAME);
            email.setSubject(emailTitle);
            email.setMsg(StringUtils.trimToEmpty(emailContent));
            sendResult = email.send();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public static boolean sendHtmlEmail(String emailTitle, String emailContent, Set<String> recipientSet) {
        List<String> recipientList = new ArrayList<>(recipientSet);
        Address[] tos = validMailAddress(recipientList);

        HtmlEmail email = new HtmlEmail();
        email.setCharset(MAIL_DEFAULT_CHARSET);
        email.setHostName(MAIL_SMTP_HOST);
        email.setSmtpPort(MAIL_SMTP_PORT);
        email.setSocketConnectionTimeout(MAIL_DEFAULT_CONNECTION_TIMEOUT);
        email.setSocketTimeout(MAIL_DEFAULT_SOCKET_TIMEOUT);
        try {
            for (String recipient : recipientList) {
                email.addTo(recipient);
            }
            if (StringUtils.isNotBlank(MAIL_SENDER_ID)) {
                email.setAuthentication(MAIL_SENDER_ID, MAIL_SENDER_PWD);
            }
            email.setFrom(MAIL_SENDER, MAIL_SENDER_NAME);
            email.setSubject(emailTitle);
            email.setMsg(StringUtils.trimToEmpty(emailContent));
            email.send();
        } catch (Exception e) {
            return false;
        }

        return true;
    }


    public static boolean isEmail(String email) {
        Pattern pattern = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$", 2);
        Matcher matcher = pattern.matcher(email);
        return StringUtils.isNotBlank(email) && matcher.matches();
    }


    public static Address[] validMailAddress(List<String> multiMailAddress) {
        try {
            if (CollectionUtils.isNotEmpty(multiMailAddress)) {
                InternetAddress[] tos = new InternetAddress[multiMailAddress.size()];
                for (int i = 0; i < multiMailAddress.size(); ++i) {
                    String receiver = multiMailAddress.get(i);
                    if (isEmail(receiver)) {
                        tos[i] = new InternetAddress(receiver);
                    }
                }

                return tos;
            }
        } catch (Exception e) {
        }

        return new Address[0];
    }

    public static void main(String[] args) {
    }
}
