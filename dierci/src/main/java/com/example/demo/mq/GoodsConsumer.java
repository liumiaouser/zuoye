package com.example.demo.mq;

/**
 * 消息监听消费
 *
 * @author yanglei
 */
@EnableBinding(GoodsSink.class)
@Slf4j
public class GoodsConsumer {

    @StreamListener(GoodsSink.GOODS_INPUT)
    public void onReceive(String shopJson) {
        log.info(shopJson);
    }
}
