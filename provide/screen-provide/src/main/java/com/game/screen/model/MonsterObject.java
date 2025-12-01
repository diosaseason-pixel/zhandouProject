package com.game.screen.model;

import com.game.attr.Attr;
import com.game.common.model.BattleObject;
import lombok.Getter;
import lombok.Setter;


/**
 * 怪物属性 继承自Battle
 */
@Getter
@Setter
public class MonsterObject extends BattleObject {

    public MonsterObject(int objId) {
        super(objId);
    }

    @AttrField(Attr.Monster.MonsterIdx)
    int monsterIdx;

    @AttrField(Attr.Monster.GradeType)
    int gradeType;

    @AttrField(Attr.Monster.MonsterType)
    int monsterType;

    @AttrField(value = Attr.Monster.MonsterName, isString = true)
    String monsterName;

    @AttrField(Attr.Monster.RobotId)
    int robotId;
}
