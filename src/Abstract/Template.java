package Abstract;

abstract public class Template {//抽象类-模板设计模式
    public  abstract void job();
    public void calculateTime(){
        //得到开始的时间
        long start=System.currentTimeMillis();
        job();
        //结束的时间
        long end=System.currentTimeMillis();
        System.out.println("执行的时间"+(end-start));

    }
}
