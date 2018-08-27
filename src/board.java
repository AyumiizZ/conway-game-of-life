public class board {
    private cell[][] current;
    private cell[][] nextGen;
    private long width;
    private long height;

    public board(int width, int height) {
        this.width = width;
        this.height = height;
        this.current = new cell[height + 2][width + 2];
        this.nextGen = new cell[height + 2][width + 2];
        for(int i = 0; i < height+2;i++){
            for(int j = 0; j < width+2; j++){
                this.current[i][j] = new cell();
                this.nextGen[i][j] = new cell();
            }
        }
    }

    public void printBoard() {
        System.out.println("== Board ==");
        for (int i = 1; i <= this.height; i++) {
            for (int j = 1; j <= this.width; j++) {
                if (this.current[i][j].isAlive()) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
        System.out.println("===========");
    }

    public void printN() {
        System.out.println("==== N ====");
        for (int i = 1; i <= this.height; i++) {
            for (int j = 1; j <= this.width; j++) {
                System.out.print(this.current[i][j].getNeighbor());
            }
            System.out.println();
        }
        System.out.println("===========");
    }

    public void setCell(boolean isAlive, int width, int height) {
        this.current[height][width].setAlive(isAlive);
        for(int i = -1;i <= 1;i++){
            for(int j = -1;j <= 1;j++){
                if(i == 0 && j == 0 && width >= 1 && width <= this.width && height >= 1 && height <= this.height){
                    continue;
                }
                else if (isAlive){
                    this.current[height+i][width+j].plusOneNighbor();
                }
                else if (!isAlive){
                    this.current[height+i][width+j].minusOneNighbor();
                }
            }
        }
    }

    public void changeGen() {
        calculateNextGenAlive();
        for (int i = 1; i <= this.height; i++) {
            for (int j = 1; j <= this.width; j++) {
                this.current[i][j].setAlive(this.nextGen[i][j].isAlive());
                this.current[i][j].setNeighbor(calculateNextGenNighbor(i,j));
            }
        }
    }

    private int calculateNextGenNighbor(int x,int y){
        int nighbor = 0;
        for(int i = -1;i <= 1;i++){
            for(int j = -1;j <= 1;j++){
                if(i == 0 && j == 0){
                    continue;
                }
                else if(this.nextGen[x+i][y+j].isAlive()){
                    nighbor++;
                }
            }
        }
        return nighbor;
    }

    private void calculateNextGenAlive() {
        for (int i = 1; i <= this.height; i++) {
            for (int j = 1; j <= this.width; j++) {
                this.nextGen[i][j].setAlive(this.current[i][j].isSurvive());
            }
        }
    }
}
