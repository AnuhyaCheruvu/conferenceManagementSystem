package assignment.ctf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2/17/2017.
 */
public class Conference {
    private List<Track> tracks;

    public Conference() {
        this.tracks = new ArrayList<Track>();
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void addTrack(Track track) {
        this.tracks.add(track);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < tracks.size(); i++) {
            str.append("Track " + (i + 1) + ":" + "\n");
            str.append(tracks.get(i));
            str.append("\n");
        }
        return str.toString();
    }
}
