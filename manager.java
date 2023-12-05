package movieSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class manager {
    static ArrayList<number> ma_nums=new ArrayList<>();
    static ArrayList<movie_infor> movies=new ArrayList<>();
    static ArrayList<session_infor> sessions=new ArrayList<>();
    public void act_mana()
    {
        loop2:while(true)
        {
            System.out.println("请选择要进行的操作：");
            System.out.println("1.影片管理");
            System.out.println("2.排片管理");
            System.out.println("3.退出登录");
            Scanner sc=new Scanner(System.in);
            int switch1=sc.nextInt();
            switch(switch1)
            {
                case 1:
                    System.out.println("请选择要进行的操作：");
                    System.out.println("1.列出所有正在上映影片的信息");
                    System.out.println("2.添加影片的信息");
                    System.out.println("3.修改电影的信息");
                    System.out.println("4.删除影片的信息");
                    System.out.println("5.查询影片的信息");
                    int switch2=sc.nextInt();
                    switch(switch2)
                    {
                        case 1:
                            for (int i = 0; i < movies.size(); i++) {
                                movies.get(i).show_movie_infor();
                            }
                            break;
                        case 2:
                            movie_infor new_movie=new movie_infor();
                            System.out.println("请输入影片的名称：");
                            String movie_name=sc.next();
                            System.out.println("请输入影片的导演：");
                            String director_name=sc.next();
                            System.out.println("请输入影片的主演：");
                            String performer_name=sc.next();
                            System.out.println("请输入影片的剧情简介：");
                            String introduction=sc.next();
                            System.out.println("请输入影片的时长：");
                            String duration=sc.next();
                            new_movie.add_modify(movie_name,director_name, performer_name,introduction,duration);
                            movies.add(new_movie);break;
                        case 3:
                            System.out.println("请输入要修改的影片的名称：");
                            String movie_name1=sc.next();
                            for (int i = 0; i < movies.size(); i++)
                            {
                                if(movies.get(i).movie_name.equals(movie_name1))
                                {
                                    System.out.println("请输入影片的名称：");
                                    String movie_name11=sc.next();
                                    System.out.println("请输入影片的导演：");
                                    String director_name11=sc.next();
                                    System.out.println("请输入影片的主演：");
                                    String performer_name11=sc.next();
                                    System.out.println("请输入影片的剧情简介：");
                                    String introduction11=sc.next();
                                    System.out.println("请输入影片的时长：");
                                    String duration11=sc.next();
                                    movies.get(i).add_modify(movie_name11,director_name11, performer_name11,introduction11,duration11);
                                    break;
                                }
                            }
                            break;
                        case 4:
                            System.out.println("请输入要删除的影片的名称：");
                            String movie_name2=sc.next();
                            System.out.println("删除后无法恢复，请确认是否继续删除操作：1.确定2.取消");
                            int confirm=sc.nextInt();
                            if(confirm==2) break;
                            else if(confirm==1) {
                                for (int i = 0; i < movies.size(); i++) {
                                    if (movies.get(i).movie_name == movie_name2)
                                    {
                                        movies.remove(i);
                                        System.out.println("删除成功！");
                                    }
                                    break;
                                }
                            }
                            break;
                        case 5:
                            System.out.println("请输入要查询的影片的名称：");
                            String movie_name3=sc.next();
                            for (int i = 0; i < movies.size(); i++) {
                                if(movies.get(i).movie_name.equals(movie_name3))
                                {
                                    movies.get(i).show_movie_infor();
                                }
                            }
                            break;
                        default:break;
                    }
                    break;
                case 2:
                    System.out.println("请选择要进行的操作：");
                    System.out.println("1.增加场次");
                    System.out.println("2.修改场次");
                    System.out.println("3.删除场次");
                    System.out.println("4.列出所有场次信息");
                    int switch3=sc.nextInt();
                    switch(switch3)
                    {
                        case 1:
                            System.out.println("请输入场次所在的放映厅：");
                            int theater_NO=sc.nextInt();
                            System.out.println("请输入场次所在的时间段：");
                            String period=sc.next();
                            System.out.println("请输入场次的价格：");
                            int price=sc.nextInt();
                            System.out.println("请输入场次放映的电影名称：");
                            String movie_name=sc.next();
                            session_infor new_session=new session_infor(theater_NO,period,price,movie_name);
                            sessions.add(new_session);
                            break;
                        case 2:
                            System.out.println("请输入要修改的场次放映的新电影：");
                            String new_movie2=sc.next();
                            System.out.println("请输入要修改的场次所在的放映厅：");
                            int theater_NO3=sc.nextInt();
                            System.out.println("请输入要修改的场次所在的时间段：");
                            String period3=sc.next();
                            System.out.println("请输入要修改的场次的价格：");
                            int price3=sc.nextInt();
                            System.out.println("请输入要修改的场次原先放映的电影名称：");
                            String movie_name3=sc.next();
                            for (int i = 0; i < sessions.size(); i++) {
                                if(sessions.get(i).theater_NO==theater_NO3&&sessions.get(i).period==period3&&
                                        sessions.get(i).price==price3&&sessions.get(i).movie_name.equals(movie_name3))
                                {
                                    sessions.get(i).motify_session(new_movie2);
                                    System.out.println("修改成功！");
                                }
                            }
                            break;
                        case 3:
                            System.out.println("请输入要删除的场次所在的放映厅：");
                            int theater_NO2=sc.nextInt();
                            System.out.println("请输入要删除的场次所在的时间段：");
                            String period2=sc.next();
                            System.out.println("请输入要删除的场次的价格：");
                            int price2=sc.nextInt();
                            System.out.println("请输入要删除的场次原先放映的电影名称：");
                            String movie_name2=sc.next();
                            for (int i = 0; i < sessions.size(); i++) {
                                if(sessions.get(i).theater_NO==theater_NO2&&sessions.get(i).period==period2&&
                                        sessions.get(i).price==price2&&sessions.get(i).movie_name.equals(movie_name2))
                                {
                                    sessions.remove(i);
                                    System.out.println("删除成功！");
                                }
                            }
                            break;
                        case 4:
                            for (int i = 0; i < sessions.size(); i++) {
                                sessions.get(i).show_session_infor();
                            }
                            break;
                        default:break;
                    }
                    break;
                case 3:break loop2;
                default:break;
            }
        }
    }
}
