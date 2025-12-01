package com.game.storage.execl;

import com.alibaba.excel.annotation.ExcelProperty;
import com.game.common.entity.PropEntity;
import com.game.common.execl.convert.PropConverter;
import com.game.execl.ExcelFile;
import lombok.Data;

@Data
@ExcelFile(fileName = "Weapon.csv")
public class WeaponTable {

    @ExcelProperty(index = 0)
    private int id;

    @ExcelProperty(index = 1)
    private String name;

    @ExcelProperty(index = 2)
    private int type;

    @ExcelProperty(index = 3)
    private int position;

    @ExcelProperty(index = 4)
    private int elementType;

    @ExcelProperty(index = 5)
    private int iconId;

    @ExcelProperty(index = 6)
    private int iconEffect;

    @ExcelProperty(index = 7)
    private int sceneEffect;

    @ExcelProperty(index = 8)
    private int modleId;

    @ExcelProperty(index = 9)
    private int paintingId;

    @ExcelProperty(index = 10)
    private int quality;

    @ExcelProperty(index = 11)
    private String score;

    @ExcelProperty(index = 12)
    private int labelLv;

    @ExcelProperty(index = 13)
    private int itemStage;

    @ExcelProperty(index = 14)
    private int itemGrade;

    @ExcelProperty(index = 15)
    private int needLv;

    @ExcelProperty(index = 16)
    private String needPot;

    @ExcelProperty(index = 17)
    private int transBound;

    @ExcelProperty(index = 18)
    private String price;

    @ExcelProperty(index = 19)
    private String access;

    @ExcelProperty(index = 20)
    private int isQuickUse;

    @ExcelProperty(index = 21, converter = PropConverter.class)
    private PropEntity propMin;

    @ExcelProperty(index = 22, converter = PropConverter.class)
    private PropEntity propMax;

    @ExcelProperty(index = 23)
    private int affixNum;

    @ExcelProperty(index = 24)
    private String affixLibrary;

    @ExcelProperty(index = 25)
    private int exraNum1;

    @ExcelProperty(index = 26)
    private String exraLibrary1;

    @ExcelProperty(index = 27)
    private int exraNum2;

    @ExcelProperty(index = 28)
    private String exraLibrary2;

    @ExcelProperty(index = 29)
    private String skillList;

    @ExcelProperty(index = 30)
    private String description;

    @ExcelProperty(index = 31)
    private int currencyType;

    @ExcelProperty(index = 32)
    private String priceMoneyInterval;

    @ExcelProperty(index = 33)
    private String randomAffix;

    @ExcelProperty(index = 34)
    private int intensify;

    @ExcelProperty(index = 35)
    private int initStrengthenLevel;

    @ExcelProperty(index = 36)
    private String devourCost;

    @ExcelProperty(index = 37)
    private int maxConcise;

    @ExcelProperty(index = 38)
    private int baseExp;

    @ExcelProperty(index = 39)
    private int conversionRate;

    @ExcelProperty(index = 40)
    private String removeCost;

    @ExcelProperty(index = 41)
    private String getSpirit;
}