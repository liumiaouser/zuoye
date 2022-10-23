package com.example.demo.mq;

public interface GoodsSink {

    String GOODS_INPUT = "goods_input";

    @Input(GoodsSink.GOODS_INPUT)
    SubscribableChannel input();

}
