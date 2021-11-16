package src.Materiel;

import src.Algo.isValid;

public class Price implements isValid{
    private float value;
    public Price(float value){
        this.value = value;
    }
    @Override
    public boolean isValid() {
        return this.value > 0;
    }

    public float getValue() {
        return this.value;
    }
}
