public class Player {
    private final String playerName;
    private int stamina;
    private Position[] positions;
    private int skillRating;

    public Player() {
        this("Lionel Messi", 75, new Position[]{Position.FORWARD}, 100);
    }

    public Player(String playerName, Position[] positions) {
        this(playerName, 75, positions, 80);
    }

    public Player(String playerName, int stamina, Position[] positions, int skillRating) {
        this.playerName = playerName;

        if (stamina <= 100 && stamina >= 0) {
            this.stamina = stamina;
        } else {
            this.stamina = 75;
        }

        if (positions.length == 0) {
            this.positions = new Position[]{Position.MIDFIELDER};
        } else {
            this.positions = positions;
        }

        this.skillRating = skillRating;
        if (skillRating <= 100 && skillRating >= 90) {
            System.out.println("Skill rating: Excellent");
        } else if (skillRating <= 89 && skillRating >= 80) {
            System.out.println("Skill rating: Great");
        } else if (skillRating <= 79 && skillRating >= 70) {
            System.out.println("Skill rating: Very Good");
        } else if (skillRating <= 69 && skillRating >= 60) {
            System.out.println("Skill rating: Good");
        } else if (skillRating <= 59 && skillRating >= 50) {
            System.out.println("Skill rating: Fine");
        } else if (skillRating <= 49 && skillRating >= 40) {
            System.out.println("Skill rating: Bad");
        } else {
            this.skillRating = 80;
            System.out.println("Skill rating: Great");
        }
    }

    public Boolean isTrainable() {
        return skillRating <= 89 && skillRating >= 50;
    }

    public Position preferredPosition() {
        return positions[0];
    }

    public Boolean canPlayAs(Position position) {
        for (Position pos : positions) {
            if (pos == position) {
                return true;
            }
        }
        return false;
    }

    public int getSkillRating() {
        return skillRating;
    }

    public void setSkillRating(int skillRating) {
        this.skillRating = skillRating;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public String toString() {
        return String.format("<%s,%d,%s,%d,%b>", playerName, stamina, preferredPosition(), skillRating, isTrainable());
    }
}
