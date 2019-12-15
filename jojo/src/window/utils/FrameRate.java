package window.utils;

public class FrameRate {
    private String frameRate;
    private long lastTime;
    private long delta;
    private int frameCount;
    public void initialize(){
        this.lastTime = System.currentTimeMillis();
        this.frameRate = "FPS 0";
    }
    public void calculate(){
        long current = System.currentTimeMillis();
        delta += current - this.lastTime;
        this.lastTime = current;
        frameCount++;
        if (delta > 1000){
            delta -= 1000;
            frameRate = String.format("FPS %s", this.frameCount);
            frameCount = 0;
        }
    }
    public String getFrameRate(){
        return this.frameRate;
    }

}
