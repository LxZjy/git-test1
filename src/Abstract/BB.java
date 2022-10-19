package Abstract;

public class BB extends Template{
    public void job(){
        int num=0;
        for (long i = 0; i < 8000000; i++) {
            num*=i;
        }
    }
}
