package entity;

import core.ComboItem;

public class Pension {
    private int pensionId;
    private  int pensionHotelId;
    private Pension.Type type;

    public Pension() {
    }
    public enum Type{
        ULTRA_ALL_INCLUSIVE,
        ALL_INCLUSIVE,
        ROOM_BREAKFAST,
        FULL_PENSION,
        HALF_PENSION,
        ONLY_BED,
        FULL_CREDIT_EXC_ALCH,
    }

    public int getPensionId() {
        return pensionId;
    }

    public void setPensionId(int pensionId) {
        this.pensionId = pensionId;
    }

    public int getPensionHotelId() {
        return pensionHotelId;
    }

    public void setPensionHotelId(int pensionHotelId) {
        this.pensionHotelId = pensionHotelId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    public ComboItem getComboItem () {
        return new ComboItem(this.type.ordinal(), getType().toString());
    }
}
