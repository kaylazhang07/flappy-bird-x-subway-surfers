import javax.swing.*;
public class FlappyBird {
    PImage bg1,bg2,bg3,bird_wUP,bird_w1,bird_w2,bird_w3,pillar1t,pillar1b;
    int iW;
    int size_x,size_y;
    float MOVE_SPEED, PILLAR_MOVE_SPEED;
    float x, y,dx,dy;
    Sprite Bird,Pillar_1T,Pillar_1B,Pillar_2T,Pillar_2B,Pillar_3T,Pillar_3B;

    void setup() {
        //set frame and background
        size_x=900; size_y=600;
        size(900, 600);
        bg1 = loadImage("sky.png");
        imageMode(CENTER);

        //Create bird and load images
        bird_w1 = loadImage("bird1a.png");
        bird_w2 = loadImage("bird2a.png");
        bird_w3 = loadImage("bird3a.png");
        Bird =new Sprite(bird_w2,0.4,size_x/4,size_y/2);

        //Create pillars and load images
        pillar1t= loadImage("pillar.png");
        pillar1b= loadImage("pillar.png");

        Pillar_1T=new Sprite(pillar1t,0.5,size_x-30,size_y/5);
        Pillar_1B=new Sprite(pillar1b,0.5,size_x-30,size_y*3/5+20);
        Pillar_2T=new Sprite(pillar1t,0.5,size_x*4/3,size_y/5+100);
        Pillar_2B=new Sprite(pillar1b,0.5,size_x*4/3,size_y*3/5+120);
        Pillar_3T=new Sprite(pillar1t,0.5,size_x*5/3,size_y/5-100);
        Pillar_3B=new Sprite(pillar1b,0.5,size_x*5/3,size_y*3/5-80);

        //Initialize variables that control the motion
        iW=0;

        MOVE_SPEED=1;
        PILLAR_MOVE_SPEED=1;
        Pillar_1T.dx=-PILLAR_MOVE_SPEED;
        Pillar_1B.dx=-PILLAR_MOVE_SPEED;
        Pillar_2T.dx=-PILLAR_MOVE_SPEED;
        Pillar_2B.dx=-PILLAR_MOVE_SPEED;
        Pillar_3T.dx=-PILLAR_MOVE_SPEED;
        Pillar_3B.dx=-PILLAR_MOVE_SPEED;


    }

    void draw() {
        background(bg1);

        shiftBirdImage();
        Bird.display();
        Bird.update();
        showPillars();
        iW+=1;
    }

    //Make bird fly
    void shiftBirdImage(){
        if(iW%16==0||iW%16==8){
            Bird.setImage(bird_w2);
        }
        else if(iW%16==4){
            Bird.setImage(bird_w1);
        }
        else if(iW%16==12){
            Bird.setImage(bird_w3);
        }
    }

    //Use UP/DOWN keys to move the bird
    void keyPressed(){
        if(keyCode==UP){
            Bird.dy=-MOVE_SPEED;
        }
        else if (keyCode==DOWN){
            Bird.dy=MOVE_SPEED;;
        }


    }


    void keyReleased(){
        if(keyCode==DOWN){
            Bird.dy=0;
        }
        else if (keyCode==UP){
            Bird.dy=0;
        }
    }


    //Update and move the pillars
    void showPillars(){
        Pillar_1T.display();
        Pillar_1B.display();
        Pillar_2T.display();
        Pillar_2B.display();
        Pillar_3T.display();
        Pillar_3B.display();

        Pillar_1T.update();
        Pillar_1B.update();
        Pillar_2T.update();
        Pillar_2B.update();
        Pillar_3T.update();
        Pillar_3B.update();

    }




}
