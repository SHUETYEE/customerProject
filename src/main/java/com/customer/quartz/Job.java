package com.customer.quartz;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;

/**
 * @author 李靖宇
 * @Project customerProject
 * @date 2019/12/4 13:20
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@Configuration
@EnableScheduling
public class Job implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {

            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                String corn="0/5 * * * * ?";
                return new CronTrigger(corn).nextExecutionTime(triggerContext);
            }
        });
    }
}
