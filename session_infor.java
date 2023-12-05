package movieSystem;

public class session_infor {
    public int theater_NO;
    public String period;
    public int price;
    public String movie_name;
    public session_infor(int theater_NO,String period,int price,String movie_name)
    {
        this.theater_NO=theater_NO;
        this.period=period;
        this.price=price;
        this.movie_name=movie_name;
    }
    public void motify_session(String movie_name)
    {
        this.movie_name=movie_name;
    }
    public void motify_session()
    {
        this.movie_name=null;
    }
    public void show_session_infor()
    {
        System.out.println("放映厅："+theater_NO);
        System.out.println("时段："+period);
        System.out.println("价格："+price);
        System.out.println("放映的电影："+movie_name);
    }
}
