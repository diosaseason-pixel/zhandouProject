package com.game.storage.model;

import com.game.attr.Attr;
import com.game.common.model.BattleObject;
import lombok.Getter;
import lombok.Setter;

/**
 * 物品对象类，包含物品的所有属性
 */
@Getter
@Setter
public class ItemObject extends BattleObject {

    public ItemObject(int objId) {
        super(objId);
    }

    @AttrField(Attr.Item.ItemType)
    private int itemType;

    @AttrField(Attr.Item.ItemIdx)
    private int ItemIdx;

    @AttrField(value = Attr.Item.ItemId, isString = true)
    private String itemId;

    @AttrField(Attr.Item.Count)
    private int count;

    @AttrField(Attr.Item.SavePos)
    private int savePos;

    @AttrField(Attr.Item.Bound)
    private int bound;

    @AttrField(Attr.Item.AddLimit)
    private int addLimit;

    @AttrField(Attr.Item.ItemOwner)
    private int itemOwner;

    @AttrField(Attr.Item.Affix)
    private int affix;

    @AttrField(Attr.Item.RandomAffix)
    private int randomAffix;

    @AttrField(Attr.Item.Dura)
    private int dura;

    @AttrField(Attr.Item.StrengthenLevel)
    private int strengthenLevel;

    @AttrField(Attr.Item.ConciseExp)
    private int conciseExp;

    @AttrField(Attr.Item.HuntStatus)
    private int huntStatus;

    @AttrField(Attr.Item.HuntPosX)
    private int huntPosX;

    @AttrField(Attr.Item.HuntPosY)
    private int huntPosY;

    @AttrField(Attr.Item.EquipPos)
    private int equipPos;

    @AttrField(Attr.Item.SpiritLv)
    private int spiritLv;

    @AttrField(Attr.Item.SpiritStable)
    private int spiritStable;

    @AttrField(Attr.Item.BoundSpiritId)
    private int boundSpiritId;

    @AttrField(Attr.Item.SpiritSkillId)
    private int spiritSkillId;

    @AttrField(Attr.Item.LianHuaTemp)
    private int lianHuaTemp;

    @AttrField(value = Attr.Item.WeaponProp, isString = true)
    private String weaponProp;

    @AttrField(Attr.Item.LianBaoRandomProp)
    private int lianBaoRandomProp;

    @AttrField(Attr.Item.LianBaoProp)
    private int lianBaoProp;

    @AttrField(Attr.Item.LianBaoWorld)
    private int lianBaoWorld;

    @AttrField(Attr.Item.LianBaoPropLib)
    private int lianBaoPropLib;

    @AttrField(Attr.Item.WeaponEffect)
    private int weaponEffect;

    @AttrField(Attr.Item.HeartLevel)
    private int heartLevel;

    @AttrField(Attr.Item.FireAffix)
    private int fireAffix;

    @AttrField(Attr.Item.RealQuality)
    private int realQuality;

    @AttrField(Attr.Item.IsNpcPardon)
    private int isNpcPardon;

    @AttrField(Attr.Item.MagicLevel)
    private int magicLevel;

    @AttrField(Attr.Item.SelfWeaponStar)
    private int selfWeaponStar;

    @AttrField(Attr.Item.MagicFireLevel)
    private int magicFireLevel;

    @AttrField(Attr.Item.CreateTime)
    private int createTime;

    @AttrField(Attr.Item.ReceivedBookExp)
    private int receivedBookExp;

    @AttrField(Attr.Item.HeroEquipLevel)
    private int heroEquipLevel;

    @AttrField(Attr.Item.HeroEquipBroken)
    private int heroEquipBroken;

    @AttrField(Attr.Item.SpiritIsBroken)
    private int spiritIsBroken;

    @AttrField(Attr.Item.HeroEquipProp)
    private int heroEquipProp;

    public void setBind(int bind) {
        if (bind > 0) {
            this.bound |= 0x1;  // 设置第0位为1
        } else {
            this.bound &= ~0x1;  // 清除第0位
        }
    }

    public int getBind() {
        return this.bound & 0x1;  // 获取第0位
    }
}
