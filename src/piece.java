import java.util.LinkedList;

public class piece {
    int xp,yp,x,y;
    boolean iswhite;
    LinkedList<piece> ps;
    String name;
    public piece (int xp, int yp, boolean iswhite, String n,LinkedList<piece> ps){
        this.xp=xp;
        this.yp=yp;
        x=xp*64;
        y=yp*64;
        this.iswhite=iswhite;
        this.ps=ps;
        name=n;
        ps.add(this);
    }
    public void move(int xp,int yp){

        if(  Main.getPiece(xp*64,yp*64 )!=null) {
            if (Main.getPiece(xp*64,yp*64 ).iswhite!=iswhite){
                Main.getPiece(xp * 64, yp * 64).kill();
        }else {
       x= this.xp*64;
      y= this.yp*64;
      return ;
            }
        }
        this.xp=xp;
        this.yp=yp;
        x=xp*64;
        y=yp*64;
    }public void kill(){
        ps.remove(this);
    }
}
