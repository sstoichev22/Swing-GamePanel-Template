import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public interface SGTKeyInput extends KeyListener {
    @Override
    default void keyPressed(KeyEvent e){}
    @Override
    default void keyReleased(KeyEvent e){}
    @Override
    default void keyTyped(KeyEvent e){}
}
