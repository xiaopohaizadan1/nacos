package com.example.demo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaNacosDiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosDiscoveryServerApplication.class, args);
    }

    @Slf4j
    @RestController
    static class TestController {
        @GetMapping("/hello")
        public String hello(@RequestParam String name) {
            log.info("invoked name = " + name);
            return "hello " + name;
        }

        @PostMapping("/hi")
        public HiForm hi(@RequestBody HiForm hiForm) {
            hiForm.setName(hiForm.getName()+"----------");
            return hiForm;
        }
    }
}

@Data
class HiForm {
    private String name;
}