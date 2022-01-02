package com.yan.pipeline.handler;

import com.yan.pipeline.ContextHandler;
import com.yan.pipeline.InstanceBuildContext;

/**
 * @Author yan.zhang
 * @Date 2022/1/2 22:35
 * @Version 1.0
 */
public class ModelInstanceSaver implements ContextHandler<InstanceBuildContext> {
    @Override
    public boolean handle(InstanceBuildContext context) {

        return true;
    }
}
