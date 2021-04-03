import java.awt.Robot;
import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import java.awt.image.BufferedImage;
import java.awt.BorderLayout;



public class Main{
    private static Robot robot;

    private static final Color brownColor = new Color(166,117,51);
    private static final int leftX = 630;
    private static final int leftY = 360;
    private static final int rightX = 740;
    private static final int rightY = 360;
    private static final int delay = 30;
    private static final int secondDelay = 180;
    private static int[] next = new int[3];

    private static JFrame frame;
    private static JLabel label;
    public static void display(BufferedImage image){
        if(frame==null){
            frame=new JFrame();
            frame.setTitle("stained_image");
            frame.setSize(image.getWidth(), image.getHeight());
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            label=new JLabel();
            label.setIcon(new ImageIcon(image));
            frame.getContentPane().add(label,BorderLayout.CENTER);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);
        }else 
            label.setIcon(new ImageIcon(image));
    }

    private static boolean checkLeft(){
        Color color = robot.getPixelColor(leftX, leftY);
        return color.getRGB()==brownColor.getRGB();
    }

    private static boolean checkRight(){
        Color color = robot.getPixelColor(rightX,rightY);
        return color.getRGB()==brownColor.getRGB();
    }

    private static void press(int keycode){
        robot.keyPress(keycode);
        robot.keyRelease(keycode);
    }

    private static void getThreeNextMove(){
        
    }

    public static void main(String[] args){
        try{
            robot = new Robot();
        }
        catch(Exception e){
            return;
        }
        robot.delay(2000);

        int score = 700;

        for(int i=0;i<score/6;i++){
            getThreeNextMove();
            for(int j:next){
                if(j==0){
                    press(KeyEvent.VK_LEFT);
                    robot.delay(delay);
                    press(KeyEvent.VK_LEFT);
                }
                else{
                    press(KeyEvent.VK_RIGHT);
                    robot.delay(delay);
                    press(KeyEvent.VK_RIGHT);
                }
            }
            robot.delay(secondDelay);
        }
    }
}
