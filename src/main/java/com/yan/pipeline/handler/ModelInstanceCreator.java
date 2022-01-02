package com.yan.pipeline.handler;

import com.yan.pipeline.ContextHandler;
import com.yan.pipeline.InstanceBuildContext;
import org.springframework.stereotype.Component;

/**
 * @Author yan.zhang
 * @Date 2022/1/2 22:33
 * @Version 1.0
 * @Note 创建实例模型
 */
@Component
public class ModelInstanceCreator implements ContextHandler<InstanceBuildContext> {
    @Override
    public boolean handle(InstanceBuildContext context) {
        System.out.println("根据输入数据创建模型实例");

        return true;
    }
}
