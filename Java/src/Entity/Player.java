package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public final class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp,KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();

    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;
        direction = "up";

    }

    public void getPlayerImage() {

        try{

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite1forward.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite2forward.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite1down.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite2down.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite1left.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite2left.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite1right.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite2right.png"));

        }catch(IOException e) {
            e.printStackTrace();
        }


    }

    public void update() {
        if(keyH.upPressed == true) {
            direction = "up";
            y -= speed;
        }
        else if(keyH.downPressed == true) {
            direction = "down";
            y += speed;
        }
        else if(keyH.leftPressed == true) {
            direction = "left";
            x -= speed;
        }
        else if(keyH.rightPressed == true) {
            direction = "right";
            x += speed;
        }
    }
    
    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch(direction){

        case "up1" -> image = up1;

        case "down1" -> image = down1;

        case "left1" -> image = left1;
        
        case "right1" -> image = right1;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }


}