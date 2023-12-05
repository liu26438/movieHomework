package movieSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class number {
    public String num;
    public String pass;
    public void set_num_pass(String num,String pass)
    {
        this.num=num;
        this.pass=pass;
    }
    public boolean match(String num,String pass)
    {
        boolean bo=false;
        if(this.num.equals(num)||this.pass.equals(pass)) {bo=true;}
        return bo;
    }
    public void change_pass(String num,String pass)
    {
        if(this.num.equals(num)) this.pass=pass;
    }
    public void reset_pass(String user_name,String email)
    {

        System.out.println("请登录邮箱查看随机生成的密码。");
    }
}
