import user.User;

import java.io.InputStream;
import java.util.Scanner;

public class Test {
    static Scanner sc = new Scanner(System.in);
    static Product productes[] = new Product[3];//创建购物车（用数组模拟)

    public static void main(String[] args) throws ClassNotFoundException {
        /*
        开始读文件
         */
        boolean bool = true;
        while (bool) {
            System.out.println("请输入用户名：");


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
                    /*
                    显示商品信息
                     */
                    while (true) {
                        System.out.println("购买商品请按1");
                        System.out.println("查看购物车请按2");
                        System.out.println("结账请按3");
                        System.out.println("退出请按4");
                        int choose = sc.nextInt();
                        if (choose == 1) {
                            shopping(inpro);
                        }

                       /* System.out.println("继续购买商品请按1");
                        System.out.println("查看购物车请按2");
                        int choose = sc.nextInt();
                        if (choose == 1) {
                            inpro = null;
                            inpro = Class.forName("Test").getResourceAsStream("/product.xlsx");
                            readProductExcel = new ReadProductExcel();
                            products = readProductExcel.getAllProduct(inpro);
                            for (Product p : products) {
                                System.out.print(product.getId());
                                System.out.print("\t" + product.getName());
                                System.out.print("\t" + product.getPrice());
                                System.out.println("\t" + product.getDesc());
                            }
                            System.out.println("请输入商品ID把该商品加入购物车");
                            pId = sc.next();
                            inpro = null;
                            inpro = Class.forName("Test").getResourceAsStream("/product.xlsx");
                            product = readProductExcel1.getProductById(pId, inpro);
                            System.out.println("要购买的商品价格:" + product.getPrice());
                            if (product != null) {
                                productes[count++] = product;//添加购物车
                            }
                        }*/
                        else if (choose == 2) {
                            System.out.println("当前购物车商品如下:");
                            for (Product p : productes) {
                                System.out.print(p.getId());
                                System.out.print("\t" + p.getName());
                                System.out.print("\t" + p.getPrice());
                                System.out.println("\t" + p.getDesc());
                            }
                        } else if (choose == 4) {
                            break;
                        }
                    }
                    break;
                } else {
                    System.out.println("登陆失败");
                }
            }
        }

    }

    public static void shopping(InputStream inpro) throws ClassNotFoundException {
        ReadProductExcel readProductExcel = new ReadProductExcel();
        Product products[] = readProductExcel.getAllProduct(inpro);
        for (Product product : products) {
            System.out.print(product.getId());
            System.out.print("\t" + product.getName());
            System.out.print("\t" + product.getPrice());
            System.out.println("\t" + product.getDesc());
        }
                    /*
                    遍历数组
                     */
        int count = 0;

        System.out.println("请输入商品ID，把该商品加入购物车:");
        String pId = sc.next();
        ReadProductExcel readProductExcel1 = new ReadProductExcel();
        inpro = null;
        inpro = Class.forName("Test").getResourceAsStream("/product.xlsx");// /表示的就是classpath
        Product product = readProductExcel1.getProductById(pId, inpro);
        System.out.println("要购买的商品价格:" + product.getPrice());
        if (product != null) {
                            /*
                            把商品加入购物车
                             */
            productes[count++] = product;
        }

    }
}