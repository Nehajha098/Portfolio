package com.portfolio.neha.service;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendEmail(String name, String email, String message) {
        System.out.println("🔥 EMAIL SERVICE CALLED");

        // Pull the API key safely from Render's runtime environment
        String apiKey = System.getenv("RESEND_API_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            System.out.println("❌ Email failed: RESEND_API_KEY environment variable is missing!");
            return;
        }

        Resend resend = new Resend(apiKey);

        try {
            // Build the email parameters cleanly
            CreateEmailOptions params = CreateEmailOptions.builder()
                    .from("Portfolio Contact <onboarding@resend.dev>")
                    .to("nehajha22004@gmail.com")
                    .replyTo(email)
                    .subject("Portfolio Contact Message")
                    .html("<p><strong>Name:</strong> " + name + "</p>" +
                            "<p><strong>Email:</strong> " + email + "</p><br/>" +
                            "<p><strong>Message:</strong></p>" +
                            "<p>" + message.replace("\n", "<br/>") + "</p>")
                    .build();

            // Send via the emails service resource
            CreateEmailResponse response = resend.emails().send(params);

            System.out.println("✅ Email sent successfully via Resend. ID: " + response.getId());

        } catch (ResendException e) {
            System.out.println("❌ Email failed due to Resend API error");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("❌ Email failed due to a general exception");
            e.printStackTrace();
        }
    }
}