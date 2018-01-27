package com.yangwenjie.delayqueue.utils;

/**
 * Create By IntelliJ IDEA
 *
 * @author Yang WenJie
 * @date 2017/11/13 11:42
 */
public class SnowflakeIdUtil {

    private static SnowflakeIdWorker snowflakeIdWorker;

    public SnowflakeIdUtil(long workerId, long dataCenterId){
        snowflakeIdWorker = new SnowflakeIdWorker(workerId,dataCenterId);
    }

    public long nextId(){
        return snowflakeIdWorker.nextId();
    }
}
