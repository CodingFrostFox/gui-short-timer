public class ShortTimerModel {
    private int totalTimeInSeconds;
    private int elapsedTimeInSeconds;

    public ShortTimerModel(int totalTimeInSeconds) { //new instance for runtime x
        this.totalTimeInSeconds = totalTimeInSeconds;
    }

    public double getElapsedPart() {
        return (double) elapsedTimeInSeconds / totalTimeInSeconds;
    }

    public int getElapsedTimeInSeconds () {
        return elapsedTimeInSeconds;
    }

    public void increaseElapsedTime() {
        elapsedTimeInSeconds++;
    }
}