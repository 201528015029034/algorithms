package sort;

/**
 * Created by test on 2017/3/24.
 */

/**
 * 测试排序
 */
public class Test {
    public static void main(String[] args) {
        Double[] datas = new Double[1000];
        int[] sameDatas = new int[1000];
        for(int i=0; i<datas.length; i++) {
            datas[i] = 10000 * Math.random();
            if (Math.random() > 0.5) {
                sameDatas[i] = 100;
            }else {
                sameDatas[i] = i;
            }
        }

        System.out.println(System.currentTimeMillis());
//        QuickSort.sort(sameDatas);
        HeapSort.sort(sameDatas);
        System.out.println(System.currentTimeMillis());
        for(int i=0; i<sameDatas.length; i++) {
            if(i>0 && sameDatas[i]<sameDatas[i-1]) {
                System.out.println("error");
                break;
            }
            System.out.print(sameDatas[i] + " ");
        }
    }
}
