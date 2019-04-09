package club.jzzdev.guessnumber;

public class Score {
    private int score;
    private long time;

    public Score(int score, long time) {
        this.score = score;
        this.time = time;
    }

    public Score() {
        super();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
