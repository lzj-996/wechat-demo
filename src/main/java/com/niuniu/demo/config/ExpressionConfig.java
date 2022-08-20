package com.niuniu.demo.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzj
 * @date 2022/8/17 23:17
 * @description:
 */
public class ExpressionConfig {
    public static final List<String> EXPRESSION_LIST = new ArrayList<>();

    /**
     * 把太大的颜文字拆分多个发送
     * @param str
     * @return
     */
    public static List<String> splitExpression(String str) {
        int max = 200;
        String[] split = str.split("\\\n");
        List<String> list = new ArrayList<>();
        StringBuilder first = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (first.length() + s.length() > max) {
                list.add(first + "\n");
                first = new StringBuilder(s).append("\n");
            } else {
                first.append(s).append("\n");
                if (i== split.length-1){
                    list.add(first.toString());
                }
            }
        }
        return list;
    }

    public static final String s1=
            "く__,.ヘヽ.　　　　/　,ー､ 〉\n" +
            "　　　＼ , !-─‐-i　/　/´\n" +
            "　　　 　 ／｀ｰ　　　 L/／｀ヽ､\n" +
            "　　 　 /　 ／,　 /|　 ,　 ,　　    ,\n" +
            "　　　ｲ 　/ /-‐/　ｉ　L_ ﾊ ヽ!　 i\n" +
            "　　　 ﾚ ﾍ 7ｲ｀ﾄ　 ﾚ-ﾄ､!ハ|　 |\n" +
            "　　　　 !,/7 ✪　　 ´i✪ﾊiソ| 　 |　　　\n" +
            "　　　　 |.从　　_　　 ,,,, / |./ 　 |\n" +
            "　　　　 ﾚ| i＞.､,,__　_,.イ / 　.i 　|\n" +
            "　　　 ﾚ| | / k_７_/ﾚヽ,　ﾊ.　|\n" +
            "　　　 | |/i 〈|/　 i　,.ﾍ |　i　|\n" +
            "　　　.|/ /　ｉ： 　 ﾍ!　　＼　|\n" +
            "　　　 　 　 kヽ､ﾊ 　 _,.ﾍ､ 　 /､!\n" +
            "　　　 !〈//｀Ｔ´, ＼ ｀7ｰr\n" +
            "　　　 ﾚヽL__|___i,___,ンﾚ|ノ\n" +
            "　　　 　　　ﾄ-,/　|___./\n" +
            "　　　 　　　ｰ　　!_,.:";

    public final static String s2=
            "/ ￣￣￣＼　 \n" +
            "|　ー　ー \\　 \n" +
            "|　 ◉　◉ |   / ￣￣￣￣￣￣＼\n" +
            "\\ 　 ▱　 / ∠ 今天早上，        \\ \n" +
            "  ＼       イ   \\   好好好呀      /\n" +
            " ／　   　＼    \\______________/\n" +
            "/　|　　  \\ \\　 \n" +
            "|　|　　　 | |";

    public final static String s3=
            "好看的人已经醒来~~~ \n" +
            "　　　∩∩\n" +
            "　　（´･ω･）\n" +
            "　  ＿|　⊃／(＿＿_\n" +
            "　／ └-(＿＿＿_／\n" +
            "　￣￣￣￣￣￣￣";

    public final static String s_weather=
            "┌─────────────────┐\n" +
            "　│通知：　       │\n" +
            "　│今天天气不好    |\n" +
            "　│记得带伞。      │\n" +
            "　  (ﾖ─-∧＿∧─-E)\n" +
            "　  ＼（* ´∀｀）／\n" +
            "　 　 Y 　　　 Y";

    public final static String s5=
            "你是最胖的！！！！！！\n" +
            "　☆  *　.  　☆\n" +
            "　　. ∧＿∧　∩　* ☆\n" +
            "*  ☆ ( ・∀・)/ .\n" +
            "　.  ⊂　　 ノ* ☆\n" +
            "☆ * (つ ノ  .☆\n" +
            "　　 (ノ";

    public final static String s6=
            "　 睡醒了吗！　   |\n" +
            "＼/\n" +
            "　￣￣￣￣∨￣￣\n" +
            "  。\n" +
            "　　　∧ ∧　.・　\n" +
            "|￣￣( ´Д｀)￣|\n" +
            "|＼⌒⌒⌒⌒⌒⌒＼\n" +
            "|　 ＼⌒⌒⌒⌒⌒⌒＼\n" +
            "＼　｜⌒⌒⌒⌒⌒⌒⌒|\n" +
            "　 ＼|＿＿＿＿＿＿＿_|";

    public final static String s7=
            "＿＿＿＿＿\n" +
            "　　 ｜早上好  ｜\n" +
            "　　　￣￣∨￣￣\n" +
            "　　　　∧＿∧　\n" +
            "　　　 (´・ω⊂ヽ゛\n" +
            "　　　 /　　 _ノ⌒⌒ヽ\n" +
            "、(￣⊂人　 ノシ⌒　　ノ\n" +
            "⊂ニニニニニニニニニニニ⊃";

    public final static String s4=
            "   ＼　　／ \n" +
            "┏━━━━＼／━━━━━┓\n" +
            "┃┏━━━━━━━━━━┓ ┃\n" +
            "┃┃今天可以睡迟┃ ┃\n" +
            "┃┃一会会~~~~┃ ┃\n" +
            "┃┗━━━━━━━━━━┛ ┃\n" +
            "┗━━∪━━━━∪━━━";

    public final static String s9=
            "呼呼呼呼呼\n" +
            "好困啊...\n" +
            "　　　∧_∧__\n" +
            "　 ／(*´o｀)／＼\n" +
            "／|￣∪∪￣|＼／\n" +
            "　|＿＿ ＿|／";

    public final static String s_birthday=
            "｡o◇☆οo｡\n" +
            "　　　 ｡◎∧_∧☆∂o\n" +
            "　　　｡○(*ﾟーﾟ)◇☆\n" +
            "　　　◎|￣∪∪￣￣|\n" +
            "　　／☆|生日快乐！|\n" +
            "　▼　 ﾟoο◇☆＿＿|\n" +
            "∠▲――-☆∂o◎∂ﾟ";

    public final static String s8=
            "   ∧_∧　啪啪啪啪~起床起床\n" +
            "（ ・ω・)=つ≡つ\n" +
            "（っ ≡つ=つ\n" +
            "`/　　)\n" +
            "(ノΠＵ";

    public final static String s_rest=
            "休息一下~休息一下~\n" +
            "￣￣￣￣￣＼／￣￣￣￣ \n" +
            "　　　　∧＿∧　　　　 \n" +
            "　　;;（´・ω・） 　 \n" +
            "　＿旦_(っ(,,■)＿＿  \n" +
            "　|l￣l||￣しﾞしﾞ￣|i";

    public final static String s10=
            "✨  ︵ \n" +
            "(\"\\(●-●)\n" +
            " \\ /     0\\ \\\n" +
            "  (          )\"\n" +
            "  \\__T__/";

    public final static String s11=
            "。　Ｏ　　　ｏ\n" +
            "　 ｏ　　　。\n" +
            "○。\n" +
            "　　　早上好呀呀　 Ｏ\n" +
            "。　 　 ＿\n" +
            "　　 ,.'´　　｀゛、　ｏ\n" +
            "  　（ ＿´ ∀ ｀ _  ）";

    public final static String s12=
            "        ＿＿＿＿\n" +
            "　　 　 ‖　　　　|\n" +
            "　　 　 ‖起床起床|\n" +
            "　　 　 ‖　　　　|\n" +
            "　　 　 ‖￣￣￣￣\n" +
            "　 ∧＿∧\n" +
            "　(`･ω･‖\n" +
            "　丶　つ０\n" +
            "　 しーＪ";

    public final static String s13=
            "巴拉巴拉巴拉，把你变成猪！\n" +
            "　 ∧＿∧\n" +
            " （｡･ω･｡)つ━☆・*。\n" +
            "  ⊂　　 ノ 　　　・゜+.\n" +
            "　しーＪ　　　°。+ *´¨)\n" +
            "　　　       　　.· ´¸.·*´¨) ¸.·*¨)\n" +
            "     　(¸.·´ (¸.·’*";

    public final static String s14=
            "　 ﾍ^ヽ､　 /⌒､　　_,_\n" +
            "　 |　　￣7　 (⌒r⌒7/\n" +
            "　 レ　　　＼_/￣＼_｣\n" +
            "＿/　　　　　　　　 {\n" +
            "_ﾌ　●　　　　　　　ゝ\n" +
            "_人　　　ο　　●　 ナ\n" +
            "　 `ト､＿　　　　　メ\n" +
            "　　　 /　 ￣ ーィﾞ\n" +
            "　　 〈ﾟ･｡｡｡･ﾟ 　丶";

    public final static String s15=
            "　　　 ＿＿＿\n" +
            "　　 ／　　　▲\n" +
            "／￣　 ヽ　■■\n" +
            "●　　　　　■■\n" +
            "ヽ＿＿＿　　■■\n" +
            "　　　　）＝｜\n" +
            "　　　／　｜｜\n" +
            "　∩∩＿＿とﾉ\n" +
            "　しし———┘\n";

    public final static String s21=
            "起来摸鱼~起来摸鱼了~\n" +
            "￣￣￣￣￣＼／￣￣￣￣\n" +
            "　　　 　∧＿∧　　　　\n" +
            "　　;;（´・ω・） 　\n" +
            "　＿旦_(っ(,,■)＿＿\n" +
            "　|l￣l||￣しﾞしﾞ￣|i";
    public final static String s16=
            "::|＿_\n" +
            "::|　 ＼\n" +
            "::| 、＿ ＼\n" +
            "::|　(●) ＼\n" +
            "::|人_)⌒:: ｜\n" +
            "::|⌒´　 ／\n" +
            "(⌒ー―′ )\n" +
            "::| (起来了吗？)";
    public final static String s17=
            "\n" +
            "┳┻|\n" +
            "┻┳|\n" +
            "┳┻|__∧\n" +
            "┻┳|･ω･) ~起来了吗\n" +
            "┳┻|⊂ﾉ\n" +
            "┻┳|Ｊ";
    public final static String s_newyear=
            "　　　　｜\n" +
            "　　／￣￣￣＼\n" +
            "　／　　∧　　＼\n" +
            "│　 ／ 川＼　 │\n" +
            "　＼／┏┻┓ ＼／\n" +
            "。゛＃┃新┃゛。\n" +
            "゛，。┃年┃＃。゛\n" +
            "。゜＃┃快┃゛。゛\n" +
            "，＊。┃乐┃゜。＃\n" +
            "＃゜。┃！┃゜＊。\n" +
            "　　　┃☆┃\n" +
            "　　　┗┯┛\n" +
            "　∩∩　│\n" +
            "(*´∀`)│\n" +
            "　/　⊃";
    public final static String s18=
            "~~~~起床发呆中~~~~\n"+
            "╭﹌☆﹌﹌﹌☆﹌╮　\n" +
            "∣　　　　　　　∣\n" +
            "∣　●　　　●  ∣　\n" +
            "∣　　　▽　　　∣\n" +
            "╰————--—╯　\n" +
            "　∣　﹏　﹏　∣　　\n" +
            "　╰∪———∪╯";
    public final static String s19=
            "~~~~起床发呆中~~~~\n"+
            "◥◤~~~~◥◤　　\n" +
            "┃　　　　┃\n" +
            "≡━ ﹏ ━≡　　\n" +
            "┗━━┳∞┳━━┛\n" +
            "　┏┫　┣┓";

    public final static String s20=
            "{\\__/}\n" +
            "( • - •)\n" +
            "/つ\uD83D\uDDA4早上好";

    static {
        EXPRESSION_LIST.add(s1);
        EXPRESSION_LIST.add(s2);
        EXPRESSION_LIST.add(s3);
        EXPRESSION_LIST.add(s4);
        EXPRESSION_LIST.add(s5);
        EXPRESSION_LIST.add(s6);
        EXPRESSION_LIST.add(s7);
        EXPRESSION_LIST.add(s8);
        EXPRESSION_LIST.add(s9);
        EXPRESSION_LIST.add(s10);
        EXPRESSION_LIST.add(s11);
        EXPRESSION_LIST.add(s12);
        EXPRESSION_LIST.add(s13);
        EXPRESSION_LIST.add(s14);
        EXPRESSION_LIST.add(s15);
        EXPRESSION_LIST.add(s16);
        EXPRESSION_LIST.add(s17);
        EXPRESSION_LIST.add(s18);
        EXPRESSION_LIST.add(s19);
        EXPRESSION_LIST.add(s20);
        EXPRESSION_LIST.add(s21);
    }
}
