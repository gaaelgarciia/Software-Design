package e2;

public class ImmutableMatrix {
    private final int[][] matriz;
    public ImmutableMatrix(int[][] arr) {  //constructor para copiar los valores de un array bidimensional de valores enteros
        this.matriz = new int[arr.length][arr[0].length];
        int primeraFila=arr[0].length;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length!=primeraFila){
                throw new IllegalArgumentException("Matriz Irregular");  //Excepción en caso de que la matriz sea irregular
            }
            System.arraycopy(arr[i], 0, this.matriz[i], 0, arr[0].length);
        }

    }

    public ImmutableMatrix(int f, int c){  //Constructor que recibe nºfilas y columnas y crea una matriz que va rellenando desde 1 hasta n
                if(f<=0 || c<=0){
                    throw new IllegalArgumentException("Los valores tienen que ser enteros mayores que 0");  //Excepción para que las filas y columnas sean enteros mayores que 0
                }else{
                    this.matriz=crearMatriz(f,c);
                }

    }
    private int [][] crearMatriz(int filas,int columnas){   //Crearemos la matriz
        int [][] mat=new int [filas][columnas];
        int a=1;
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                mat[i][j]=a;
                a++;
            }
        }
        return mat;
    }

    public String toString(){ //Devuelve una representación en String de la matriz
        StringBuilder mat=new StringBuilder();
        for (int[] ints : matriz) {
            mat.append("[");
            for (int j = 0; j < ints.length; j++) {
                mat.append(ints[j]).append(j==ints.length-1?"]\n":", ");

            }
        }
        return mat.toString();
    }
    public int at(int i,int j){  //Devuelve el elemento de la posición indicada
        if(i<0 || i>matriz.length || j<0 || j>matriz[0].length){
            throw new IllegalArgumentException("Coordenadas no válidas");  //Excepción si la posición indicada no se encuentra en la matriz
        }else{
        return matriz[i][j];}
    }
    public int rowCount(){  //Devuelve el numero de filas
        return matriz.length;
    }
    public int columnCount(){  //Devuelve el numero de columnas
        return matriz[0].length;
    }
    public int[][] toArray2D(){  //Devuelve la copia del array en 2D
        int f=matriz.length;
        int c=matriz[0].length;
       int [][] array2=new int[f][c];
       for(int i=0;i<f;i++){
           System.arraycopy(matriz[i], 0, array2[i], 0, c);
       }
        return array2;
    }
    public ImmutableMatrix transpose(){  //Devuelve la traspuesta de la matriz
        int f=matriz.length;
        int c=matriz[0].length;
        int [][] array2=new int[c][f];
        for(int x=0;x<f;x++){
            for(int y=0;y<c;y++){
               array2[y][x]=matriz[x][y];
            }
        }
        return new ImmutableMatrix(array2);
    }
    public ImmutableMatrix reverse(){  //Devuelve la inversa de la matriz
        int [][] array2=new int [matriz.length][matriz[0].length];
        for(int x=0;x<matriz.length;x++){
            for(int y=0;y<matriz[x].length;y++){
                array2[x][y]=matriz[x][matriz[x].length-y-1];
            }
        }
        return new ImmutableMatrix(array2);
    }
    public ImmutableMatrix reshape(int newColumns){  //Devuelve la matriz modificada en función del valor de las nuevas columnas
        int f=matriz.length;
        int c=matriz[0].length;
        int newRows=(f*c)/newColumns;
        int [][] array2=new int [newRows][newColumns];
        if((f*c)%newColumns!=0){
            throw new IllegalArgumentException("La matriz nueva no puede ser irregular");
        }else{
            for(int i=0;i<f;i++){
                for(int j=0;j<c;j++){
                    int a=i*c+j;
                    int newRow=a/newColumns;
                    int newCol=a%newColumns;
                    array2[newRow][newCol]=matriz[i][j];
                }
            }

        }
        return new ImmutableMatrix(array2);
    }

}