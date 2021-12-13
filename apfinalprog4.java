import java.awt.image.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;
public class apfinalprog4 {
    public static void main(String[] args) throws Exception{
    Scanner sc = new Scanner(System.in) ;
    int timestoarnold = sc.nextInt();
    BufferedImage image = ImageIO.read(new File("C:\\Users\\ylhy2\\OneDrive\\Desktop\\apcs final\\encodedpicture.bmp"));
    BufferedImage image2 = ImageIO.read(new File("C:\\Users\\ylhy2\\OneDrive\\Desktop\\apcs final\\encodedpicture.bmp"));
    Boolean shorterHeight = true;
    int shorterlength = 0;
    if(image.getWidth()>image.getHeight()){
        shorterlength = image.getHeight();
    }
    else{
        shorterHeight = false;
        shorterlength = image.getWidth();
    }
    /*
    if(shorterHeight==false){
        for(int x=0;x<shorterlength;x++){
            for(int y=shorterlength-1;y>=0;y--){
                int nx=x;
                int ny=y-shorterlength-1;
                for(int i=0;i<timestoarnold;i++){
                    int holder1 = nx;
                    int holder2 = ny;
                    nx=Math.floorMod(2*holder1-holder2, shorterlength);
                    ny=Math.floorMod(-holder1+holder2, shorterlength);
                }
                int pixel = image.getRGB(x,y);
                Color color = new Color(pixel, true);
                image2.setRGB(nx, shorterlength-ny-1+image.getHeight()-shorterlength, color.getRGB());
            }
        }
        for(int x=0;x<image.getWidth();x++){
            for(int y = 0;y<image.getHeight();y++){
                int pixel = image2.getRGB(x,image.getHeight()-y-1);
                Color color = new Color(pixel,true);
                image.setRGB(x,image.getHeight()-y-1,color.getRGB());
            }
        }
        for(int x=0;x<shorterlength;x++){
            for(int y = image.getHeight()-1;y>=image.getHeight()-shorterlength;y--){
                int nx=x;
                int ny=image.getHeight()-y-1;
                for(int i=0;i<timestoarnold;i++){
                    int holder1 = nx;
                    int holder2 = ny;
                    nx=Math.floorMod(2*holder1-holder2, shorterlength);
                    ny=Math.floorMod(-holder1+holder2, shorterlength);
                }
                int pixel = image.getRGB(x,y);
                Color color = new Color(pixel, true);
                image2.setRGB(nx, image.getHeight()-ny-1, color.getRGB());  
            }
        }
    }
    */
    if(shorterHeight==true || image.getHeight()==image.getWidth()){
            for(int x=image.getWidth()-shorterlength;x<image.getWidth();x++){
                for(int y=0;y<shorterlength;y++){
                    int nx=x+shorterlength-image.getWidth();
                    int ny=y;
                    for(int i=0;i<timestoarnold;i++){
                        int holder1 = nx;
                        int holder2 = ny;
                        nx=Math.floorMod(2*holder1-holder2, shorterlength);
                        ny=Math.floorMod(-holder1+holder2, shorterlength);
                    }
                    int pixel = image.getRGB(x,image.getHeight()-y-1);
                    Color color = new Color(pixel, true);
                    image2.setRGB(nx+image.getWidth()-shorterlength, image.getHeight()-ny-1, color.getRGB());
                }
            }
        for(int x=0;x<image.getWidth();x++){
            for(int y = 0;y<image.getHeight();y++){
                int pixel = image2.getRGB(x,y);
                Color color = new Color(pixel,true);
                image.setRGB(x,y,color.getRGB());
            }
        }
        for(int x=0;x<shorterlength;x++){
           for(int y=0;y<shorterlength;y++){
                int nx=x;
                int ny=y;
                for(int i=0;i<timestoarnold;i++){
                    int holder1 = nx;
                    int holder2 = ny;
                    nx=Math.floorMod(2*holder1-holder2, shorterlength);
                    ny=Math.floorMod(-holder1+holder2, shorterlength);
                    }
                int pixel = image.getRGB(x,shorterlength-y-1);
                Color color = new Color(pixel, true);
                image2.setRGB(nx, shorterlength-ny-1, color.getRGB());
            }
        }
        
    }
    File fileoutput = new File("C:\\Users\\ylhy2\\OneDrive\\Desktop\\apcs final\\decodedpicture.bmp");
    ImageIO.write(image2,"bmp", fileoutput);
    }
    
}
