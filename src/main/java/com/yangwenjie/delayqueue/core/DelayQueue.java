package com.yangwenjie.delayqueue.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 延迟消息队列
 * @author Yang WenJie
 * @date 2018/1/27 上午11:28
 */
public class DelayQueue {

    private static final Logger logger = LoggerFactory.getLogger(DelayQueue.class);
    public static final String DELAY_BUCKET_KEY_PREFIX = "delayBucket";
    public static final long  DELAY_BUCKET_NUM = 10L;

    /**
     * 获取delayBucket key 分开多个，有利于提高效率
     * @param delayQueueJodId
     * @return
     */
    private static String getDelayBucketKey(long delayQueueJodId) {
        return DELAY_BUCKET_KEY_PREFIX+Math.floorMod(delayQueueJodId,DELAY_BUCKET_NUM);
    }

    /**
     * 添加延迟任务到延迟队列
     * @param delayQueueJob
     */
    public static void push(DelayQueueJob delayQueueJob) {
        DelayQueueJobPool.addDelayQueueJod(delayQueueJob);
        ScoredSortedItem item = new ScoredSortedItem(delayQueueJob.getId(), delayQueueJob.getDelayTime());
        DelayBucket.addToBucket(getDelayBucketKey(delayQueueJob.getId()),item);
    }

    /**
     * 获取准备好的延迟任务
     * @param topic
     * @return
     */
    public static DelayQueueJob pop(String topic) {
        Long delayQueueJodId = ReadyQueue.pollFormReadyQueue(topic);
        if (delayQueueJodId == null) {
            return null;
        } else {
            DelayQueueJob delayQueueJod = DelayQueueJobPool.getDelayQueueJod(delayQueueJodId);
            if (delayQueueJod == null) {
                return null;
            } else {
                //获取消费过去时间，重新放到延迟任务桶中
                long ttrTime = System.currentTimeMillis()+delayQueueJod.getTtrTime()*1000L;
                ScoredSortedItem item = new ScoredSortedItem(delayQueueJod.getId(), ttrTime);
                DelayBucket.addToBucket(getDelayBucketKey(delayQueueJod.getId()),item);
                return delayQueueJod;
            }
        }
    }

    /**
     * 删除延迟队列任务
     * @param delayQueueJodId
     */
    public static void delete(long delayQueueJodId) {
        DelayQueueJobPool.deleteDelayQueueJod(delayQueueJodId);
    }

    /**
     * 查询delay job
     * @param delayQueueJodId
     * @return
     */
    public static DelayQueueJob get(long delayQueueJodId) {
        return DelayQueueJobPool.getDelayQueueJod(delayQueueJodId);
    }
}
