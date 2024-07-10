import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShortTimerCanvasTest {
    public static void main(String[] args) {
        int time = 60; //runtime
        ShortTimerModel timerModel = new ShortTimerModel(time);
        ShortTimerCanvas timerCanvas = new ShortTimerCanvas(timerModel);

        TextField tf_timeSec = new TextField(timerModel.getElapsedTimeInSeconds() + " Sekunden", 20);
        TextField tf_timePart = new TextField(String.format("%.2f", (timerModel.getElapsedPart() * 100)) + " %", 20);
        Panel p_time = new Panel();
        p_time.add(tf_timePart, BorderLayout.NORTH);
        p_time.add(tf_timeSec, BorderLayout.SOUTH);

        Frame frame = new Frame("Zeit-Fortschritt");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.add(p_time, BorderLayout.NORTH);
        frame.add(timerCanvas, BorderLayout.CENTER);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        while (timerModel.getElapsedPart() < 1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timerModel.increaseElapsedTime();
            timerCanvas.repaint();
            tf_timePart.setText(String.format("%.2f", (timerModel.getElapsedPart() * 100)) + " %");
            tf_timeSec.setText(timerModel.getElapsedTimeInSeconds() + " Sekunden");
        }
    }
}