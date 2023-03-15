package com.cst2335.Kaur0900;

import java.util.ArrayList;

public class ChatMessage {

        ArrayList<ChatMessage> messages;

        public  String message;
        private String timeSent;
        private boolean isSentButton;

        ChatMessage(String m, String t, boolean sent){
            message=m;
            timeSent=t;
            isSentButton=sent;

        }
        public String getMessage() {
            return message;
        }

        public String getTimeSent() {
            return timeSent;
        }

        public boolean isSentButton() {
            return isSentButton;
        }

}
