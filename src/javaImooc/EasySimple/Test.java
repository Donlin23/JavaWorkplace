package javaImooc.EasySimple;

/**
 * @Author:Donlin
 * @Description: 测试x++和++x运算
 * @Date: Created in 16:44 2018/1/29
 * @Version: 1.0
 */
public class Test {


        public static void main(String[] args)
        {
            int x = 0;
            int y = 0;
            int k = 0;
            for (int z = 0; z < 5; z++) {
                if ((++x > 2) && (++y > 2) && (k++ > 2))
                {
                    x++;
                    ++y;
                    k++;
                }
            }
            System.out.println(x + ""+y + "" +k);
        }

}
