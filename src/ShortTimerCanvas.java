import java.awt.*;

public class ShortTimerCanvas extends Canvas {
    private ShortTimerModel model;
    private Canvas timerCanvas = new Canvas();
    private int width = 320;
    private int height = 320;

    ShortTimerCanvas(ShortTimerModel model){
        this.model = model;
        timerCanvas.setPreferredSize(new Dimension(width,height));
    }

    @Override
    public void paint (Graphics g){
        int midWidth = getWidth()/2;
        int midHeight = getHeight()/2;
        int diameter = 300;
        int radius = diameter/2;
        //draw circle:
        g.setColor(Color.BLACK);
        g.fillArc(midWidth-radius, midHeight-radius,diameter,diameter,0,360); //x,y Position im Canvas; dann Abmessungen
        //draw elapsed time:
        g.setColor(Color.BLUE);
        g.fillArc(midWidth-radius, midHeight-radius,diameter,diameter,90,(int) (model.getElapsedPart() * -360));

    }
}