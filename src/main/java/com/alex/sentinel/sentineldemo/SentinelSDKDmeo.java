package com.alex.sentinel.sentineldemo;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2020-03-26
 */
public class SentinelSDKDmeo {
    private static String RESOURSE = "mySource";
    public static void initFlowRules(){
        List<FlowRule> list = new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        flowRule.setResource(RESOURSE);
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setCount(20);
        list.add(flowRule);
        FlowRuleManager.loadRules(list);
    }

    public static void main(String[] args) {
        initFlowRules(); //初始化一个规则
        while (true) {
            // 1.5.0 版本开始可以直接利用 try-with-resources 特性，自动 exit entry
            try (Entry entry = SphU.entry(RESOURSE)) {
                // 被保护的逻辑
                System.out.println("hello world");
            } catch (BlockException ex) {
                // 处理被流控的逻辑
                System.out.println("blocked!");
            }
        }
    }
}
