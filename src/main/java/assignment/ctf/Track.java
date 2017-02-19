package assignment.ctf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2/17/2017.
 */
public class Track {
    private List<Session> sessions;

    public Track() {
        this.sessions = new ArrayList<Session>();
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void addAllSessions(Session... sessions) {
        for (Session session : sessions) {
            this.addSession(session);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Session session : sessions) {
            stringBuilder.append(session);
        }
        return stringBuilder.toString();
    }
}
