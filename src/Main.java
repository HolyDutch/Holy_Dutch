import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Main {
   public static LinkedList<piece> ps = new LinkedList<>();
   public static piece selectedpiece=null;
    public static void main(String[] args) throws IOException {

      BufferedImage all=ImageIO.read(new File("C://chess.png"));
            Image imgs[] = new Image[12];
            int ind = 0;
            for (int y = 0; y < 400; y += 200) {
                for (int x = 0; x < 1200; x += 200) {
                    imgs[ind] = all.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                    ind++;
                }
            }
        piece wrook=new piece(0,7,true,"rook",ps);
        piece wknight=new piece(1,7,true,"knight",ps);
        piece wbishop=new piece(2,7,true,"bishop",ps);
        piece wking=new piece(3,7,true,"king",ps);
        piece wqueen=new piece(4,7,true,"queen",ps);
        piece wbishop2=new piece(5,7,true,"bishop",ps);
        piece wkight2=new piece(6,7,true,"knight",ps);
        piece wrook2=new piece(7,7,true,"rook",ps);

        piece wpawn=new piece(0,6,true,"pawn",ps);
        piece wpawn1=new piece(1,6,true,"pawn",ps);
        piece wpawn2=new piece(2,6,true,"pawn",ps);
        piece wpawn3=new piece(3,6,true,"pawn",ps);
        piece wpawn4=new piece(4,6,true,"pawn",ps);
        piece wpawn5=new piece(5,6,true,"pawn",ps);
        piece wpawn6=new piece(6,6,true,"pawn",ps);
        piece wpawn7=new piece(7,6,true,"pawn",ps);

        piece brook=new piece(0,0,false,"rook",ps);
        piece bknight=new piece(1,0,false,"knight",ps);
        piece bbishop=new piece(2,0,false,"bishop",ps);
        piece bking=new piece(3,0,false,"king",ps);
        piece bqueen=new piece(4,0,false,"queen",ps);
        piece bbishop2=new piece(5,0,false,"bishop",ps);
        piece bkight2=new piece(6,0,false,"knight",ps);
        piece brook2=new piece(7,0,false,"rook",ps);

        piece bpawn=new piece(1,1,false,"pawn",ps);
        piece bpawn1=new piece(2,1,false,"pawn",ps);
        piece bpawn2=new piece(3,1,false,"pawn",ps);
        piece bpawn3=new piece(4,1,false,"pawn",ps);
        piece bpawn4=new piece(5,1,false,"pawn",ps);
        piece bpawn5=new piece(6,1,false,"pawn",ps);
        piece bpawn6=new piece(7,1,false,"pawn",ps);
        piece bpawn7=new piece(0,1,false,"pawn",ps);

            JFrame frame = new JFrame();
            frame.setBounds(10, 10, 512, 512);
            JPanel pn = new JPanel() {
                @Override
                public void paint(Graphics g) {
                    boolean white = true;
                    for (int y = 0; y < 8; y++) {
                        for (int x = 0; x < 8; x++) {
                            if (white) {
                                g.setColor(Color.white.darker());
                            } else {
                                g.setColor(Color.darkGray.brighter());
                            }
                            g.fillRect(x * 64, y * 64, 64, 64);
                            white = !white;
                        }
                        white = !white;
                    }
                 for (piece p: ps){
                     int ind=0;
                     if(p.name.equalsIgnoreCase("king")){
                         ind=0;
                     }     if(p.name.equalsIgnoreCase("queen")){
                         ind=1;
                     }     if(p.name.equalsIgnoreCase("bishop")){
                         ind=2;
                     }     if(p.name.equalsIgnoreCase("knight")){
                         ind=3;
                     }     if(p.name.equalsIgnoreCase("rook")){
                         ind=4;
                     }     if(p.name.equalsIgnoreCase("pawn")){
                         ind=5;
                     }
                     if( !p.iswhite){
                         ind+=6;
                     }
                     g.drawImage(imgs[ind],p.x,p.y,this);
                 }
                }
            };
            frame.add(pn);
            frame.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {
           System .out.println((getPiece(e.getX(), e.getY()).iswhite?" white":" gray ")+ getPiece(e.getX(),e.getY()).name);
                    selectedpiece=getPiece(e.getX(), e.getY());
                }

                @Override
                public void mouseReleased(MouseEvent e) {
            selectedpiece.move(e.getX()/64,e.getY()/64);
            frame.repaint();
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            frame.addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
          if(selectedpiece!=null){
              selectedpiece.x=e.getX()-32;
              selectedpiece.y= e.getY()-32;
              frame.repaint();
          }
                }

                @Override
                public void mouseMoved(MouseEvent e) {

                }
            });
            frame.setUndecorated(true);
            frame.setDefaultCloseOperation(3);
            frame.setVisible(true);
        }
        public static  piece getPiece(int x,int y){
        int xp=x/64;
        int yp=y/64;
        for(piece p:ps){
 if( p.xp==xp&&p.yp==yp) {
     return p;
 }
 }
 return null;
        }

    }
