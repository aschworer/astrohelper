package com.aygui.astrologyhelper.model;

/**
 * Created by aschworer on 01-Nov-15.
 */
public class CharacteristicsInSign {

    private Characteristics characteristic;
    private Sign sign;
    private Double angle;
    private String angleStr;

    public CharacteristicsInSign() {
    }

    public CharacteristicsInSign(Characteristics characteristic, Sign sign) {
        this.characteristic = characteristic;
        this.sign = sign;
    }

    public Characteristics getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Characteristics characteristic) {
        this.characteristic = characteristic;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public void setAngleStr(String angleStr) {
        this.angleStr = angleStr;
    }

    public Sign getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return characteristic + ": " + sign + " (" + sign.getElement() + ")";
    }


}
