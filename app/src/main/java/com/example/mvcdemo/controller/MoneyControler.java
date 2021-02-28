package com.example.mvcdemo.controller;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvcdemo.MainActivity;
import com.example.mvcdemo.R;
import com.example.mvcdemo.modle.Moneymodel;

import java.security.PublicKey;
import java.util.Random;

public class MoneyControler {
    private Moneymodel moneymodel;

    private String tx="冲冲冲";
    private int id=R.drawable.fei;
    public MoneyControler() {
        moneymodel = new Moneymodel();

    }
    public void addNumber(addListener addListener) {
        moneymodel.addNumber();
        addListener.addOK(moneymodel.selectData());
    }

    public void reduceNumber(reduceListener reduceListener,int typ) {
        if(typ==1){
        moneymodel.reduceNumber(5);
        }else if(typ==2){
            moneymodel.reduceNumber(1);
        }else if(typ==3){
            moneymodel.reduceNumber(10);
        }


        switch (gogo(typ)){
            case -1:
                id=R.drawable.feiqiu;
                tx="没中，再来一次吧！";
                break;
            case 0:
                id=R.drawable.abeiduo;
                tx="风景不错，趁着休息，就把这一幕画下来吧。";
                break;
            case 1:
                id=R.drawable.diluke;
                tx="蒙德城的迪卢克，应约而来。闲聊恕不奉陪，如果你是想做一番大事，我倒有点兴致。";
                break;
             case 2:
                 id=R.drawable.gongzi;
                 tx="我是愚人众执行官第十一席，「公子」达达利亚。而你——也是能招致纷争之人，实在愉快。我们应该会很合得来吧？";
                 break;
             case 3:
                 id=R.drawable.keli;
                 tx="「城里放炮,禁闭室报道」、「炸弹伤人,琴找上门」、「放火烧山,可莉完蛋」";
                 break;
             case 4:
                 id=R.drawable.laopo;
                 tx="剑光如我,斩尽芜杂";
                 break;
            case 5:
                id=R.drawable.mona;
                tx="已经正午了，去吃点东西吧，嗯？我……我吃份沙拉就行了，呃……简朴的生活是……是占星术士修行的一环！";
                break;
            case 6:
                id=R.drawable.qin;
                tx="蒲公英骑士,琴,申请入队。从今往后,我的荣誉与忠诚将与你同在!";
                break;
            case 7:
                id=R.drawable.qiqi;
                tx="我是七七，是个僵尸…啊，还要说什么来着。";
                break;
            case 8:
                id=R.drawable.wendi;
                tx="哈~睡得好香呀...咦，你好呀，旅行者，我们又见面了。";
                break;
            case 9:
                id=R.drawable.xiao;
                tx="如遇失道旷野之难，路遭贼人之难，水火刀兵之难，鬼神药毒之难，恶兽毒虫之难，冤家恶人之难，便呼我名。三眼五显仙人，魈，听召，前来守护。";
                break;
            case 10:
                id=R.drawable.yeyang;
                tx="工作…工作还没有做完，真的可以提前休息吗?。";
                break;
            case 11:
                id=R.drawable.zhongli;
                tx="接下来想去哪里？如果想游历璃月名胜的话，我有一些不错的参考方案。";
                break;

        }
        reduceListener.reduceOK(moneymodel.selectData(),tx,id);

    }

    public int gogo(int n){
        Random r = new Random();
        int i=0,fg=0;
        for(;i<n;i++){
            int rd=r.nextInt(10);
            if(rd==1){
                fg=1;
                break;
            }
        }
        if(fg==1){
            int rd=r.nextInt(12);
            Log.d("rad",rd+"");
            return rd;
        }else {
            return -1;
        }
    }
    public int nowMoney(){
        return moneymodel.getMoney();
    }
    public interface addListener {
        void addOK(String str);
    }

    public interface reduceListener {
        void reduceOK(String str,String tx,int id);
    }
}
