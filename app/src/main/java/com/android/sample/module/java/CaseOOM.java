package com.android.sample.module.java;

/**
 * Created by hexiaolei on 2017/7/7.
 * Class Function:
 */

public class CaseOOM {

    static String data = "虎扑7月7日讯 步行者官方今天宣布他们已经送出保罗-乔治换到雷霆的维克托-奥拉迪波和多曼塔斯-萨博尼斯。另外保罗-乔治在雷霆将继续穿13号球衣。\n" +
            "“我们能强烈地感觉到奥拉迪波和萨博尼斯为我们球员带来的潜力，以及他们对球队未来的的意义。”步行者篮球运营总裁凯文-普理查德说，“他们俩都有非常高的竞争性，非常好的技术，两位都是赢家，这就是他们成为乐透秀的原因，这就是我们把他们交易来的原因。”\n" +
            "2016-17赛季常规赛，保罗-乔治为步行者出场75次，场均出战35.8分钟，能够贡献23.7分6.6篮板3.3助攻1.6抢断；季后赛他出场4次，场均出战43分钟，能够贡献28分8.8篮板7.2助攻1.75抢断。\n" +
            "乔治2013年夏天和步行者签订了一份5年9163万美元的合同，2019年夏天合同到期，2018-19赛季拥有球员选项。\n" +
            "奥拉迪波上赛季为雷霆出场67次，场均上场33.2分钟得到15.9分4.3篮板2.6助攻；季后赛他出场5次，场均出战36.2分钟，能够贡献10.8分5.8篮板2助攻1.4抢断。\n" +
            "萨博尼斯上赛季为雷霆出场81次，场均上场20.1分钟得到5.9分3.6篮板1.0助攻；季后赛他出场2次，场均出战3分钟，能够贡献2分1篮板。";

    public static void trigerOOM() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (true) {
            System.out.println("count:" + count);
            sb.append(data);
            count++;
        }
    }

}