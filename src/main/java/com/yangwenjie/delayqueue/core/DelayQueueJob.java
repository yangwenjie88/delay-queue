package com.yangwenjie.delayqueue.core;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 延迟任务
 * @author Yang WenJie
 * @date 2018/1/27 上午12:18
 */
public class DelayQueueJob {

    /**
     * 延迟任务的唯一标识，用于检索任务
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private long id;

    /**
     * 任务类型（具体业务类型）
     */
    private String topic;

    /**
     * 任务的执行时间
     */
    private long delayTime;

    /**
     * 任务的执行超时时间
     */
    private long ttrTime;

    /**
     * 任务具体的消息内容，用于处理具体业务逻辑用
     */
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    public long getTtrTime() {
        return ttrTime;
    }

    public void setTtrTime(long ttrTime) {
        this.ttrTime = ttrTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DelayQueueJob{");
        sb.append("id=").append(id);
        sb.append(", topic='").append(topic).append('\'');
        sb.append(", delayTime=").append(delayTime);
        sb.append(", ttrTime=").append(ttrTime);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
