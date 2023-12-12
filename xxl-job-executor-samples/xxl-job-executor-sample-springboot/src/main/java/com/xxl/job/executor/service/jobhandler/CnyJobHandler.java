package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * @author : chennengyuan
 */
@Component
public class CnyJobHandler {

    @XxlJob(value = "cnyJobHandler", init = "init", destroy = "destroy")
    public ReturnT<String> execute() {
        String jobParam = XxlJobHelper.getJobParam();
        System.out.println("Job参数为：" + jobParam);
        System.out.println("CnyJobHandler 执行成功");
        XxlJobHelper.log("任务执行成功");
        return ReturnT.SUCCESS;
    }

    public void init() {
        System.out.println("CnyJobHandler 初始化");
    }

    public void destroy() {
        System.out.println("CnyJobHandler 销毁");
    }
}
