package image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageTestMode extends ImageBase {

    Color color = Color.LIGHT_GRAY;

    public ImageTestMode(String imageId, int width, int height, Color color) {
        super(imageId, width, height);
        this.color = color;
    }

    @Override
    protected void createImage() {
        image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(color);
        graphics.drawOval(0,0,width,height);
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }
}
