# delay-queue
redis实现延迟消息队列

#### 需求背景
&nbsp;&nbsp;&nbsp;&nbsp;最近在做一个排队取号的系统
* 在用户预约时间到达前XX分钟发短信通知
* 在用户预约时间结束时要判断用户是否去取号了，不然就记录为爽约
* 在用户取号后开始，等待XX分钟后要发短信提醒是否需要使用其他渠道办理

类似的场景太多，最简单的解决办法就是定时任务去扫表。这样每个业务都要维护自己的扫表逻辑，
而且数据量越来越来越多的，有的数据可能会延迟比较大

经过一番搜索，网上说rabbitmq可以满足延迟执行需求，但是目前系统用了其他消息中间件，所以不打算用。

基于Redis实现的延迟队列java版, 参考[有赞延迟队列](https://tech.youzan.com/queuing_delay/)设计实现

#### 整体结构
整个延迟队列由4个部分组成：

1. JobPool用来存放所有Job的元信息。
2. DelayBucket是一组以时间为维度的有序队列，用来存放所有需要延迟的Job（这里只存放Job Id）。
3. Timer负责实时扫描各个Bucket，并将delay时间大于等于当前时间的Job放入到对应的Ready Queue。
4. ReadyQueue存放处于Ready状态的Job（这里只存放JobId），以供消费程序消费。

!(https://tech.youzan.com/content/images/2016/03/all-1.png)