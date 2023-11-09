public class functions {


    public static int fatorialInterativa(int num){
        
        int resposta = 1; //r=1 

        for(int i = 1; i <= num ; i++){ //i=1; i<=6; i++
            resposta = resposta * i; //r=1*1; r=1*2; r=2*3; r=6*4; r=24*5; r=120*6
        }

        return resposta;
    }
    

    public static int fatorialRecursiva(int num){
        
        if(num == 0){
            return 1;
        }else{
            return num * fatorialRecursiva(num - 1);
        }
    }

    public static int 











}
