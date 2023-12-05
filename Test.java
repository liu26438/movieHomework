package movieSystem;

import java.util.ArrayList;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Loop:while(true) {
            System.out.println("请选择身份或退出系统:");
            System.out.println("1.管理员");
            System.out.println("2.经理");
            System.out.println("3.前台");
            System.out.println("4.用户");
            System.out.println("5.退出系统");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            administrator ad = new administrator();
            number ad_num11=new number();
            ad_num11.set_num_pass("admin","ynuinfo#777");
            ad.ad_nums.add(ad_num11);
            manager ma = new manager();
            receptionist re = new receptionist();
            user us = new user();
            switch (choice) {
                case 1:
                    System.out.println("请输入账号和密码：");
                    String num = sc.next();
                    String pass = sc.next();
                    for (int i = 0; i < ad.ad_nums.size(); i++)
                    {
                        if (ad.ad_nums.get(i).match(num, pass))
                        {
                            System.out.println("登录成功");
                            ad.act_admin();
                            break;
                        }
                        else System.out.println("登录失败");
                    }
                    break;
                case 2:
                    ma.act_mana();
                    break;
                case 3:
                    re.act_recep();
                    break;
                case 4:
                    System.out.println("是否需要进行注册？1.是2.否");
                    int if_register = sc.nextInt();
                    if (if_register == 1) {
                        us.register();
                    }
                    for1:for (int i = 0; i < 5; i++)
                    {
                        System.out.println("请输入账号和密码：");
                        String num1 = sc.next();
                        String pass1 = sc.next();
                        for (int j = 0; j < us.users.size(); j++) {
                            if (us.users.get(j).user_num.match(num1, pass1)) {
                                System.out.println("登录成功");
                                us.act_user(us.users.get(j));break for1;
                            } else System.out.println("登录失败");
                        }
                    }
                    break;
                case 5:
                    break Loop;
                default:
                    break;
            }
        }
    }
}
