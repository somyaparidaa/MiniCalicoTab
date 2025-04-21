public class Adj {
        String name;
        String institution;
    
        public Adj(String name, String institution) {
            this.name = name;
            this.institution = institution;
        }
    
        public String toString() {
            return name + " (" + institution + ")";
        }
    
}
