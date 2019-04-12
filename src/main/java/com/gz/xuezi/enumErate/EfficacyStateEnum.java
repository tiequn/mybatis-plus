package com.gz.xuezi.enumErate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum EfficacyStateEnum {

    /**
     * 信息无误
     */
    InformationIsCorrect(0, "信息无误"),
    IDCardInformationIsIncorrect(1, "身份证信息有误"),
    WrongAmount(2,"打款金额错误"),
    WhitelistDoesNotMatch(3,"白名单不匹配"),
    BankCardInformationError(4,"银行卡信息错误"),
    IncompleteInformation(5,"信息不完整"),
    IDNumberIsNotUnique(6,"证件号码不唯一"),



    ;
    private int code;

    private String desc;

    EfficacyStateEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public static String getCardDesc(int code){
        for (EfficacyStateEnum cardTypeEnum : values()) {
            if(code == cardTypeEnum.getCode()){
                return cardTypeEnum.getDesc();
            }
        }
        return IncompleteInformation.getDesc();
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    private static final Map<Integer, EfficacyStateEnum> CACHE;

    static {
        Map<Integer, EfficacyStateEnum> map = new HashMap<>();
        for (EfficacyStateEnum orderStatusEnum : EfficacyStateEnum.values()) {
            map.put(orderStatusEnum.getCode(), orderStatusEnum);
        }
        CACHE = Collections.unmodifiableMap(map);
    }

    public static EfficacyStateEnum valueOfByCode(Integer code) {
        return CACHE.get(code);
    }

}
