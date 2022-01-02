package com.yan.pipeline;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @Author yan.zhang
 * @Date 2022/1/2 22:19
 * @Version 1.0
 */
@Getter
@Setter
public class PipelineContext {
    /**
     * 处理开始时间
     */
    private LocalDateTime startTime;

    /**
     * 处理结束时间
     */
    private LocalDateTime endTime;

    /**
     * 获取数据名称
     */
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
