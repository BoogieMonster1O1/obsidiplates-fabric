package io.github.boogiemonster1o1.obsidiplates.block;

public enum PressurePlateType {
    NORMAL(true),
    SILENT(false);

    private final boolean sound;

    PressurePlateType(boolean sound) {
        this.sound = sound;
    }

    public boolean isNoisy() {
        return sound;
    }
}
