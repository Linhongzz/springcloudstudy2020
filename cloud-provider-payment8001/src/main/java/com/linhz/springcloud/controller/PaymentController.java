package com.linhz.springcloud.controller;

import com.linhz.springcloud.entity.CommonResult;
import com.linhz.springcloud.entity.Payment;
import com.linhz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("************数据库插入结果"+result+"*********");
        if (result > 0) {
            return new CommonResult<>(200, "插入数据库成功 port: "+port, result);
        } else {
            return new CommonResult<>(444, "插入数据库失败 port: "+port);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("************数据库查询结果"+payment+"*********");
        int i=10/2;
        log.info(String.valueOf(i));
        if (payment!=null) {
            return new CommonResult<>(200, "成功 port: "+port,payment);
        } else {
            return new CommonResult<>(444, "没有id为"+id+"的数据"+" port: "+port);
        }
    }
}
