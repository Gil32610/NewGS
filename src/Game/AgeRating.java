package Game;

public enum AgeRating {
    L("Adequado para todas as idades."),
    M10("Pode conter cenas de violência e linguagem imprópria moderad."),
    M12("Pode conter cenas de agressão física, insinuação de consumo de drogas e relações sexuais."),
    M14("Pode conter cenas de Agressão física, consumo explícito de drogas e relações sexuais moderadas."),
    M16("Pode conter cenas de consumo de drogas explícito, agressão física intensa e relações sexuais acentuadas"),
    M18("Pode conter cenas de indução e consumo de drogas, violência extrema, suicídio, cenas de sexo explícitas e disturbios psicossomáticos");

    private String description;

    private AgeRating(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}

