package com.json.test;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author jiangkuan
 * @description 订单系统发送的在线支付信息
 * @create 2018/9/3
 */
@Data
@Accessors(chain = true)
public class OnlinePaymentMQDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 支付单号
     */
    private String paymentNo;
    /**
     * 三方支付流水号
     */
    private String outTradeNo;
    /**
     * 交易流水号
     */
    private String tradeNo;
    /**
     * 0 账期 1 支付宝 2 微信
     */
    private Integer payMethod;
    /**
     * 支付金额
     */
    private BigDecimal payAmount;
    /**
     * 修理厂ID
     */
    private String repairId;
    /**
     * 修理厂名称
     */
    private String repairName;
    /**
     * 订单创支付时间
     */
    private Long payTime;

}
