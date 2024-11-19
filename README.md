# Swing-GamePanel-Template
## Download
- [Download sgtlib.jar](https://github.com/sstoichev22/Swing-GamePanel-Template/blob/main/releases/sgtlib.jar)

Swing GamePanel Template AKA SGT simplifies the complexity of making a game in java. Whenever I make a game in java, I have 3 files of boilerplate code, Main with like 15 lines of code, GamePanel with 60 lines of code, and Input with 20 lines of code, I didn't like rewriting the same code over so I made a simple library to not require the use of any and simplifies all of it. An entire game of a square moving around with 'wasd' can be made with less than 50 lines of code in Main.
```
static int x = 0, y = 0, speed = 3;
static boolean up, down, left, right;
```
All varibles used in the lambdas will have to be static to get away with the mutability of varibles in anonymous classes.
```
JFrame frame = new JFrame("sgt game");
SGT sgt = new SGT(800, 800, 120);
frame.add(sgt);
frame.pack();
frame.setVisible(true);
```
Code simular to a normal game, a JFrame to make it as SGT only simplifies the GamPanel and Input classes. for SGT you give it 3 parameters, screen width, screen height, and however many frames per second(fps) you want. Pack is still needed as the component is setting the size and not the frame.
```
sgt.SGTKeyInput(new SGTKeyInput() {
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) up = true;
        if(e.getKeyCode() == KeyEvent.VK_A) left = true;
        if(e.getKeyCode() == KeyEvent.VK_S) down = true;
        if(e.getKeyCode() == KeyEvent.VK_D) right = true;
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) up = false;
        if(e.getKeyCode() == KeyEvent.VK_A) left = false;
        if(e.getKeyCode() == KeyEvent.VK_S) down = false;
        if(e.getKeyCode() == KeyEvent.VK_D) right = false;
    }
});
```
Method in SGT to add a 'KeyListener' essentially. All methods are defualt so not all are required, there are 3: keyPressed, keyReleased, keyTyped, all with the same method signature. The code in the overridden methods is for the keys 'wasd', changing the boolean varialbes for the 4 cardinal directions.

There is also Mouse input, use:
```
sgt.SGTMouseInput(new SGTMouseInput()...
```
The 5 methods in here are mouseClicked, mousePressed, mouseReleased, mouseEntered, and mouseExited. All are default.

Both the mouse and key related methods mimic MouseListener and KeyListener respectively and just replace the methods to be default to keep tidyness.
```
sgt.SGTUpdate(() -> {
    if(up) y-=speed;
    if(left) x-=speed;
    if(down) y+=speed;
    if(right) x+=speed;
});
```
The update method: anything that needs updating every frame, in this example the code in this method would be executed 120 times per second just like the fps.
```
sgt.SGTPaintComponent((g)->{
    g.fillRect(x, y, 100, 100);
});
```
PaintComponent, has a variable g(Graphics class), code used in the PaintComponent method you override in a typical JFrame/JPanel game can be copied to here.
```
sgt.startThread();
sgt.showFPS();
```
Start thread is needed to start the game thread, showfps displays the amount of fps in the console if you need it.
