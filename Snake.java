package MiniProject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    List<Point> snakePointer;
    int xDir, yDir;
    boolean isMoving, elongate;
    final int StartSIZE= 20, STARTX= 150, STARTY= 150;

    public Snake(){
        snakePointer= new ArrayList<Point>();
        xDir= 0;
        yDir= 0;
        isMoving= false;
        elongate= false;
        snakePointer.add(new Point(STARTX, STARTY));
        for(int i=1 ; i<StartSIZE ; i++){
            snakePointer.add(new Point(STARTX - i*4, STARTY));

        }
    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        for(Point p: snakePointer){
            g.fillRect(p.getX(), p.getY(), 4, 4);

        }
    }

    public void move(){
        if (isMoving){
            Point temp= snakePointer.get(0);
            Point last= snakePointer.get(snakePointer.size() - 1);
            Point newStart= new Point(temp.getX() + xDir * 4, temp.getY() + yDir * 4);
            for(int i=snakePointer.size() - 1 ; i>=1 ; i--){
                snakePointer.set(i, snakePointer.get(i-1));
            }
            snakePointer.set(0, newStart);
            if(elongate){
                snakePointer.add(last);
                elongate= false;
            }
        }

    }

    public boolean snakeCollision(){
        int x= this.getX();
        int y= this.getY();

        for(int i=1 ; i<snakePointer.size() ; i++){
            if(snakePointer.get(i).getX() == x && snakePointer.get(i).getY() == y){
                return  true;
            }
        }
        return false;
    }

    public boolean isMoving(){
        return isMoving;
    }

    public void setIsMoving(boolean b) {
        isMoving = b;
    }

    public int getXDir() {
        return xDir;
    }

    public void setXDir(int x) {
        xDir = x;
    }

    public int getYDir() {
        return yDir;
    }

    public void setYDir(int y) {
        yDir = y;
    }

    //will give X position of head of the snake
    public int getX(){
        return snakePointer.get(0).getX();
    }

    public int getY(){
        return snakePointer.get(0).getY();
    }

    public void setElongate(boolean b){
        elongate= b;
    }
}
