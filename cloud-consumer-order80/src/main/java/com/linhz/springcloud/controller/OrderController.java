package com.linhz.springcloud.controller;

import com.linhz.springcloud.entity.CommonResult;
import com.linhz.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
//    private String PAYMENT_URL = "http://localhost:8001"; 不能写死，需要从注册中心获取
    private String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; // 从注册中心获取服务的详细地址

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/"+id, CommonResult.class);
    }
}
