package com.gz.xuezi.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 主订单表（可以用于批量打款，交易订单，服务账户）
 * </p>
 *
 * @author gjb
 * @since 2019-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MainOrder对象", description="主订单表（可以用于批量打款，交易订单，服务账户）")
public class MainOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主订单表id")
    private Long id;

    @ApiModelProperty(value = "打款批次名称，Excel上传文件名")
    private String nameBatch;

    @ApiModelProperty(value = "费用合计打款成功的值，单位为分（获取之后需要前端转换为元）")
    private Long totalCosts;

    @ApiModelProperty(value = "费用合计预估值，单位为分（获取之后需要前端转换为元）")
    private Long totalCostEstimate;

    @ApiModelProperty(value = "实际打款金额，已扣取费用(打款成功扣取的费用)")
    private Long deductedFee;

    @ApiModelProperty(value = "Excel打款金额，单位为分（获取之后需要前端转换为元）")
    private Long amountMoney;

    @ApiModelProperty(value = "应扣缴税额")
    private Long taxPayable;

    @ApiModelProperty(value = "服务费，单位为分（获取之后需要前端转换为元）")
    private Long service;

    @ApiModelProperty(value = "预估服务费，单位为分（获取之后需要前端转换为元）")
    private Long serviceEstimate;

    @ApiModelProperty(value = "提交人数")
    private Long submitNumber;

    @ApiModelProperty(value = "有效订单数，也是发放总数")
    private Long successfulNumber;

    @ApiModelProperty(value = "发放成功数")
    private Long number;

    @ApiModelProperty(value = "发放失败数")
    private Long failNumberIssues;

    @ApiModelProperty(value = "效验失败人数")
    private Long failureVerify;

    @ApiModelProperty(value = "审核失败人数")
    private Long reviewFailure;

    @ApiModelProperty(value = "公司id")
    private Long companyId;

    @ApiModelProperty(value = "企业名称")
    private String companyName;

    @ApiModelProperty(value = "打款渠道, 默认为银行卡，1：银行卡")
    private Integer moneyChannel;

    @ApiModelProperty(value = "订单状态, 1：待提交订单；2, 待审核，3：审核通过、待确认打款, 4, 已确认打款、打款中，5，已完成，6，已关闭；")
    private Integer orderStatus;

    @ApiModelProperty(value = "上传Excel状态，1，正在计算，2，计算成功，3：计算失败")
    private Integer excelStatus;

    @ApiModelProperty(value = "后台订单提示；1，单人单月超额或单人单次超额，2，该订单打款人有在其他批次中处于打款中")
    private String backgroundPrompt;

    @ApiModelProperty(value = "操作人")
    private Long userId;

    @ApiModelProperty(value = "修改人")
    private Long modify;

    @ApiModelProperty(value = "允许打款时间(用于倒计时、计算，允许打款时需要更新)")
    private LocalDateTime gmtAllowMoney;

    @ApiModelProperty(value = "已锁定余额。单位：分")
    private Long lockedBalanceCent;

    @ApiModelProperty(value = "撤销状态；0，未撤销；1，已撤销")
    private Integer cancelStatus;

    @ApiModelProperty(value = "离线数据状态，0，线上数据；1，为线下上传数据")
    private Integer offlineData;

    @ApiModelProperty(value = "线下确认累计金额，0，未确认；1，确认")
    private Integer cumulativeGoldStatus;

    @ApiModelProperty(value = "确认打款时间")
    private LocalDateTime gmtTimePayment;

    @ApiModelProperty(value = "提交订单时间")
    private LocalDateTime gmtOrder;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime gmtModify;


}
