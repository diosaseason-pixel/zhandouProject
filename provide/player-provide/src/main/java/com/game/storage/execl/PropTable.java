package com.game.storage.execl;


import com.alibaba.excel.annotation.ExcelProperty;
import com.game.common.execl.MetaWrapItem;
import com.game.common.execl.convert.WrapItemConverter;
import com.game.execl.ExcelFile;
import lombok.Data;

@Data
@ExcelFile(fileName = "Prop.csv")
public class PropTable {

    @ExcelProperty(index = 0)
    private int id;

    @ExcelProperty(index = 1)
    private String name;

    @ExcelProperty(index = 2)
    private int kind;

    @ExcelProperty(index = 3)
    private int type;

    @ExcelProperty(index = 4)
    private int labelType;

    @ExcelProperty(index = 5)
    private int labelLv;

    @ExcelProperty(index = 6)
    private int rightLabelType;

    @ExcelProperty(index = 7)
    private int iconId;

    @ExcelProperty(index = 8)
    private int iconEffect;

    @ExcelProperty(index = 9)
    private int sceneEffect;

    @ExcelProperty(index = 10)
    private String score;

    @ExcelProperty(index = 11)
    private int itemStage;

    @ExcelProperty(index = 12)
    private int quality;

    @ExcelProperty(index = 13)
    private int needLv;

    @ExcelProperty(index = 14)
    private int limit;

    @ExcelProperty(index = 15)
    private int useTime;

    @ExcelProperty(index = 16)
    private String confirmDes;

    @ExcelProperty(index = 17)
    private String typeValue;

    @ExcelProperty(index = 18)
    private int addLimit;

    @ExcelProperty(index = 19)
    private int timeLimitType;

    @ExcelProperty(index = 20)
    private int timeLimit;

    @ExcelProperty(index = 21, converter = WrapItemConverter.class)
    private MetaWrapItem price;

    @ExcelProperty(index = 22)
    private String access;

    @ExcelProperty(index = 23)
    private int isQuickUse;

    @ExcelProperty(index = 24)
    private String description;

    @ExcelProperty(index = 25)
    private int quickBuyId;

    @ExcelProperty(index = 26)
    private int currencyType;

    @ExcelProperty(index = 27)
    private String priceMoneyInterval;

    @ExcelProperty(index = 28)
    private int rowid;

}
