package movieSystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class user_infor {
    public number user_num;
    public String user_name;
    public String level;
    public float discount;
    private String registime;
    private int money;
    private int times;
    private String phonenum;
    public String email;
    public ArrayList<ticket> us_ticket=new ArrayList<>();
    public user_infor(String user_name,String phonenum,
                          String email,String password)
    {
        Random random1 = new Random();
        int randomInt = random1.nextInt();
        String num = Integer.toString(Math.abs(randomInt));
        System.out.println("您的账号是："+num);
        this.user_num = new number();
        this.user_num.set_num_pass(num,password);
        this.user_name=user_name;
        this.phonenum=phonenum;
        this.email=email;
        Date date=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.registime= formatter.format(date);
        this.level="铜牌";
        this.discount=1;
        this.money=0;
        this.times=0;
    }
    public void show_user_infor()
    {
        System.out.println("用户ID:"+user_num.num);
        System.out.println("用户名:"+user_name);
        System.out.println("用户级别："+level);
        System.out.println("用户注册时间："+registime);
        System.out.println("用户累计消费金额"+money);
        System.out.println("用户累计消费次数"+times);
        System.out.println("用户手机号："+phonenum);
    }
    public void check1_user_infor(String num_or_username)
    {
        if(this.user_num.num.equals(num_or_username)||this.user_name.equals(num_or_username))
        {
            show_user_infor();
        }
    }
}
