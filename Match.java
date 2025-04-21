public class Match {
    Team teamA;
    Team teamB;
    Adj adjudicator;
    String winner;

    public Match(Team teamA, Team teamB, Adj adjudicator) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.adjudicator = adjudicator;
    }

    public String toString() {
        return teamA + " vs " + teamB + " | Judge: " + adjudicator;
    }
}

