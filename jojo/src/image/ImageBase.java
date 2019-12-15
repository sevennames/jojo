package image;

import java.awt.image.BufferedImage;

abstract public class ImageBase {
    String imageId;
    int x;
    int y;
    int width;
    int height;
    BufferedImage image;

    public ImageBase(String imageId, int width, int height) {
        this.imageId = imageId;
        this.width = width;
        this.height = height;
        createImage();
    }
    protected abstract void createImage();
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String getImageId() {
        return imageId;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BufferedImage getImage() {
        return image;
    }
}
