package game_content;

public interface GameObject {
    boolean behitted(GameObject from);
    boolean hit(GameObject to);
    void toattack(int damage);
    Box[] getHitbox();
    int getdamage();
}
