package com.bluecloud.frameworkRU;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Send Email class.
 * 
 * @author Blue.Cloud Technologies
 * 
 */
public class SendEmail {
	private static final Logger LOGGER = Logger.getAnonymousLogger();
	private static String SMTP_SERVER;
	private static String SMTP_SERVER_PORT;
	private static String USER_NAME;
	private static String PASSWORD;
	private static String from;
	private static String to;
	private static String subject;
	static int passedTests;
	static int failedTests;
	static int skippedTests;
	static int totalTests;
	static String startTime;
	static String endTime;
	static String totalTime;

	String env = System.getProperty("environment");

	/**
	 * Send email report.
	 * 
	 * @throws InterruptedException  the interrupted exception
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void sendEmailReport(int totalTests, int passedTests, int failedTests, int skippedTests,
			String startTime, String endTime, String totalTime)
			throws InterruptedException, FileNotFoundException, IOException {
		try {
			SMTP_SERVER = Base.configProps.getProperty("host");
			SMTP_SERVER_PORT = Base.configProps.getProperty("port");
			USER_NAME = Base.configProps.getProperty("sendEmailFrom");
			PASSWORD = Base.configProps.getProperty("sendEmailPwd");
			from = Base.configProps.getProperty("sendEmailFrom");
			to = Base.configProps.getProperty("sendEmailTo");
			String url = Base.configProps.getProperty("web.app.url");
			subject = "Automation Summary Report for the site: " + url;

			final Session session = Session.getInstance(getEmailProperties(), new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(USER_NAME, PASSWORD);
				}

			});
			String recipients = to;
			String[] recipientList = recipients.split(",");
			InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
			int counter = 0;
			for (String recipient : recipientList) {
				recipientAddress[counter] = new InternetAddress(recipient.trim());
				counter++;
			}
			final Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, recipientAddress);
			message.setFrom(new InternetAddress(from));
			message.setSubject(subject);
			message.setSentDate(new Date());
			message.setText(
					"Hi,\n\nAttached is the Automation Test Suite Report of Bluenet Technologies application.\n\n"
							+ "Below is the summary of the report:\n\n" + "Execution of Tests Start Date & Time	: "
							+ startTime + "\nExecution of Tests End Date & Time	: " + endTime
							+ "\nTotal Time taken for Execution	: " + totalTime + "\nTotal Tests			: "
							+ totalTests + "\nTotal No. of Tests Passed	: " + passedTests
							+ "\nTotal No. of Tests Failed	: " + failedTests + "\nTotal No. of Tests Skipped	: "
							+ skippedTests + " \n\nRegards,\nAutomation Team");
			System.out.println("Sending email report...........");
			Transport.send(message);
			System.out.println("Report sent...........");
		} catch (final MessagingException ex) {
			LOGGER.log(Level.WARNING, "Error Message: " + ex.getMessage(), ex);
		}
	}

	/**
	 * Gets the email properties.
	 * 
	 * @return the email properties
	 */
	public static Properties getEmailProperties() {
		final Properties config = new Properties();
		config.put("mail.smtp.auth", "true");
		config.put("mail.smtp.starttls.enable", "true");
		config.put("mail.smtp.host", SMTP_SERVER);
		config.put("mail.smtp.port", SMTP_SERVER_PORT);
		config.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		config.put("mail.smtp.EnableSSL.enable", "true");
		return config;
	}

	public static void main(String[] args) throws FileNotFoundException, InterruptedException, IOException {
		sendEmailReport(totalTests, passedTests, failedTests, skippedTests, startTime, endTime, totalTime);

	}

}