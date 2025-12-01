package com.game;

import cn.hutool.core.util.HexUtil;
import com.game.common.proto.PbObjProperty;
import com.game.common.proto.PbPerProperty;
import com.game.comp.proto.PbAssemblyListNtf;
import com.game.role.proto.PbRoleLoginResp;
import com.game.storage.proto.PbItemChangeNtf;
import com.game.storage.proto.PbPackageItemNtf;
import com.google.gson.Gson;
import com.iohao.game.action.skeleton.core.DataCodecKit;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ProtoTest {

    // 首次创建角色的 PbObjProperty
    @Test
    public void ObjPropertyTest() {
        String hex = "08 A1 86 BD 8F 01 1A 0C 08 87 08 11 8A 3E 00 00 00 00 00 00 1A 0B 08 35 11 05 00 00 00 00 00 00 00 1A 0C 08 A2 02 11 0C 00 00 00 00 00 00 00 1A 0C 08 CA 01 11 58 02 00 00 00 00 00 00 1A 0C 08 AC 0A 11 04 00 00 00 00 00 00 00 1A 0B 08 70 11 B2 01 00 00 00 00 00 00 1A 0C 08 80 08 11 64 00 00 00 00 00 00 00 1A 0C 08 82 01 11 88 13 00 00 00 00 00 00 1A 0C 08 BC 0A 11 01 00 00 00 00 00 00 00 1A 0B 08 74 11 64 00 00 00 00 00 00 00 1A 0C 08 89 08 11 51 46 00 00 00 00 00 00 1A 0C 08 D4 09 11 01 00 00 00 00 00 00 00 1A 0C 08 88 01 11 0B 00 00 00 00 00 00 00 1A 0C 08 A7 02 11 0C 00 00 00 00 00 00 00 1A 0C 08 EE 07 11 F6 40 00 00 00 00 00 00 1A 0C 08 EB 09 11 11 06 00 00 00 00 00 00 1A 0D 08 03 1A 09 E5 92 B8 E4 BB A5 E5 8D 97 1A 0C 08 85 01 11 0B 00 00 00 00 00 00 00 1A 0C 08 B9 08 11 48 EE 00 00 00 00 00 00 1A 0B 08 39 11 9E 3A 00 00 00 00 00 00 1A 0B 08 79 11 26 00 00 00 00 00 00 00 1A 0C 08 E9 07 11 96 A5 00 00 00 00 00 00 1A 0C 08 9F 09 11 01 00 00 00 00 00 00 00 1A 0C 08 86 01 11 0B 00 00 00 00 00 00 00 1A 0B 08 75 11 01 00 00 00 00 00 00 00 1A 0C 08 89 01 11 0B 00 00 00 00 00 00 00 1A 0C 08 84 08 11 CB 32 00 00 00 00 00 00 1A 0C 08 CB 01 11 58 02 00 00 00 00 00 00 1A 0C 08 BA 08 11 05 00 00 00 00 00 00 00 1A 0B 08 34 11 02 00 00 00 00 00 00 00 1A 0C 08 AD 0A 11 BD 20 06 68 00 00 00 00 1A 0C 08 98 02 11 0C 00 00 00 00 00 00 00 1A 0C 08 DC 09 11 01 00 00 00 00 00 00 00 1A 0B 08 6F 11 B2 01 00 00 00 00 00 00 1A 0C 08 B1 02 11 0C 00 00 00 00 00 00 00 1A 08 08 9F 08 1A 03 35 2C 36 1A 0C 08 F3 08 11 A4 B1 01 00 00 00 00 00 1A 0B 08 76 11 2A 00 00 00 00 00 00 00 1A 0C 08 87 01 11 0B 00 00 00 00 00 00 00 1A 0C 08 85 08 11 C5 36 00 00 00 00 00 00 1A 0B 08 77 11 1A 00 00 00 00 00 00 00 1A 0C 08 B1 08 11 49 00 00 00 00 00 00 00 1A 0C 08 F2 07 11 E8 7B CF B3 79 2D 00 00 1A 0C 08 8D 08 11 B4 AF 01 00 00 00 00 00 1A 75 08 E2 08 1A 70 7B 22 70 72 6F 74 65 63 74 22 3A 5B 7B 22 69 64 22 3A 31 2C 22 73 74 61 74 65 22 3A 35 30 30 30 2C 22 74 6F 67 67 6C 65 22 3A 31 7D 2C 7B 22 69 64 22 3A 32 2C 22 73 74 61 74 65 22 3A 35 30 30 30 2C 22 74 6F 67 67 6C 65 22 3A 30 7D 2C 7B 22 69 64 22 3A 33 2C 22 73 74 61 74 65 22 3A 35 30 30 30 2C 22 74 6F 67 67 6C 65 22 3A 31 7D 5D 7D 1A 0C 08 88 08 11 77 42 00 00 00 00 00 00 1A 0C 08 9D 02 11 0C 00 00 00 00 00 00 00 1A 0C 08 82 08 11 78 00 00 00 00 00 00 00 1A 0B 08 37 11 1A 27 00 00 00 00 00 00 1A 0B 08 6E 11 B2 01 00 00 00 00 00 00 1A 0C 08 B2 08 11 32 00 00 00 00 00 00 00 1A 0C 08 F3 0A 11 2A 09 00 00 00 00 00 00 1A 0B 08 F5 07 1A 06 31 30 33 3A 31 2C 1A 0C 08 D7 09 11 2C 01 00 00 00 00 00 00 1A 0C 08 89 0A 11 05 00 00 00 00 00 00 00 1A 0B 08 73 11 64 00 00 00 00 00 00 00 1A 0C 08 BC 08 11 01 00 00 00 00 00 00 00 1A 07 08 86 09 1A 02 5B 5D 1A 0C 08 8A 08 11 3E FD 04 68 00 00 00 00 1A 0C 08 D6 09 11 2C 01 00 00 00 00 00 00 1A 0C 08 85 0A 11 14 00 00 00 00 00 00 00 1A 0C 08 AC 02 11 0C 00 00 00 00 00 00 00 1A 0B 08 38 11 F1 2E 00 00 00 00 00 00 1A 0C 08 EE 09 11 01 00 00 00 00 00 00 00";
        byte[] bytes = HexUtil.decodeHex(hex.replace(" ", ""));

        PbObjProperty property = DataCodecKit.decode(bytes, PbObjProperty.class);
        log.info(property.toString());

        // property.objProps 根据 properCode 从小到大排序
        property.objProps.sort((o1, o2) -> {
            if (o1.properCode > o2.properCode) {
                return 1;
            } else if (o1.properCode < o2.properCode) {
                return -1;
            }
            return 0;
        });

        for (PbPerProperty prop : property.objProps) {
            log.info("id {} value {}", prop.properCode, prop.intValue);
        }
    }

    // 角色
    //        String hex = "08 A1 86 BD 8F 01 1A 0C 08 87 08 11 8A 3E 00 00 00 00 00 00 1A 0B 08 35 11 05 00 00 00 00 00 00 00 1A 0C 08 A2 02 11 0C 00 00 00 00 00 00 00 1A 0C 08 CA 01 11 58 02 00 00 00 00 00 00 1A 0C 08 AC 0A 11 04 00 00 00 00 00 00 00 1A 0B 08 70 11 B2 01 00 00 00 00 00 00 1A 0C 08 80 08 11 64 00 00 00 00 00 00 00 1A 0C 08 82 01 11 88 13 00 00 00 00 00 00 1A 0C 08 BC 0A 11 01 00 00 00 00 00 00 00 1A 0B 08 74 11 64 00 00 00 00 00 00 00 1A 0C 08 89 08 11 51 46 00 00 00 00 00 00 1A 0C 08 D4 09 11 01 00 00 00 00 00 00 00 1A 0C 08 88 01 11 0B 00 00 00 00 00 00 00 1A 0C 08 A7 02 11 0C 00 00 00 00 00 00 00 1A 0C 08 EE 07 11 F6 40 00 00 00 00 00 00 1A 0C 08 EB 09 11 11 06 00 00 00 00 00 00 1A 0D 08 03 1A 09 E5 92 B8 E4 BB A5 E5 8D 97 1A 0C 08 85 01 11 0B 00 00 00 00 00 00 00 1A 0C 08 B9 08 11 48 EE 00 00 00 00 00 00 1A 0B 08 39 11 9E 3A 00 00 00 00 00 00 1A 0B 08 79 11 26 00 00 00 00 00 00 00 1A 0C 08 E9 07 11 96 A5 00 00 00 00 00 00 1A 0C 08 9F 09 11 01 00 00 00 00 00 00 00 1A 0C 08 86 01 11 0B 00 00 00 00 00 00 00 1A 0B 08 75 11 01 00 00 00 00 00 00 00 1A 0C 08 89 01 11 0B 00 00 00 00 00 00 00 1A 0C 08 84 08 11 CB 32 00 00 00 00 00 00 1A 0C 08 CB 01 11 58 02 00 00 00 00 00 00 1A 0C 08 BA 08 11 05 00 00 00 00 00 00 00 1A 0B 08 34 11 02 00 00 00 00 00 00 00 1A 0C 08 AD 0A 11 BD 20 06 68 00 00 00 00 1A 0C 08 98 02 11 0C 00 00 00 00 00 00 00 1A 0C 08 DC 09 11 01 00 00 00 00 00 00 00 1A 0B 08 6F 11 B2 01 00 00 00 00 00 00 1A 0C 08 B1 02 11 0C 00 00 00 00 00 00 00 1A 08 08 9F 08 1A 03 35 2C 36 1A 0C 08 F3 08 11 A4 B1 01 00 00 00 00 00 1A 0B 08 76 11 2A 00 00 00 00 00 00 00 1A 0C 08 87 01 11 0B 00 00 00 00 00 00 00 1A 0C 08 85 08 11 C5 36 00 00 00 00 00 00 1A 0B 08 77 11 1A 00 00 00 00 00 00 00 1A 0C 08 B1 08 11 49 00 00 00 00 00 00 00 1A 0C 08 F2 07 11 E8 7B CF B3 79 2D 00 00 1A 0C 08 8D 08 11 B4 AF 01 00 00 00 00 00 1A 75 08 E2 08 1A 70 7B 22 70 72 6F 74 65 63 74 22 3A 5B 7B 22 69 64 22 3A 31 2C 22 73 74 61 74 65 22 3A 35 30 30 30 2C 22 74 6F 67 67 6C 65 22 3A 31 7D 2C 7B 22 69 64 22 3A 32 2C 22 73 74 61 74 65 22 3A 35 30 30 30 2C 22 74 6F 67 67 6C 65 22 3A 30 7D 2C 7B 22 69 64 22 3A 33 2C 22 73 74 61 74 65 22 3A 35 30 30 30 2C 22 74 6F 67 67 6C 65 22 3A 31 7D 5D 7D 1A 0C 08 88 08 11 77 42 00 00 00 00 00 00 1A 0C 08 9D 02 11 0C 00 00 00 00 00 00 00 1A 0C 08 82 08 11 78 00 00 00 00 00 00 00 1A 0B 08 37 11 1A 27 00 00 00 00 00 00 1A 0B 08 6E 11 B2 01 00 00 00 00 00 00 1A 0C 08 B2 08 11 32 00 00 00 00 00 00 00 1A 0C 08 F3 0A 11 2A 09 00 00 00 00 00 00 1A 0B 08 F5 07 1A 06 31 30 33 3A 31 2C 1A 0C 08 D7 09 11 2C 01 00 00 00 00 00 00 1A 0C 08 89 0A 11 05 00 00 00 00 00 00 00 1A 0B 08 73 11 64 00 00 00 00 00 00 00 1A 0C 08 BC 08 11 01 00 00 00 00 00 00 00 1A 07 08 86 09 1A 02 5B 5D 1A 0C 08 8A 08 11 3E FD 04 68 00 00 00 00 1A 0C 08 D6 09 11 2C 01 00 00 00 00 00 00 1A 0C 08 85 0A 11 14 00 00 00 00 00 00 00 1A 0C 08 AC 02 11 0C 00 00 00 00 00 00 00 1A 0B 08 38 11 F1 2E 00 00 00 00 00 00 1A 0C 08 EE 09 11 01 00 00 00 00 00 00 00";
//        byte[] bytes = HexUtil.decodeHex(hex.replace(" ", ""));
//        var property = DataCodecKit.decode(bytes, PbObjProperty.class);
//        property.objId = player.getObjId();

//        for (PbPerProperty prop : proto.objProps) {
//            property.addProperty(prop);
//        }

    @Test
    public void test() {
//        String hex = "0A 04 31 30 30 30 12 09 E6 B8 85 E9 A3 8E E5 B1 B1";
//        byte[] bytes = HexUtil.decodeHex(hex.replace(" ", ""));
//
//        PbAppearMapPropertyNtf property = DataCodecKit.decode(bytes, PbAppearMapPropertyNtf.class);
//        log.info(property.toString());
//        CmdInfo info = CmdInfo.getCmdInfo(268501157);
//        log.info("info {}", info);

        ByteBuf buf = Unpooled.buffer();
        buf.writeIntLE(268632325);
        log.info(HexUtil.encodeHexStr(buf.array()));


    }

    @Test
    public void PbRoleLoginRespTest() {
        String hex = "10 05 1A 4E 09 8F 7B CF B3 79 2D 00 00 10 B4 DF 06 18 89 97 B1 02 22 09 E5 BD 92 E5 AE 89 E5 A5 88 28 02 32 1C 08 93 4E 10 9E 75 18 C8 65 20 CC 6D 28 F6 5D 30 97 7D 38 FA 84 01 40 D1 8C 01 58 02 38 01 49 F2 B4 04 68 00 00 00 00 62 04 31 30 30 30";
        byte[] bytes = HexUtil.decodeHex(hex.replace(" ", ""));

        PbRoleLoginResp property = DataCodecKit.decode(bytes, PbRoleLoginResp.class);
        log.info(property.toString());
    }


    @Test
    public void ItemTest() {
//        String hex = "08 01 12 94 01 08 C8 CE 92 91 01 1A 0C 08 F6 3E 11 03 00 00 00 00 00 00 00 1A 0C 08 F3 3E 11 01 00 00 00 00 00 00 00 1A 0D 08 03 1A 09 E7 8E 84 E9 87 91 E9 93 B2 1A 29 08 F5 3E 1A 24 63 38 33 32 62 34 61 37 2D 31 37 34 39 2D 34 61 61 34 2D 62 34 34 63 2D 61 35 39 35 30 39 66 65 62 64 33 65 1A 0C 08 F8 3E 11 01 00 00 00 00 00 00 00 1A 0C 08 F4 3E 11 C1 2B 00 00 00 00 00 00 1A 0C 08 80 3F 11 86 2E 0A 68 00 00 00 00 1A 0C 08 92 3F 11 05 00 00 00 00 00 00 00";
//        String hex = "08 01 12 85 01 08 98 CE 92 91 01 1A 0C 08 F3 3E 11 01 00 00 00 00 00 00 00 1A 0C 08 F4 3E 11 70 30 00 00 00 00 00 00 1A 29 08 F5 3E 1A 24 63 66 39 37 66 38 35 64 2D 62 33 63 33 2D 34 32 37 66 2D 39 32 61 62 2D 64 34 30 64 63 30 35 65 62 65 35 34 1A 0C 08 F6 3E 11 53 00 00 00 00 00 00 00 1A 0C 08 F8 3E 11 01 00 00 00 00 00 00 00 1A 0C 08 80 3F 11 BD 8D 00 68 00 00 00 00 1A 0C 08 92 3F 11 05 00 00 00 00 00 00 00";
        String hex = "08 01 12 C4 01 08 F6 98 9C 91 01 1A 0C 08 91 3F 11 01 00 00 00 00 00 00 00 1A 29 08 F5 3E 1A 24 66 39 34 31 36 63 34 61 2D 31 64 61 62 2D 34 63 65 66 2D 39 61 65 31 2D 63 32 64 62 31 30 32 63 31 34 35 63 1A 1D 08 94 3F 1A 18 31 31 32 3A 33 33 2C 31 31 38 3A 33 2C 31 31 39 3A 32 2C 31 32 31 3A 32 1A 0C 08 F6 3E 11 01 00 00 00 00 00 00 00 1A 0C 08 F8 3E 11 01 00 00 00 00 00 00 00 1A 10 08 03 1A 0C E7 8E 84 E9 93 81 E5 89 91 E6 B3 95 1A 0C 08 92 3F 11 02 00 00 00 00 00 00 00 1A 0C 08 80 3F 11 9A 43 0A 68 00 00 00 00 1A 0C 08 F3 3E 11 03 00 00 00 00 00 00 00 1A 0C 08 F4 3E 11 A4 B1 01 00 00 00 00 00";
        byte[] bytes = HexUtil.decodeHex(hex.replace(" ", ""));

        PbPackageItemNtf notify = DataCodecKit.decode(bytes, PbPackageItemNtf.class);
        log.info(new Gson().toJson(notify));
    }

    @Test
    public void RemovePackageItemNtfTest() {
        String hex = "08 BD 51 12 91 01 08 89 E0 8D 90 01 1A 0A 08 03 1A 06 E4 BF AE E4 B8 BA 1A 0C 08 F3 3E 11 01 00 00 00 00 00 00 00 1A 0C 08 F4 3E 11 7C C4 00 00 00 00 00 00 1A 29 08 F5 3E 1A 24 30 62 35 39 31 37 33 63 2D 63 36 62 33 2D 34 37 36 39 2D 62 31 39 66 2D 31 63 63 32 62 63 66 32 66 34 63 30 1A 0C 08 F6 3E 11 10 27 00 00 00 00 00 00 1A 0C 08 F8 3E 11 01 00 00 00 00 00 00 00 1A 0C 08 80 3F 11 6B 63 07 68 00 00 00 00 1A 0C 08 92 3F 11 05 00 00 00 00 00 00 00";
        byte[] bytes = HexUtil.decodeHex(hex.replace(" ", ""));

        PbItemChangeNtf notify = DataCodecKit.decode(bytes, PbItemChangeNtf.class);
        log.info(new Gson().toJson(notify));
    }

    @Test
    public void AssemblyListTest() {
        String hex = "0A 0C 08 01 10 01 1A 06 F1 9C 06 89 95 06 0A 27 08 01 10 02 1A 21 A1 8D 06 E2 8D 06 BB 95 06 BA 95 06 BF 95 06 BE 95 06 C0 95 06 E1 95 06 E2 95 06 E5 95 06 E6 95 06";
        byte[] bytes = HexUtil.decodeHex(hex.replace(" ", ""));
        PbAssemblyListNtf notify = DataCodecKit.decode(bytes, PbAssemblyListNtf.class);
        log.info(new Gson().toJson(notify));
    }


    //{"parcelId":1,"itemList":[{"objId":308311486,"objProps":[{"properCode":8064,"intValue":1745157438},{"properCode":8052,"intValue":2},{"properCode":8098,"intValue":1},{"properCode":8054,"intValue":1},{"properCode":8053,"strValue":"bc276af8-4138-45ae-a3fe-b3d560c96d4d"},{"properCode":8082,"intValue":4},{"properCode":8051,"intValue":10}]},{"objId":308311487,"objProps":[{"properCode":8064,"intValue":1745157438},{"properCode":8098,"intValue":1},{"properCode":8054,"intValue":1},{"properCode":8052,"intValue":1},{"properCode":8053,"strValue":"eedf7467-b5f1-40cf-b090-af3e8a254062"},{"properCode":8082,"intValue":4},{"properCode":8051,"intValue":10}]}]}

}
