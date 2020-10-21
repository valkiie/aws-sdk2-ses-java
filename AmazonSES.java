import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.Body;
import software.amazon.awssdk.services.ses.model.Content;
import software.amazon.awssdk.services.ses.model.Destination;
import software.amazon.awssdk.services.ses.model.Message;
import software.amazon.awssdk.services.ses.model.SendEmailRequest;

public class AmazonSES {
	
	static final String FROM = "sender@email.com";
	static final String TO = "receiver@email.com";
	static final String SUBJECT = "TEST AWS SES";
	static final String HTMLBODY = "<h1>Amazon SES test (AWS SDK for Java)</h1>"
			+ "<p>This email was sent with <a href='https://aws.amazon.com/ses/'>"
			+ "Amazon SES</a> using the <a href='https://aws.amazon.com/sdk-for-java/'>" 
			+ "AWS SDK for Java</a>";

	public static void sendEmail() {
		try {
			Destination destination = Destination.builder().toAddresses(TO).build();
			Content subject = Content.builder().data(SUBJECT).build();
			Content body = Content.builder().data(HTMLBODY).build();
			Message message = Message.builder()
					.subject(subject)
					.body(Body.builder()
							.html(body)
							.build())
					.build();
			SesClient client = SesClient.builder().region(Region.US_EAST_1).build();
			SendEmailRequest request = SendEmailRequest.builder()
					.source(FROM)
					.destination(destination)
					.message(message)
					.build();
			client.sendEmail(request);
		} catch (Exception ex) {
			System.out.println("The email was not sent. Error message: " + ex.getMessage());
		}
	}
}
