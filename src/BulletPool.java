import java.util.ArrayList;
import java.util.List;

public class BulletPool {

    public static BulletPool instance;
    private List<Bullet> bullets = new ArrayList<Bullet>();


    public static BulletPool getInstance(){
        if (instance==null){
            instance = new BulletPool();
        }
        return instance;
    }

    private BulletPool() {
        for( int i = 0; i<50; i++){
            bullets.add(new Bullet(0,0,0,0));
        }
    }

    public Bullet acquireBullets(int x, int y, int dx, int dy){
        if (bullets.isEmpty()){
            for (int i =0; i<50;i++){
                bullets.add(new Bullet(0,0,0,0));
            }
        }
        Bullet bullet = bullets.get(0);
        bullet.setXY(x,y);
        bullet.setDxDy(dx,dy);
        bullets.remove(0);
        return bullet;
    }

    public void returnBullet(Bullet bullet){
        bullets.add(bullet);
    }

}
