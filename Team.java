public class Team {
    String teamName;
    String speaker1;
    String speaker2;
    String speaker3;
    String institute;

    public Team(String teamName, String speaker1, String speaker2, String speaker3, String institute) {
        this.teamName = teamName;
        this.speaker1 = speaker1;
        this.speaker2 = speaker2;
        this.speaker3 = speaker3;
        this.institute =  institute;
    }

    public String toString() {
        return teamName + " (" + speaker1 + ", " + speaker2 + ", " + speaker3 + ")" + institute;
    }
}
