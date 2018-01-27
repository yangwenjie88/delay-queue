package com.yangwenjie.delayqueue.core;

import com.yangwenjie.delayqueue.utils.RedissonUtils;
import org.redisson.api.RList;

/**
 * 存放可以消费的jod
 * @author Yang WenJie
 * @date 2018/1/27 上午2:04
 */
public class ReadyQueue {

    public static void push(String tpic,long delayQueueJodId) {
        RList<Object> rList = RedissonUtils.getList(tpic);
        //rList.
    }
}
