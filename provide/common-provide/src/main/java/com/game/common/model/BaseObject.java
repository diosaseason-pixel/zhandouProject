package com.game.common.model;

import com.game.attr.Attr;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseObject extends SceneObject {

    @AttrField(Attr.Base.Sex)
    int sex;

    @AttrField(Attr.Base.Level)
    int level;

    @AttrField(Attr.Base.ModelId)
    int modelId;

    @AttrField(Attr.Base.HairId)
    int hairId;

    @AttrField(Attr.Base.Eye)
    int eye;

    @AttrField(Attr.Base.BodyId)
    int bodyId;

    public BaseObject(int objId) {
        super(objId);
    }

}
