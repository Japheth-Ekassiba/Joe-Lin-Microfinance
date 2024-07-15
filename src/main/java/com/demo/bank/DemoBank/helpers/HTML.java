package com.demo.bank.DemoBank.helpers;

public class HTML {
    public static String htmlEmailTemplate(String token, int code){

     //Verify Account URL:
     String url = "http://127.0.0.1:8070/verify?token=" +token +"&code=" + code;

     String emailTemplate = "<!DOCTYPE html>\n" +
             "<html lang='en'>\n" +
             "<head>\n" +
             "  <meta charset='UTF-8'>\n" +
             "  <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
             "  <title>Email</title>\n" +
             "  \n" +
             "  <style>\n" +
             "      *{\n" +
             "        box-sizing: border-box;\n" +
             "        font-family: Comfortaa;\n" +
             "      }\n" +
             "\n" +
             "      /* Main Body Styling */\n" +
             "      body{\n" +
             "        height: 100vh;\n" +
             "        background-color: rgb(212,222,230);\n" +
             "        display: flex;\n" +
             "        align-items: center;\n" +
             "        justify-content: center;\n" +
             "      }\n" +
             "\n" +
             "      /* Wrapper Styling */\n" +
             "      .wrapper{\n" +
             "        width: 550px;\n" +
             "        height: auto;\n" +
             "        padding: 15px;\n" +
             "        background-color: white;\n" +
             "        border-radius: 7px;\n" +
             "\n" +
             "      }\n" +
             "\n" +
             "      /* Email MSG Header */\n" +
             "      .email-msg-header{\n" +
             "        text-align: center;\n" +
             "      }\n" +
             "      .company-name{\n" +
             "        width:100%;\n" +
             "        text-align: center;\n" +
             "        font-size: 35px;\n" +
             "        color:gray;\n" +
             "      }\n" +
             "      /* Welcome Text */\n" +
             "      .welcome-text{\n" +
             "        text-align: center;\n" +
             "      }\n" +
             "\n" +
             "      /* Verify Account Button */\n" +
             "      .verify-account-btn{\n" +
             "        padding:15px;\n" +
             "        background-color:rgb(0,109,252);\n" +
             "        text-decoration: none;\n" +
             "        color: white;\n" +
             "        border-radius: 5px;\n" +
             "      }\n" +
             "\n" +
             "      /* Copyright Wrapper */\n" +
             "      .copy-right{\n" +
             "        display: flex;\n" +
             "        align-items: center;\n" +
             "        justify-content: center;\n" +
             "        color: gray;\n" +
             "        padding: 15px;\n" +
             "        font-size: 14px;\n" +
             "        margin: 20px 0px;\n" +
             "      }\n" +
             "  </style>\n" +
             "</head>\n" +
             "<body>\n" +
             "\n" +
             "  <!-- Wrapper -->\n" +
             "  <div class='wrapper'>\n" +
             "   <!-- Email MSG header -->\n" +
             "   <h2 class='email-msg-header'>\n" +
             "    Welcome and Thank You for Choosing\n" +
             "    </h2>\n" +
             "   <!-- End Of Email MSG header -->\n" +
             "\n" +
             "   <!-- Company Name -->\n" +
             "   <div class='company-name'>Joe-Lin Bank</div>  \n" +
             "   <!-- End Of Company Name -->\n" +
             "\n" +
             "   <hr>\n" +
             "  <!-- Welcome Text -->\n" +
             "  <p class='welcome-text'>\n" +
             "    Your account has been successfully registered, please click below to verify your account.\n" +
             "  </p>\n" +
             "  <!-- End Of Welcome Text -->\n" +
             "  <br>\n" +
             "  <br>\n" +
             "\n" +
             "\n" +
             "\n" +
             "  <!-- Verify Account Button -->\n" +
             "  <center><a href='" + url + "' class='verify-account-btn'>Verify Account</a></center>\n" +
             "  <!-- End Of Verify Account Button -->\n" +
             "\n" +
             "  <!-- Copyright Wrapper -->\n" +
             "  <div class='copy-right'>\n" +
             "    &copy; Copyright 2021. All Right Reserved.\n" +
             "  </div>\n" +
             "  <!-- End Of Copyright Wrapper -->\n" +
             "  </div>\n" +
             "  \n" +
             "  <!-- End Of Wrapper -->\n" +
             "</body>\n" +
             "</html>";
     return emailTemplate;
    }
}
