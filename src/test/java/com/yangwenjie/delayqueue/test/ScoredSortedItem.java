package com.yangwenjie.delayqueue.test;

/**
 * @author Yang WenJie
 * @date 2018/1/27 上午1:23
 */
public class ScoredSortedItem {

    private long delayTime;
    private long delayQueueJodId;

    public ScoredSortedItem(long delayQueueJodId,long delayTime) {
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
