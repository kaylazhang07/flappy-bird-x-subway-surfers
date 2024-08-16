import javax.swing.*;
public class Sprite{
    PImage image;
    float x, y,dx,dy;
    float w,h;

    public  Sprite(String filename, float scale, float xi, float yi){
        image =loadImage(filename);
        w=image.width*scale;
        h=image.height*scale;
        x=xi;
        y=yi;
        dx=0;
        dy=0;
    }
    public Sprite(String filename, float scale){
        this(filename, scale,0,0);
    }
    public  Sprite(PImage img, float scale, float xi, float yi){
        image =img;
        w=image.width*scale;
        h=image.height*scale;
        x=xi;
        y=yi;
        dx=0;
        dy=0;
    }
    public void display(){
        image(image,x,y,w,h);
    }
    public void update(){

        x+=dx;
        y+=dy;
        if(x<=0){
            x=900.0;
        }
    }

    void setImage(PImage img){image=img;}
}
