package com.sogou.lyj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import javamail.MailSenderInfo;
import javamail.SimpleMailSender;


public class SendMailMonitor {

    protected HashMap<String, String> parseMem(InputStream input) throws IOException {
        HashMap<String, String> result = new HashMap<String, String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        String temp = "";
        while ((temp = reader.readLine()) != null) {
            StringTokenizer st1 = new StringTokenizer(temp);
            ArrayList<String> list = new ArrayList<String>();
            while (st1.hasMoreTokens()) {
                String temp1 = st1.nextToken();
                temp1 = temp1.replaceAll(":", "");
                System.out.println(temp1);
                list.add(temp1);
            }
            result.put(list.get(0), list.get(1));
        }
        return result;
    }

    protected double cal_use_rate(HashMap<String, String> hm) {
        double rate;
        rate = (Double.parseDouble(hm.get("MemTotal")) - Double.parseDouble(hm.get("MemFree")) - Double.parseDouble(hm.get("Buffers")) - Double.parseDouble(hm.get("Cached"))) / Double.parseDouble(hm.get("MemTotal"));
        return rate;
    }

    protected InputStream execute(String command) throws IOException {
        InputStream fi = null;
        Process p;
        p = Runtime.getRuntime().exec(command);
        fi = p.getInputStream();
        return fi;
    }

    protected double getMemrate() {
        double rate = 0;
        String command = "cat /proc/meminfo";
        try {
            InputStream input = execute(command);
            rate = cal_use_rate(parseMem(input));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rate;
    }

    protected void sendmail(String toaddress, String subject, String content) {
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("myusername1@163.com");
        mailInfo.setPassword("a1122334");//您的邮箱密码    
        mailInfo.setFromAddress("myusername1@163.com");

        mailInfo.setToAddress(toaddress);
        mailInfo.setSubject(subject);
        mailInfo.setContent(content);
        //这个类主要来发送邮件
        SimpleMailSender sms = new SimpleMailSender();
        sms.sendTextMail(mailInfo);//发送文体格式    
    }


    public static void main(String args[]) {
        SendMailMonitor smm = new SendMailMonitor();
        double rate = smm.getMemrate();
        if (rate > 0.1) {
            String addr = "liyanjiao@sogou-inc.com";
            String content = "The rate of mem is:" + rate * 100.0 + "%";
            String subject = "warning mail!!!";
            smm.sendmail(addr, subject, content);
        }
    }

}
