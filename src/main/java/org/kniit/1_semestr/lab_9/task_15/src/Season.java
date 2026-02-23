public enum Season {

    WINTER("Холодно", "Новый год"),
    SPRING("Тепло", "Пасха"),
    SUMMER("Жарко", "День независимости"),
    AUTUMN("Прохладно", "Хэллоуин");

    private final String temperature;
    private final String holiday;

    Season(String temperature, String holiday) {
        this.temperature = temperature;
        this.holiday = holiday;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHoliday() {
        return holiday;
    }

    public String getNameRus(){
        switch (this) {
            case WINTER: return "Зима";
            case SPRING: return "Весна";
            case SUMMER: return "Лето";
            case AUTUMN: return "Осень";
            default: return this.name();
        }
    }

    @Override
    public String toString() {
    return String.format(
        "%s: %s, типичный праздник - %s",
        this.getNameRus(),              
        this.getTemperature(),
        this.getHoliday()
    );
}
}
