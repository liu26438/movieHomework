package movieSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class administrator {
    static ArrayList<number> ad_nums=new ArrayList<>();
    public administrator()
    {

    }
    public void act_admin()
    {
        user us1=new user();
        number nu1=new number();
        loop1:while(true)
        {
            System.out.println("请选择要进行的操作：");
            System.out.println("1.密码管理");
            System.out.println("2.用户管理");
            System.out.println("3.退出登录");
            Scanner sc=new Scanner(System.in);
            int switch1=sc.nextInt();
            sw2:switch(switch1)
            {
                case 1:
                    System.out.println("请选择要进行的操作：");
                    System.out.println("1.修改自身密码");
                    System.out.println("2.重置用户密码");
                    int switch2 = sc.nextInt();
                    if (switch2 == 1) {
                        System.out.println("请输入账号和旧的密码：");
                        String change_num = sc.next();
                        String change_pass = sc.next();
                        for (int i = 0; i < ad_nums.size(); i++) {
                            if (ad_nums.get(i).num.equals(change_num) && ad_nums.get(i).pass.equals(change_pass)) {
                                System.out.println("请输入新的密码：");
                                String new_pass = sc.next();
                                ad_nums.get(i).change_pass(change_num, new_pass);
                                System.out.println("修改成功");
                                break sw2;
                            }
                        }
                        System.out.println("账号或密码有误");break;
                    } else if (switch2 == 2) {
                        System.out.println("请输入要重置密码的用户的用户名：");
                        String user_name4 = sc.next();
                        for (int i = 0; i < us1.users.size(); i++) {
                            if (us1.users.get(i).user_name.equals(user_name4))
                                nu1.reset_pass(user_name4, us1.users.get(i).email);
                            System.out.println("重置成功");break sw2;
                        }
                        System.out.println("用户名不存在");
                        break;
                    } else break;
                case 2:
                    System.out.println("请选择要进行的操作：");
                    System.out.println("1.列出所有用户信息");
                    System.out.println("2.删除用户信息");
                    System.out.println("3.查询用户信息");
                    int switch3 = sc.nextInt();
                    switch (switch3) {
                        case 1:
                            for (int i = 0; i < us1.users.size(); i++) {
                                us1.users.get(i).show_user_infor();
                            }
                        break;
                        case 2:
                            System.out.println("请确认是否继续删除操作？1.确定2.否定");
                            int switch4 = sc.nextInt();
                            if (switch4 == 2) break;
                            else if (switch4 == 1) {
                                System.out.println("请输入要删除的用户的用户名：");
                                String delete_user = sc.next();
                                for (int i = 0; i < us1.users.size(); i++) {
                                    if (delete_user.equals(us1.users.get(i).user_name)) {
                                        us1.users.remove(i);
                                        System.out.println("删除成功");
                                        break;
                                    }
                                }
                            }
                            break;
                        case 3:
                            System.out.println("请输入要查询的用户的ID或者用户名：");
                            String check_user = sc.next();
                            for (int i = 0; i < us1.users.size(); i++) {
                                if (check_user.equals(us1.users.get(i).user_name) || check_user.equals(us1.users.get(i).user_num.num)) {
                                    us1.users.get(i).show_user_infor();
                                    break sw2;
                                }
                            }
                            System.out.println("用户不存在");
                            break;
                        default:
                            break;
                    }
                    break;
            case 3:break loop1;
            default:break;
            }
        }
    }
}
