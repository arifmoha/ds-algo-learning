package algo.dp;

public class TowerOfHanoi {
    public static void main(String[] args){
        towerOfHanoi(3, 'A', 'B', 'C');
    }

    private static void towerOfHanoi(int n, char source, char aux, char dest){
        if(n == 1){
            System.out.println("Move from "+source+ " to "+dest);
            return;
        }
        //move n-1 pegs from source to aux
        towerOfHanoi(n-1, source, dest, aux);

        // move nth peg from source to dest
        System.out.println("Move from "+source+ " to "+dest);

        // move n-1 pegs from aux to dest
        towerOfHanoi(n-1, aux, source, dest);
    }
}
