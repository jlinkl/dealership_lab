package components;

public class Engine {
    private EngineType engine;

    public Engine(EngineType engine) {
        this.engine = engine;
    }

    public EngineType getEngineType() {
        return engine;
    }
}
