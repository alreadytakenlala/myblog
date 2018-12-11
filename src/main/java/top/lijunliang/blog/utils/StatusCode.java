package top.lijunliang.blog.utils;

import org.springframework.stereotype.Component;

public class StatusCode
{
    //状态码，0代表成功，1代表失败
    private int status;

    //消息
    private String message;

    private Object date;

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Object getDate()
    {
        return date;
    }

    public void setDate(Object date)
    {
        this.date = date;
    }

    public StatusCode(int status)
    {
        this.status = status;
    }

    public StatusCode(int status, String message)
    {
        this.status = status;
        this.message = message;
    }

    public StatusCode(int status, String message, Object date)
    {
        this.status = status;
        this.message = message;
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "StatusCode{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
