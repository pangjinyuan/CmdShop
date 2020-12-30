import user.User;

import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        开始读文件
         */
        boolean bool = true;
        while (bool) {
            System.out.println("请输入用户名：");

            Scanner sc = new Scanner(System.in);
            String username = sc.next();//阻塞方法
            System.out.println("你输入的用户名：" + username);

            System.out.println("请输入密码：");
            String password = sc.next();

            System.out.println("你输入的密码是：" + password);

            //File file = new File("C:\\Users\\庞\\IdeaProjects\\CmdShop\\src\\users.xlsx");
            InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");// /表示的就是classpath

            InputStream inpro = Class.forName("Test").getResourceAsStream("/product.xlsx");// /表示的就是classpath

            ReadUserExcel readExcel = new ReadUserExcel();//创建对象
            User users[] = readExcel.readExcel(in);

            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("登陆成功");
                    bool = false;
                    break;
                } else {
                    System.out.println("登陆失败");
                }
            }
            ReadProductExcel readProductExcel = new ReadProductExcel();
            Product products[] = readProductExcel.getAllProduct(inpro);
            for (Product product : products) {
                System.out.print(product.getId());
                System.out.print("\t" + product.getName());
                System.out.print("\t" + product.getPrice());
                System.out.println("\t" + product.getDesc());
            }
            System.out.println("请输入商品ID，把该商品加入购物车:");
            String pId=sc.next();
            ReadProductExcel readProductExcel1=new ReadProductExcel();
            inpro= Class.forName("Test").getResourceAsStream("/product.xlsx");// /表示的就是classpath

            Product product=readProductExcel1.getProductById(pId,inpro);


}
    }
}