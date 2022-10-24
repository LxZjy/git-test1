package HomeWork;


/*有一个容量为10L的空水桶。水桶的上面开始往里灌水，同时下面开始往出流水。
第一分钟灌水的速度是1L/min，第二分钟灌水的速度是2L/min，第三分钟灌水的速度是3L/min，
以此类推。而流水的速度固定是3L/min。那么几分钟之后，水桶里能保持灌满水的状态？*/
public class HomeWork05 {
    public static void main(String[] args) {
       int min=0;//定义所用的分钟
       int sum=0;//定义水桶水量
        while (sum<=10){
            min++;//分钟数增加
            sum+=min-3;
            if (sum<0){
                sum=0;
            }
        }
        System.out.println("装水所用"+min+"分钟 ");
    }
}
