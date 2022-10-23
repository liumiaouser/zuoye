package com.example.demo.mq;


/**
 * 发送消息通道
 *
 * @author yanglei
 */
public interface GoodsSource {

    String GOODS_OUTPUT = "goods_output";

    @Output(GoodsSource.GOODS_OUTPUT)
    MessageChannel output();


}








