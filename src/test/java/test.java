import java.util.Random;
import java.util.Scanner;

public class test {

    /*public static void main(String[] args) {
        //猜字符
        //1.生成字符
        //2.接收用户输入字符
        //2.对比生成的字符和用户输入的字符
        char[] chr = new char[]{'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',};
        int math = (int) (Math.random() * 27);//0.99999
        char ch = chr[math];//生成随机字符  赋值给ch
        Scanner scan = new Scanner(System.in);//创建对象
        System.out.println("请输入您猜的字母：");
        String str = scan.next();
        //字符无法和字符串进行比较
        //so 对字符串进行去空白。转成大写。转成字符数组 后保存到user变量中
        char[] user = str.trim().toUpperCase().toCharArray();
        //用户输入的和生成的是否一致
        //取字符数组中的第一个元素 与 程序生成的随机字符相比较
        if (user[0] == ch) {
            System.out.println("恭喜您猜对了^O^");
        } else {
            System.out.println("非常遗憾猜错了，继续加油哦");
        }
        System.out.println("正确答案：" + ch);//打印生成的随机字符 作为提示
    }*/

    public static void main(String[] args) {
        // 随机生成数字
        int num = new Random().nextInt(100)+1;
        // 定义一个值用来判断输入次数
        int count = 0;
        // 对象
        Scanner scanner = new Scanner(System.in);
        // for循环
        for (int i = 0; i < 5; i++) {
            // 将count 每次加1 和 count = count + 1 一样 你可以试试
            // count = count + 1;
            count++;
            System.out.println("请输入你猜的数字(1-100)");
            // 获取控制台输入数子
            int guessNum = scanner.nextInt();
            // 判断是否等于
            if (guessNum == num) {
                // 判断输入次数是否等于5 不等于执行else里面的值，等于输出值
                if (count == 5) {
                    System.out.println("非常遗憾猜错了，一共猜了：" + count + " 次");
                } else {
                    System.out.println("恭喜你才对了，一共猜了：" + count + " 次");
                }
            // 判断是否大于
            }else if (guessNum > num) {
                // 判断输入次数是否等于5 不等于执行else里面的值，等于输出值
                if (count == 5) {
                    System.out.println("非常遗憾猜错了，一共猜了：" + count + " 次");
                } else {
                    System.out.println("太大了，在小一点");
                }
             // 判断是否小于
            } else if (guessNum < num) {
                // 判断输入次数是否等于5 不等于执行else里面的值，等于输出值
                if (count == 5) {
                    System.out.println("非常遗憾猜错了，一共猜了：" + count + " 次");
                } else {
                    System.out.println("太小了，在大一点");
                }
            }

        }
        // for结束把正确答案输出
        System.out.println("正确答案：" + num );

    }



}
