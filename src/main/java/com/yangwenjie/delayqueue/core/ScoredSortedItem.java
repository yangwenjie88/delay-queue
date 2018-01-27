package com.yangwenjie.delayqueue.core;

/**
 * @author Yang WenJie
 * @date 2018/1/27 上午1:23
 */
public class ScoredSortedItem {

    /**
     * 任务的执行时间
     */
    private long delayTime;

    /**
     * 延迟任务的唯一标识
     */
    private long delayQueueJodId;

    public ScoredSortedItem(long delayQueueJodId, long delayTime) {
        this.delayQueueJodId = delayQueueJodId;
        this.delayTime = delayTime;
    }

    public ScoredSortedItem() {

    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    public long getDelayQueueJodId() {
        return delayQueueJodId;
    }

    public void setDelayQueueJodId(long delayQueueJodId) {
        this.delayQueueJodId = delayQueueJodId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScoredSortedItem{");
        sb.append("delayTime=").append(delayTime);
        sb.append(", delayQueueJodId=").append(delayQueueJodId);
        sb.append('}');
        return sb.toString();
    }
}
