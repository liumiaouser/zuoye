package com.example.demo.mq;

@RestController
@RequestMapping("test")
@Api(tags="sku表,表示具体的商品实体")
public class TestController {

    @Autowired
    private GoodsProducer goodsProducer;

    @GetMapping("send")
    @ApiOperation("信息")
    public void get(){
        goodsProducer.sendMessage("我发送了一条消息");
    }

}