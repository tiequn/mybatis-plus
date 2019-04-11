package com.gz.xuezi.util;

public enum ErrorCode {

    paramError(1, "参数错误！"),
    dbError(2, "数据库操作错误！"),
    userNoLogin(3, "用户未登录！"),
    serverError(4, "服务器异常"),
    BatchNameError(5, "输入的批次名和Excel批次名不一致!"),
    importExcelError(6, "导入Excel打款金额与系统统计不一致"),
    MasterOrderAddFailed(7 , "主订单添加失败"),
    AddUserFailed(8, "添加人员失败"),
    AddBankFailed(9, "添加银行卡失败"),
    AddChildOrderFailed(10, "添加子订单失败"),
    BatchFileMaximumSupport(11, "单个批次文件最大支持1000条订单"),
    WrongAmount(12, "打款金额错误"),
    IdCardError(13, "身份证号错误请查证"),
    CompanyIdError(14, "公司Id有误"),
    AmountOfPaymentError(15, "打款金额小于0"),
    informationDoesNotExist(16, "该子订单信息不存在"),
    NameCannotBeEmpty(17, "姓名不能为空"),
    DocumentTypeCannotBeEmpty(18, "证件类型不能为空"),
    IdCardCannotBeEmpty(19, "证件号不能为空"),
    BankCardCannotBeEmpty(20, "银行卡号不能为空"),
    BankCannotBeEmpty(21, "所属银行不能为空"),
    ChildOrdersCannotBeEmpty(22, "子订单不能为空"),
    TheWhiteListAlreadyExistsPleaseCheck(23, "该白名单已存在请查证"),
    ThePersonDoesNotExist(24, "该人员不存在"),
    TypeCertificateCannotBeEmpty(25, "证件类型不能为空"),
    CompanyServiceStatus(26, "公司服务状态暂停或已终止"),
    ExcelInconsistent(27, "Excel总笔数和被打款人数不一致"),


    //
    ;

    private int code;

    private String desc;

    ErrorCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
