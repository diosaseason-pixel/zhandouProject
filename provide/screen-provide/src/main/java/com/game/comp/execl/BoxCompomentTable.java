package com.game.comp.execl;

import com.alibaba.excel.annotation.ExcelProperty;
import com.game.execl.ExcelFile;
import lombok.Data;

@Data
@ExcelFile(fileName = "BoxCompoment.csv")
public class BoxCompomentTable {
    
    @ExcelProperty(index = 0)
    private int id;
    
    @ExcelProperty(index = 1)
    private String name;
    
    @ExcelProperty(index = 2)
    private int interactButtonType;
    
    @ExcelProperty(index = 3)
    private int componentType;
    
    @ExcelProperty(index = 4)
    private int mergeId;
    
    @ExcelProperty(index = 5)
    private int isMergeShowPos;
    
    @ExcelProperty(index = 6)
    private int boxType;
    
    @ExcelProperty(index = 7)
    private int paintId;
    
    @ExcelProperty(index = 8)
    private int actorType;
    
    @ExcelProperty(index = 9)
    private String figure;
    
    @ExcelProperty(index = 10)
    private int scale;
    
    @ExcelProperty(index = 11)
    private int headType;
    
    @ExcelProperty(index = 12)
    private String head;
    
    @ExcelProperty(index = 13)
    private int level;
    
    @ExcelProperty(index = 14)
    private int direction;
    
    @ExcelProperty(index = 15)
    private int mapId;
    
    @ExcelProperty(index = 16)
    private int xpos;
    
    @ExcelProperty(index = 17)
    private int ypos;
    
    @ExcelProperty(index = 18)
    private int show;
    
    @ExcelProperty(index = 19)
    private String blockRange;
    
    @ExcelProperty(index = 20)
    private int useTimes;
    
    @ExcelProperty(index = 21)
    private int dailyLimit;
    
    @ExcelProperty(index = 22)
    private int interactDistance;
    
    @ExcelProperty(index = 23)
    private String text;
    
    @ExcelProperty(index = 24)
    private String dialog;
    
    @ExcelProperty(index = 25)
    private String buttonChoose;
    
    @ExcelProperty(index = 26)
    private int isReading;
    
    @ExcelProperty(index = 27)
    private int xposPoint;
    
    @ExcelProperty(index = 28)
    private int yposPoint;
    
    @ExcelProperty(index = 29)
    private int effectLoopId;
    
    @ExcelProperty(index = 30)
    private int animationId;
    
    @ExcelProperty(index = 31)
    private int effectAppearId;
    
    @ExcelProperty(index = 32)
    private int appearDuration;
    
    @ExcelProperty(index = 33)
    private int effectLoopX;
    
    @ExcelProperty(index = 34)
    private int effectLoopY;
    
    @ExcelProperty(index = 35)
    private int sweepId;
    
    @ExcelProperty(index = 36)
    private int sweepBgId;
    
    @ExcelProperty(index = 37)
    private int wordShowId;
    
    @ExcelProperty(index = 38)
    private int duplicateRefreshId;
    
    @ExcelProperty(index = 39)
    private int rowid;
} 