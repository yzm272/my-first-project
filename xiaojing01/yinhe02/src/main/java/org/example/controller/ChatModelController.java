package org.example.controller;

import jakarta.annotation.Resource;
//import org.example.interface2.ChatModel1;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@CrossOrigin
@RestController
public class ChatModelController {
    @Resource
    private ChatModel chatModel1;
    @GetMapping(value="/hello/dochat")
    public String  doChat(@RequestParam (name="msg",defaultValue = "请问你是谁") String msg){
        System.out.println(msg);
        String   result=chatModel1.call(msg);
        return result;

    }

    /**
     * 流式调用
     * @param msg
     * @return
     */
    @GetMapping(value="/hello/streamchat")
    public Flux<String> stream(@RequestParam (name="msg",defaultValue = "请问你是谁") String msg){
        System.out.println(msg);
        return chatModel1.stream(msg);

    }

}
