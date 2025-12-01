package com.game.common.execl;

public class MetaWrapItem {
    int[] data;

    public MetaWrapItem(int[] data) {
        this.data = data;
    }

    public Integer getItemType() {
        return data[0];
    }

    public Integer getItemIdx() {
        return data[1];
    }

    public Integer getItemNum() {
        return data[2];
    }

    public Integer getItemBind() {
        return data[3];
    }


}