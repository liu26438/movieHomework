package movieSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class receptionist {
    static ArrayList<number> re_nums=new ArrayList<>();
    static theater[] theaters=new theater[5];
    static {
        for (int i = 0; i < 5; i++) {
            theaters[i] = new theater();
        }
    }
    static ArrayList<ticket> tickets=new ArrayList<>();
    public void act_recep()
    {
        user us2=new user();
        loop3:while(true)
        {
            System.out.println("请选择要进行的操作：");
            System.out.println("1.列出影片与场次的信息");
            System.out.println("2.售票");
            System.out.println("3.退出登录");
            Scanner sc=new Scanner(System.in);
            int switch1=sc.nextInt();
            switch(switch1)
            {
                case 1:
                    manager ma1=new manager();
                    System.out.println("请选择要进行的操作：");
                    System.out.println("1.列出所有影片的信息");
                    System.out.println("2.列出所有场次的信息");
                    System.out.println("3.列出指定的电影和场次的信息");
                    int switch2=sc.nextInt();
                    switch(switch2)
                    {
                        case 1:
                            for (int i = 0; i < ma1.movies.size(); i++) {
                                ma1.movies.get(i).show_movie_infor();
                            }
                            break;
                        case 2:
                            for (int i = 0; i < ma1.sessions.size(); i++) {
                                ma1.sessions.get(i).show_session_infor();
                            }
                            break;
                        case 3:
                            System.out.println("请输入场次放映的电影名称：");
                            String movie_name=sc.next();
                            System.out.println("请输入场次所在的放映厅：");
                            int theater_NO=sc.nextInt();
                            System.out.println("请输入场次所在的时间段：");
                            String period=sc.next();
                            System.out.println("请输入场次的价格：");
                            int price=sc.nextInt();
                            for (int i = 0; i < ma1.sessions.size(); i++)
                            {
                                if(ma1.sessions.get(i).theater_NO==theater_NO&&ma1.sessions.get(i).period.equals(period)&&
                                    ma1.sessions.get(i).price==price&&ma1.sessions.get(i).movie_name.equals(movie_name))
                                {
                                    theaters[ma1.sessions.get(i).theater_NO].show_seat();
                                    System.out.println("剩余空位数为："+theaters[ma1.sessions.get(i).theater_NO].seat_number);
                                }
                                else break;
                            }
                            break;
                        default:break;
                    }
                    break;
                case 2:
                    System.out.println("请输入场次所在的放映厅：");
                    int theater_NO=sc.nextInt();
                    System.out.println("请输入场次所在的时间段：");
                    String period=sc.next();
                    System.out.println("请输入场次的价格：");
                    int price=sc.nextInt();
                    System.out.println("请输入场次放映的电影名称：");
                    String movie_name=sc.next();
                    System.out.println("请输入用户名：");
                    String user_name2=sc.next();
                    System.out.println("请输入支付金额：");
                    int payment=sc.nextInt();
                    for (int i = 0; i < us2.users.size(); i++)
                    {
                        if(us2.users.get(i).user_name==user_name2)
                        {
                            for (int j = 0; j < us2.users.get(i).us_ticket.size(); j++)
                            {
                                if(     us2.users.get(i).us_ticket.get(j).session1.theater_NO==theater_NO&&
                                        us2.users.get(i).us_ticket.get(j).session1.period.equals(period)&&
                                        us2.users.get(i).us_ticket.get(j).session1.price==price&&
                                        us2.users.get(i).us_ticket.get(j).session1.movie_name.equals(movie_name))
                                {
                                    System.out.println("售票成功");
                                    us2.users.get(i).us_ticket.get(j).show_ticket();
                                }

                            }
                        }
                    }
                    break;
                case 3:break loop3;
                default:break;
            }
        }
    }
}
