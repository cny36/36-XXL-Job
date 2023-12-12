package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * @author : chennengyuan
 */
@Component
public class MyShardingJobHandler {

    @XxlJob(value = "MyShardingJobHandler")
    public ReturnT<String> execute() throws InterruptedException {
        System.out.println("MyShardingJobHandler 开始执行");
        int shardTotal = XxlJobHelper.getShardTotal();
        int shardIndex = XxlJobHelper.getShardIndex();
        System.out.println(String.format("总分片为%s，当前分片序号为%s", shardTotal, shardIndex));

        for (int i = 0; i < 10; i++) {
            if (i % shardTotal == shardIndex) {
                System.out.println(String.format("分片：%s 开始给用户ID：%s 发送短信", shardIndex, i));
                Thread.sleep(1000);
            }
        }

        return ReturnT.SUCCESS;
    }
}
