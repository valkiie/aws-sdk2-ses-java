# aws-sdk2-ses-java
## Introduction
This sample code aims to help you send a simple email using AWS SES with amazon's AWS-SDK2([2.15.12](https://sdk.amazonaws.com/java/api/latest/)) for Java. Since at the time of writing, Amazon's documentation still uses version 1.

## Requirements
### [Verify your email address with Amazon SES](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/verify-email-addresses.html)
### AWS Credentials 
To generate your aws credentials follow the [aws's official docs](https://docs.aws.amazon.com/powershell/latest/userguide/pstools-appendix-sign-up.html)
There are 2 main ways to save your awsAccessKeyId and awsSecretAccessKey:
- For local testing in linux, create _~/.aws/credentials_
```
[default]
aws_access_key_id={YOUR_ACCESS_KEY_ID}
aws_secret_access_key={YOUR_SECRET_ACCESS_KEY}
```

The SDK will automatically search for the credentials there
- For production, assign an IAM role with AWS SES permissions

### Dependencies
For maven:
 ```
  <dependency>
		    <groupId>software.amazon.awssdk</groupId>
		    <artifactId>ses</artifactId>
		    <version>2.15.11</version>
  </dependency>
   ```
