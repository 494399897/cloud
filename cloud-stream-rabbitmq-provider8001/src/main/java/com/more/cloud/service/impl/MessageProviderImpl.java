package com.more.cloud.service.impl;

import com.more.cloud.common.MyMessage;
import com.more.cloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    StreamBridge streamBridge;


    @Override
    public String send(String msg) {
        MyMessage myMessage = new MyMessage();
        myMessage.setPayload(msg);
        streamBridge.send("myBroadcast-out-0",myMessage);
        return "success";
    }
}
