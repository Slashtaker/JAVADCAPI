import com.google.gson.annotations.SerializedName;

public class hi {
    @SerializedName("match")
    private Double match;
    @SerializedName("mismatch")
    private Double mismatch;

    public Double getMatch() {
        return match;
    }

    public void setMatch(Double match) {
        this.match = match;
    }

    public Double getMismatch() {
        return mismatch;
    }

    public void setMismatch(Double mismatch) {
        this.mismatch = mismatch;
    }
}
