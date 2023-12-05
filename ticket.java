package movieSystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ticket {
    int ID;
    session_infor session1;
    int row;
    int column;
    String buytime;
    boolean take_ticket=false;
    public ticket(int ID,session_infor session1,int row,int column)
    {
        this.ID=ID;
        this.session1=session1;
        this.row=row;
        this.column=column;
        Date date=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.buytime= formatter.format(date);
    }
    public void show_ticket()
    {
        System.out.println("购买时间："+this.buytime);
        System.out.println("ID："+this.ID);
        this.session1.show_session_infor();
        System.out.println("排数："+this.row);
        System.out.println("列数："+this.column);
    }
}