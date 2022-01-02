package com.yan.pipeline;

/**
 * @Author yan.zhang
 * @Date 2022/1/2 22:22
 * @Version 1.0
 */

public interface ContextHandler<T extends PipelineContext> {
    /**
     * 管道上下文处理器
     * 处理输入的上下文数据
     *
     * @param context 处理时的上下文数据
     * @return 返回 true 则表示由下一个 ContextHandler 继续处理，返回 false 则表示处理结束
     */
    boolean handle(T context);
}
