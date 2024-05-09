import java.time.LocalTime;

public abstract  class ClockHand {
    public abstract void setTime(LocalTime clockTime);
    public abstract String toSvg();
}
