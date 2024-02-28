package e4;

public enum BolaBillar {
    BLANCA(0,"BLANCO","LISA"),
    BOLA1(1,"AMARILLO","LISA"),
    BOLA2(2, "AZUL", "LISA"),
    BOLA3( 3," ROJO"," LISA"),
    BOLA4( 4," VIOLETA ","LISA"),
    BOLA5( 5," NARANJA"," LISA"),
    BOLA6( 6," VERDE"," LISA"),
    BOLA7( 7 ,"GRANATE"," LISA"),
    BOLA8( 8," NEGRO"," LISA"),
    BOLA9( 9," AMARILLO"," RAYADA"),
    BOLA10(10," AZUL"," RAYADA"),
    BOLA11( 11," ROJO"," RAYADA"),
    BOLA12(12," VIOLETA"," RAYADA"),
    BOLA13( 13," NARANJA"," RAYADA"),
    BOLA14( 14," VERDE"," RAYADA"),
    BOLA15( 15," GRANATE"," RAYADA");
    private final  int number;
    private final String colour;
    private final String type;
     BolaBillar(int number,String colour,String type){
        this.number=number;
        this.colour=colour;
        this.type=type;
    }
    public int getNumber(){
        return number;
    }
    public String getColour(){
        return colour;
    }
    public String getType(){
        return type;
    }

}
