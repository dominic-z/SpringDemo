package demo.controllers;

import demo.components.Banana1;
import demo.components.Banana2;
import demo.messages.MyRequest;
import demo.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dominiczhu
 * @date 2020/8/12 10:20 上午
 */

//@RestController
public class HelloController {
    @Resource(name = "singleBanana1")
    Banana1 banana1;

    @Autowired
    @Qualifier("singleBanana2")
    Banana2 banana2;
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "hello", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello(@RequestBody MyRequest req) {
        String res = helloService.sayHello();
        return res;
    }

}