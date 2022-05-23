public class BichoNormal extends Bicho{

    public BichoNormal(){
        this.setTipoBicho("BN");
        this.setSalud(10);
    }
    public BichoNormal(String tipoBicho, int salud){

        super(tipoBicho, salud);
    }

}
