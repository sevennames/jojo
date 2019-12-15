package image;

import util.ResourceLoader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageNomal extends ImageBase{
    String imageId;
    String resPath;
    String filePath;

    public ImageNomal(String imageId, int width, int height, String filePath, String resPath) {
        super(imageId, width, height);
        this.filePath = filePath;
        this.resPath = resPath;
    }

    @Override
    protected void createImage() {
        try {
            image = ImageIO.read(ResourceLoader.load(ImageNomal.class, filePath, resPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setPosition(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public BufferedImage getImage() {
        return this.image;
    }
}
