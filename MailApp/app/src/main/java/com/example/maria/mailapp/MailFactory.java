package com.example.maria.mailapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maria on 26.11.2016.
 */

public class MailFactory {

    public List<Mail> getMails() {
        List<Mail> mails = new ArrayList<Mail>();

        mails.add(new Mail(1, "Maria", "intrebare licenta", "fsssssssssssssssssssssssssssfsdvsdvsdvsfvdsfdssffs"));
        mails.add(new Mail(2, "Mircea", "intalnire afaceri", "dvsknfuscbsdudcbhsubcusdbc sudbc sdjbcjsdbchjsdbcsd"));
        mails.add(new Mail(3, "Bianca", "bggbfbg", "dvsknfuscbsdudcbhsubcusdbc sudbc sdjbcjsdbchjsdbcsd"));
        mails.add(new Mail(4, "Roxana", "gbfb", "dvsknfuscbsdudcbhsubcusdbc sudbc sdjbcjsdbchjsdbcsd"));
        mails.add(new Mail(5, "Sorina", "gbfbbgb", "dvsknfuscbsdudcbhsubcusdbc sudbc sdjbcjsdbchjsdbcsd"));

        return mails;
    }
}
