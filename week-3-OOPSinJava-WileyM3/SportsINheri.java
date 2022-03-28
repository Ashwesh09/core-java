class Sports {
    String getName() {
        return "Generic Sports";
    }

    void getNumberOfTeamMembers() {
        System.out.println("Each team has n players in " + getName());
    }
}

class Soccer extends Sports {

    @Override
    String getName() {
        return "Soccer Class";
    }
    @Override
    void getNumberOfTeamMembers() {
       System.out.printf("Each team has %d player in: %s%n", 11, getName());
    }
}

public class SportsINheri {
    public static void main(String[] args) {
        Sports s = new Sports();
        Soccer c = new Soccer();
        System.out.println(s.getName());
        s.getNumberOfTeamMembers();
        System.out.println(c.getName());
        c.getNumberOfTeamMembers();
    }
    
}   
