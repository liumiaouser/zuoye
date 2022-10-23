package com.example.demo.mq;

/**
 * 消息发送
 *
 * @author yanglei
 */
@EnableBinding(GoodsSource.class)
public class GoodsProducer {

    @Autowired
    private GoodsSource source;

    public void sendMessage(String msg) {
        try {
            source.output().send(MessageBuilder.withPayload(msg).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}