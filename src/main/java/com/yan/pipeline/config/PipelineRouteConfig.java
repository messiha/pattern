package com.yan.pipeline.config;

import com.yan.pipeline.ContextHandler;
import com.yan.pipeline.InstanceBuildContext;
import com.yan.pipeline.PipelineContext;
import com.yan.pipeline.handler.InputDataPreChecker;
import com.yan.pipeline.handler.ModelInstanceCreator;
import com.yan.pipeline.handler.ModelInstanceSaver;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author yan.zhang
 * @Date 2022/1/2 22:36
 * @Version 1.0
 * <p>
 * 管道路由配置
 * 指定好 ”Context -> 管道“ 的映射，以及管道中处理器的顺序 。Spring 来根据这份路由表，在启动时就构建好一个 Map，
 * Map 的键为 Context 的类型，值为 管道（即 List<ContextHandler>）
 */
@Configuration
public class PipelineRouteConfig implements ApplicationContextAware {
    /**
     * 数据类型->管道中处理器类型列表 的路由
     */
    private static final
    Map<Class<? extends PipelineContext>, List<Class<? extends ContextHandler<? extends PipelineContext>>>> PIPELINE_ROUTE_MAP
            = new HashMap<>(4);

    //设置PIPELINE_ROUTE_MAP为哪些类，以及正确配置处理器顺序
    static {
        PIPELINE_ROUTE_MAP.put(InstanceBuildContext.class,
                Arrays.asList(
                        InputDataPreChecker.class,
                        ModelInstanceCreator.class,
                        ModelInstanceSaver.class
                ));
    }



    @Bean(name = "pipelineRouteMap")
    public Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? extends PipelineContext>>> getHandlerPipelineMap() {
        return PIPELINE_ROUTE_MAP.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, this::toPipeline));
    }

    /**
     * 根据给定的管道中 ContextHandler 的类型的列表，构建管道
     */
    private List<? extends ContextHandler<? extends PipelineContext>> toPipeline(
            Map.Entry<Class<? extends PipelineContext>, List<Class<? extends ContextHandler<? extends PipelineContext>>>> entry) {
        return entry.getValue()
                .stream()
                .map(appContext::getBean)
                .collect(Collectors.toList());
    }

    private ApplicationContext appContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      this.appContext = applicationContext;
    }
}
