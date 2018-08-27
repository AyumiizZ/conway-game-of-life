public class cell {
    private boolean alive;
    private int neighbor;

    public cell(){
        this.alive = false;
        this.neighbor = 0;
    }

    public boolean isAlive(){
        return this.alive;
    }

    public boolean isNotAlive(){
        return !this.alive;
    }

    public int getNeighbor(){
        return this.neighbor;
    }

    public void setAlive(boolean input){
        this.alive = input;
    }

    public void setNeighbor(int n){
        this.neighbor = n;
    }

    public boolean isSurvive(){
        if(this.neighbor == 3 && !this.alive)
            return true;
        if((this.neighbor == 3 || this.neighbor == 2) && this.alive)
            return true;
        return false;
    }

    public void plusOneNighbor(){
        neighbor++;
    }

    public void minusOneNighbor(){
        neighbor--;
    }
}
