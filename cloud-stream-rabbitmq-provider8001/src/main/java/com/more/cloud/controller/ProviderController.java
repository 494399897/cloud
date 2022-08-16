package com.more.cloud.controller;

import com.more.cloud.common.MyMessage;
import com.more.cloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    private IMessageProvider iMessageProvider;

    @Autowired
    StreamBridge streamBridge;

    @GetMapping("send")
    public String send(String msg) {

        return iMessageProvider.send(msg);
    }

    /**
     *
     * @param body
     * @return
     */

    @PostMapping("/group")
    public String
    sendGroupMessage(@RequestParam("body") String body) {
        MyMessage myMessage = new MyMessage();
        myMessage.setPayload(body);
        // 生产消息
        streamBridge.send("myGroup-out-0", myMessage);
        return "SUCCESS";
    }

}
