package movieSystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class user {
    static ArrayList<user_infor> users=new ArrayList<>();
    public void register()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String user_name=sc.next();
        System.out.println("请输入电话号码：");
        String phonenum=sc.next();
        System.out.println("请输入邮箱：");
        String email=sc.next();
        System.out.println("请输入密码：");
        String password=sc.next();
        user_infor user1=new user_infor(user_name,phonenum,email,password);
        users.add(user1);
    }

    public void act_user(user_infor user11)
    {
        loop4:while(true)
        {
            System.out.println("请选择要进行的操作：");
            System.out.println("1.密码管理");
            System.out.println("2.购票");
            System.out.println("3.退出登录");
            Scanner sc=new Scanner(System.in);
            int switch1=sc.nextInt();
            switch(switch1)
            {
                case 1:
                    System.out.println("请选择要进行的操作：");
                    System.out.println("1.修改密码");
                    System.out.println("2.重置密码");
                    int switch2=sc.nextInt();
                    switch(switch2)
                    {
                        case 1:
                            System.out.println("请输入账号和旧的密码：");
                            String change_num=sc.next();
                            String change_pass=sc.next();
                            for (int i = 0; i < users.size(); i++)
                            {
                                if(users.get(i).user_num.num.equals(change_num)&&users.get(i).user_num.pass.equals(change_pass))
                                {
                                    System.out.println("请输入新的密码：");
                                    String new_pass=sc.next();
                                    users.get(i).user_num.change_pass(change_num,new_pass);
                                    System.out.println("修改成功！");
                                }
                            }
                            break;
                        case 2:
                            System.out.println("请输入用户名和邮箱：");
                            String user_name=sc.next();
                            String email=sc.next();
                            for (int i = 0; i < users.size(); i++)
                            {
                                if(users.get(i).user_name.equals(user_name)&&users.get(i).email.equals(email))
                                {
                                    Random random1=new Random();
                                    String new_pass= Integer.toString(random1.nextInt());
                                    users.get(i).user_num.pass=new_pass;
                                    System.out.println("请登录到邮箱查看密码");
                                }
                            }
                            break;
                        default:break;
                    }
                    break;
                case 2:
                    manager ma2=new manager();
                    receptionist re2=new receptionist();
                    System.out.println("请选择要进行的操作：");
                    System.out.println("1.查看所有电影放映信息");
                    System.out.println("2.查看指定电影放映信息");
                    System.out.println("3.购票");
                    System.out.println("4.取票");
                    System.out.println("5.查看购票历史");
                    int switch3=sc.nextInt();
                    sw1:switch (switch3)
                    {
                        case 1:
                            for (int i = 0; i < ma2.movies.size(); i++) {
                                ma2.movies.get(i).show_movie_infor();
                            }
                            break;
                        case 2:
                            System.out.println("请输入要查询的影片的名称：");
                            String movie_name3=sc.next();
                            for (int i = 0; i < ma2.movies.size(); i++) {
                                if(ma2.movies.get(i).movie_name.equals(movie_name3))
                                {
                                    ma2.movies.get(i).show_movie_infor();
                                }
                            }
                            break;
                        case 3:
                            System.out.println("请输入场次所在的放映厅：");
                            int theater_NO=sc.nextInt();
                            System.out.println("请输入场次所在的时间段：");
                            String period=sc.next();
                            System.out.println("请输入场次的价格：");
                            int price=sc.nextInt();
                            System.out.println("请输入场次放映的电影名称：");
                            String movie_name=sc.next();
                            for (int i = 0; i < ma2.sessions.size(); i++) {
                                if(ma2.sessions.get(i).theater_NO==theater_NO&&ma2.sessions.get(i).period.equals(period)&&
                                       ma2.sessions.get(i).price==price&&ma2.sessions.get(i).movie_name.equals(movie_name))
                                {
                                    re2.theaters[theater_NO].show_seat();
                                    System.out.println("请输入要选择座位的行和列：");
                                    int row=sc.nextInt();
                                    int column=sc.nextInt();
                                    re2.theaters[theater_NO].choose_seat(row,column);
                                    System.out.println("您应支付的金额为："+user11.discount*ma2.sessions.get(i).price);
                                    System.out.println("请输入6位支付密码：");
                                    int password=sc.nextInt();
                                    System.out.println("支付成功");
                                    Random random2=new Random();
                                    int new_ticket_ID=random2.nextInt();
                                    ticket new_ticket=new ticket(new_ticket_ID,ma2.sessions.get(i),row,column);
                                    user11.us_ticket.add(new_ticket);
                                    re2.tickets.add(new_ticket);
                                    System.out.println("购票成功！");
                                    System.out.println("票的ID是："+new_ticket_ID);
                                    break sw1;
                                }
                            }
                            System.out.println("找不到对应的场次");
                            break;
                        case 4:
                            System.out.println("请输入要取的票的ID：");
                            int take_ticket_ID=sc.nextInt();
                            for (int i = 0; i < re2.tickets.size(); i++)
                            {
                                if(take_ticket_ID==re2.tickets.get(i).ID)
                                {
                                    if (re2.tickets.get(i).take_ticket)
                                    {
                                        System.out.println("票已被取走，不能重复取票。");
                                        break;
                                    }
                                    else
                                    {
                                        re2.tickets.get(i).take_ticket = true;
                                        System.out.println("取票成功。");
                                    }
                                }
                            }
                            break;
                        case 5:
                            for (int i = 0; i < user11.us_ticket.size(); i++)
                            {
                                user11.us_ticket.get(i).show_ticket();
                            }
                            break;
                        default:break;
                    }
                    break;
                case 3:break loop4;
                default:break;
            }
        }
    }
}
