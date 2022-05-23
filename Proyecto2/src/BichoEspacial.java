public class BichoEspacial extends Bicho{

    public BichoEspacial(){
        this.setTipoBicho("BE");
        this.setSalud(30);
    }
    public BichoEspacial(String tipoBicho, int salud){

        super(tipoBicho, salud);
    }

}
