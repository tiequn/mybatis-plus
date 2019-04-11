package com.gz.xuezi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 子订单表（可以用于批量打款查看详情，交易订单查看详情， 服务账户查看详情，资金流水）
 * </p>
 *
 * @author gjb
 * @since 2019-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ChildOrder对象", description="子订单表（可以用于批量打款查看详情，交易订单查看详情， 服务账户查看详情，资金流水）")
public class ChildOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "子订单表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "主订单表id")
    private Long mainOrderId;

    @ApiModelProperty(value = "转账订单号，系统生成，全局唯一，不同环境加不同的后缀。名称采用银行接口定义")
    private String tranOrderNumber;

    @ApiModelProperty(value = "人员姓名")
    private String employeeName;

    @ApiModelProperty(value = "证件类型，1,居民身份证, 2,中国护照, 3,港澳居民来往内地通行证, 4,台湾居民来往大陆通行证, 5,外国护照, 6,外国人永久居留身份证（外国人永久居留证）, 7,中华人民共和国港澳居民居住证, 8,中华人民共和国台湾居民居住证, 9,中华人民共和国外国人工作许可证（A类）, 10,中华人民共和国外国人工作许可证（B类）,11,中华人民共和国外国人工作许可证（C类）, 12,其他个人证件, 13, 无证件")
    private String documentType;

    @ApiModelProperty(value = "证件号")
    private String idCard;

    @ApiModelProperty(value = "所属银行")
    private String belongsBank;

    @ApiModelProperty(value = "银行卡号")
    private String bankCard;

    @ApiModelProperty(value = "商户打款金额，单位为分（获取之后需要前端转换为元）")
    private Long amountMoney;

    @ApiModelProperty(value = "实际打款金额")
    private Long amountMoneyReal;

    @ApiModelProperty(value = "应扣缴税额")
    private Long taxPayable;

    @ApiModelProperty(value = "预估服务费，单位为分（获取之后需要前端转换为元）")
    private Long serviceEstimate;

    @ApiModelProperty(value = "实际已扣除服务费，单位为分（获取之后需要前端转换为元）")
    private Long service;

    @ApiModelProperty(value = "累计补收服务费")
    private Long accumulatedServiceFee;

    @ApiModelProperty(value = "审核状态, 1，----，2，等待审核，3，已驳回，4，审核通过；")
    private Integer reviewStatus;

    @ApiModelProperty(value = "打款状态，1：----，2：打款中，3：打款失败，4：打款成功, 5:撤销打款")
    private Integer moneyStatus;

    @ApiModelProperty(value = "效验状态。0：信息无误；1：身份证信息有误；2：打款金额错误，3：白名单不匹配, 4:银行卡信息错误，5: 信息不完整，6：证件号码不唯一，7：银行卡号不唯一, 8: 单次打款超额，9：单人单月累计打款金额超额，10：人/卡/证不匹配, 11,失败原因, 12, 初始值，13, 服务费错误")
    private Integer efficacyState;

    @ApiModelProperty(value = "效验状态信息, 前端获取状态使用")
    private String message;

    @ApiModelProperty(value = "失败原因")
    private String failReason;

    @ApiModelProperty(value = "结算金额")
    private Long settlementAmount;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "逻辑删除  值为1代表删除")
    private Integer isDeleted;

    @ApiModelProperty(value = "和employee三要素对比状态（效验三要素使用）, 0，未与employee对比 ，1，employee表该人员不存在，2，与employee表效验成功，")
    private Integer employeeStatus;

    @ApiModelProperty(value = "打款成功时间（用于计算）")
    private LocalDateTime gmtMoney;

    @ApiModelProperty(value = "转账ID。即salaray_transfer.id")
    private Long transferId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime gmtModify;


}
