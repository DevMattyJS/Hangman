public enum HangmanParts {
    START(""),

    GALLOW ("""
              +---+
              |   |
                  |
                  |
                  |
                  |
            =========
            """),
    HEAD ("""
              +---+
              |   |
              O   |
                  |
                  |
                  |
            =========
            """),
    TORSO ("""
              +---+
              |   |
              O   |
              |   |
                  |
                  |
            =========
            """),
    LEFTHAND ("""
             +---+
              |   |
              O   |
             /|   |
                  |
                  |
            =========
            """),
    RIGHTHAND ("""
              +---+
              |   |
              O   |
             /|\\  |
                  |
                  |
            =========
            """),
    LEFTLEG ("""
              +---+
              |   |
              O   |
             /|\\  |
             /    |
                  |
            =========
            """),
    RIGHTLEG ("""
              +---+
              |   |
              O   |
             /|\\  |
             / \\  |
                  |
            =========
            """);

    private final String art;

    HangmanParts(String art) {
        this.art = art;
    }

    public String getArt() {
        return art;
    }

    public HangmanParts getNextStage() {
        HangmanParts[] allStages = values();
        return allStages[(ordinal() + 1) % allStages.length];
    }


}
