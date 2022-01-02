package com.yan.pipeline.handler;

import com.yan.pipeline.ContextHandler;
import com.yan.pipeline.InstanceBuildContext;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @Author yan.zhang
 * @Date 2022/1/2 22:26
 * @Version 1.0
 *
 * @Note 数据校验处理器
 */
@Component
public class InputDataPreChecker implements ContextHandler<InstanceBuildContext> {

    @Override
    public boolean handle(InstanceBuildContext context) {
        System.out.println("数据校验");
        Map<String, Object> input = context.getFormInput();

        if (MapUtils.isEmpty(input)) {
            context.setErrorMsg("表单输入数据不能为空");
            return false;
        }

        String instanceName = (String) input.get("instanceName");

        if (StringUtils.isEmpty(instanceName)) {
            context.setErrorMsg("表单输入数据必须包含实例名称");
            return false;
        }

        return true;
    }
}
