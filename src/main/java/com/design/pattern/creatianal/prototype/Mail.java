package com.design.pattern.creatianal.prototype;

public class Mail implements Cloneable{
    private String name;
    private String emailAddress;
    private String  content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", content='" + content + '\'' +
                '}'+super.toString();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Mail(String name, String emailAddress, String content) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.content = content;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("克隆Mail");
        return super.clone();
    }

    public Mail(){
        System.out.println("发送邮件");
    }
}
