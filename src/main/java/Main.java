import zero.Color;
import zero.GameApp;
import zero.ui.Button;
import zero.ui.Label;
import zero.ui.Row;

public class Main extends GameApp {
    private Toast toast;
    private int clicks;
    private Label clickLabel;
    private Label message;

    @Override public void settings() {
        padding(20);
        size(640, 400);
    }

    @Override public void setup() {
        clickLabel = new Label("");
        message = new Label("");
        var restartButton = new Button("Restart");
        restartButton.onClick(() -> restart());
        controls(new Row(12, clickLabel, message, restartButton));
        restart();
    }

    public void restart() {
        toast = new Toast(width() / 2.0, height() / 2.0, 60);
        clicks = 0;
        clickLabel.setText("Clicks: 0");
        message.setText("Click the toast to make it grow!");
        showGame();
    }

    @Override public void update(double seconds) {
        if (mousePressed() && toast.contains(mouseX(), mouseY())) {
            toast.grow(12);
            clicks++;
            clickLabel.setText("Clicks: " + clicks);
        }
    }

    @Override public void draw() {
        background(Color.WHITE);
        toast.draw(this);

        textSize(20);
        text("Click the toast!", 20, 30);
    }
}