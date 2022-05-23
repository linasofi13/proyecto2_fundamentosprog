public class BichoAlien extends Bicho{

    public BichoAlien(){
        this.setTipoBicho("BA");
        this.setSalud(20);
    }
    public BichoAlien(String tipoBicho, int salud){
        super(tipoBicho, salud);
    }


}
