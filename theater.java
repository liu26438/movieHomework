package movieSystem;

public class theater {
    String[][] seat=new String[8][13];
    int seat_number=84;
    public theater()
    {
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<13;j++)
            {
                if(i==0) seat[i][j]=Integer.toString(j);
                else if(j==0) seat[i][j]= Integer.toString(i);
                else seat[i][j]="O";
            }
        }
    }
    public void show_seat()
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 13; j++)
            {
                System.out.print(seat[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public void choose_seat(int i,int j)
    {
        seat[i][j]="X";seat_number--;
    }
    public void release_seat(int i,int j)
    {
        seat[i][j]="X";seat_number++;
    }

}
