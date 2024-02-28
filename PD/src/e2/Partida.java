package e2;


public class Partida {
    private Flota flota;
    private Nodo map;
    public Partida(Flota flota,Nodo map){
        this.flota=flota;
        this.map=map;
    }
    public String simularIncursion(){
        map.ejecutar(flota);
        if(flota.getHP()>0){
            return "Sortie Result:\nSUCCESS\nLast Visited Node: " + flota.getLastVisitedNode() + "\nFinal HP: " + flota.getHP();
        }else{
            return "Sortie Result:\nFAIL\nLast Visited Node: " + flota.getLastVisitedNode() + "\nFinal HP: " + flota.getHP();
        }
    }
    public String minimoNodos(){
        int minNodeCount = obtenerminimo(map);
        return ("Smallest Node Count to End: " + minNodeCount);
    }

    private static int obtenerminimo(Nodo node) {
        if (node.getChildren().isEmpty()) {
            return 1;
        } else {
            int minCount = Integer.MAX_VALUE;
            for (Nodo child : node.getChildren()) {
                int childCount = obtenerminimo(child);
                minCount = Math.min(minCount, childCount);
            }
            return 1 + minCount;
        }



    }

    public String representarEstructuraNewick(Nodo nodo) {
        StringBuilder resultado = new StringBuilder();
        resultado.append("(");
        representacionNewickRecursivo(nodo, resultado);
        return resultado.toString();
    }

    private static void representacionNewickRecursivo(Nodo nodo, StringBuilder resultado) {

        resultado.append(nodo.getLetter()).append(" ").append(nodo.getName());


        if (!nodo.getChildren().isEmpty()) {
            resultado.append(", (");
            for (int i = 0; i < nodo.getChildren().size(); i++) {
                representacionNewickRecursivo(nodo.getChildren().get(i), resultado);
                if (i < nodo.getChildren().size() - 1) {
                    resultado.append(", (");
                }
            }
            resultado.append(")");
        }
        else{
            resultado.append(")");
        }
    }



}
