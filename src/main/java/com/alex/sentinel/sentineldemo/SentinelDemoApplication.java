package com.alex.sentinel.sentineldemo;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class SentinelDemoApplication {

    public static void main(String[] args) {
        initFlowRules();
        SpringApplication.run(SentinelDemoApplication.class, args);
    }

    public static void initFlowRules(){
       // List<FlowRule> list = new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        //flowRule.setResource("say");
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setCount(20);
        //flowRule.setLimitApp("sentinel-web");
        //list.add(flowRule);
        FlowRuleManager.loadRules(Collections.singletonList(flowRule));



    }

}
