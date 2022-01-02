package com.yan.pipeline.handler;

import com.yan.pipeline.ContextHandler;
import com.yan.pipeline.InstanceBuildContext;

/**
 * @Author yan.zhang
 * @Date 2022/1/2 22:51
 * @Version 1.0
 */
public class FormInputPreprocessor implements ContextHandler<InstanceBuildContext> {
    @Override
    public boolean handle(InstanceBuildContext context) {

        System.out.println("表单数据预处理");
        return true;
    }
}
