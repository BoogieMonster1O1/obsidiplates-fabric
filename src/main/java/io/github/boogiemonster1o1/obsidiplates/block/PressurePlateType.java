package io.github.boogiemonster1o1.obsidiplates.block;

public enum PressurePlateType {
    NORMAL(false),
    SILENT(true);

    private final boolean silent;

    PressurePlateType(boolean silent) {
        this.silent = silent;
    }

    public boolean isSilent() {
        return silent;
    }
}
