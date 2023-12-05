package movieSystem;

public class movie_infor {
    String movie_name;
    private String director_name;
    private String performer_name;
    private String introduction;
    private String duration;
    public void show_movie_infor()
    {
        System.out.println("片名："+movie_name);
        System.out.println("导演："+director_name);
        System.out.println("主演："+performer_name);
        System.out.println("剧情简介："+introduction);
        System.out.println("时长："+duration);
    }
    public void add_modify(String movie_name,String director_name,
                       String performer_name,String introduction,String duration)
    {
        this.movie_name=movie_name;
        this.director_name=director_name;
        this.performer_name=performer_name;
        this.introduction=introduction;
        this.duration=duration;
    }
}
