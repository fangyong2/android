import java.util.*;

public class DVD4 {

    /*创建数组存储DVD信息*/
//    static Set<String> names = new TreeSet<String>(); // 存储DVD名称数组
//    static Set<Integer> state = new TreeSet<Integer>(); // 存储DVD借出状态：0已借出/1可借
//    static Set<Integer> date = new TreeSet<Integer>(); // 存储DVD借出日期
//    static Set<Integer> count = new TreeSet<Integer>(); // 借出次数
    //存储方式，共享存储
//    static List<String> names = new ArrayList<String>(); // 存储DVD名称数组
//    static List<Integer> state = new ArrayList<Integer>(); // 存储DVD借出状态：0已借出/1可借
//    static List<Integer> date = new ArrayList<Integer>(); // 存储DVD借出日期
//    static List<Integer> count = new ArrayList<Integer>(); // 借出次数

    static Set<DVDBean> dvdList = new TreeSet<DVDBean>();

	public DVD4() {
        /*初始三个DVD*/
        DVDBean dvdBean1 = new DVDBean("罗马假日",0,1,15);
        DVDBean dvdBean2 = new DVDBean("风声鹤唳",1,0,12);
        DVDBean dvdBean3 = new DVDBean("浪漫满屋",1,0,30);

        dvdList.add(dvdBean1);
        dvdList.add(dvdBean2);
        dvdList.add(dvdBean3);
    }
    public void view(){
        System.out.println("---> 查看DVD\n");
        System.out.println("序号\t状 态\t名称\t\t借出日期\t借出次数");
        if(dvdList.isEmpty()){
            return;
        }
        int i = 0;
        for (DVDBean dvdBean:dvdList) {

            if (dvdBean.getState() == 0) { // state[i]为0则说明该DVD已借出
                System.out.println((i + 1) + "\t已借出\t" + "<<"
                        + dvdBean.getName() + ">>\t" + dvdBean.getDate() + "日\t"
                        + dvdBean.getCount() + "次");
            } else if (dvdBean.getState() == 1) { // state[i]为1则说明该DVD可借
                System.out.println((i + 1) + "\t可借\t" + "<<"
                        + dvdBean.getName() + ">>\t" + dvdBean.getDate() + "日\t"
                        + dvdBean.getCount() + "次");
            }
            i++;
        }
        System.out.println("**************************");
    }
    public void del(){
        Scanner input = new Scanner(System.in);
        boolean flag = false;// 标识删除成功与否
        System.out.println("---> 删除DVD\n");
        System.out.print("请输入DVD名称： ");
        String name = input.next();
        // 遍历数组，查找匹配信息
        for(DVDBean dvdBean:dvdList){
            //查找到DVD
            if(dvdBean.getName().equals(name)){
                //可借状态
                if (dvdBean.getState() == 1) {
                    dvdList.remove(dvdBean);
                    System.out.println("删除《" + name + "》成功！");
                    flag = true;// 表示删除成功
                    break;
                }else {
                    System.out.println("《" + name + "》为借出状态，不能删除！");
                }

            }

        }
        if (!flag) { // 若flag不为true则说明用户输入的名称在names数组中没有匹配成功
           System.out.println("没有匹配成功");
        }
        System.out.println("**************************");
    }
    public void add(){
        Scanner input = new Scanner(System.in);
        System.out.println("---> 新增DVD\n");
        System.out.print("请输入DVD名称： ");
        String name = input.next();

        DVDBean dvdBean = new DVDBean(name.toLowerCase(),1,0,0);
        dvdList.add(dvdBean);
        System.out.println("新增《" + name + "》成功！");
        System.out.println("**************************");
    }
    public void get(){
//        Scanner input = new Scanner(System.in);
//        System.out.println("---> 归还DVD\n");
//        int charge = 0;// 租金
//        System.out.print("请输入DVD名称： ");
//        String want = input.next();
//        for (int i = 0; i < names.length; i++) {
//            if (names[i] == null) { // 无匹配
//                System.out.println("没有找到匹配信息！");
//                break;
//            } else if (names[i].equals(want) && state[i] == 0) { // 找到匹配
//                state[i] = 1;
//                System.out.print("请输入归还日期：");
//
//                int redate = input.nextInt();
//                while (redate < date[i] || redate > 31) { // 归还日期的数据校验
//                    if (redate < date[i]) {
//                        System.out.print("归还日期不能小于借出日期,请重新输入：");
//                        redate = input.nextInt();
//                    } else {
//                        System.out.print("一个月只有31天，请重新输入：");
//                        redate = input.nextInt();
//                    }
//                }
//                charge = redate - date[i];
//                System.out.println("\n归还《" + want + "》成功!");
//                System.out.println("借出日期为：" + date[i] + "日");
//                System.out.println("归还日期为：" + redate + "日");
//                System.out.println("应付租金（元）：" + charge);
//                break;
//            } else if (names[i].equals(want) && state[i] == 1) { // 找到匹配但没有借出
//                System.out.println("该DVD没有被借出！无法进行归还操作。");
//                break;
//            }
//        }
//        System.out.println("**************************");
    }
    public void arr(){
//        Scanner input = new Scanner(System.in);
//        System.out.println("---> 借出DVD\n");
//        System.out.print("请输入DVD名称： ");
//        String want = input.next(); // 要借出的DVD名称
//        for (int i = 0; i < names.length; i++) {
//            if (names[i] == null) { // 无匹配
//                System.out.println("没有找到匹配信息！");
//                break;
//            } else if (names[i].equals(want) && state[i] == 1) { // 找到匹配可借
//                state[i] = 0; // 将此DVD置于借出状态
//                System.out.print("请输入借出日期：");
//                date[i] = input.nextInt();
//                while (date[i] < 1 || date[i] > 31) { // 一个月只有31天则需要数据校验
//                    System.out.print("必须输入大于等于1且小于等于31的数字，请重新输入：");
//                    date[i] = input.nextInt();
//                }
//                System.out.println("借出《" + want + "》成功!");
//                count[i]++;
//                break;
//            } else if (names[i].equals(want) && state[i] == 0) { // 找到匹配已被借出
//                System.out.println("《" + want + "》已被借出！");
//                break;
//            }
//        }
//        System.out.println("**************************");
    }
    public void init(){
        int choose = 1; // 判断用户是否选择退出或是非法操作，1为初始值2为退出或者非法操作
        do {
            /*
             * 开始菜单
             */
            System.out.println("欢 迎 使 用 迷 你 DVD 管 理 器");
            System.out.println("-------------------------------------");
            System.out.println("1. 新 增 DVD");
            System.out.println("2. 查 看 DVD");
            System.out.println("3. 删 除 DVD");
            System.out.println("4. 借 出 DVD");
            System.out.println("5. 归 还 DVD");
            System.out.println("6. 退 出DVD");
            System.out.print("--------------------------------------\n");
            System.out.print("请选择： ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            /*
             * switch循环提供菜单选择操作
             */
            switch (choice) {
                case 1:
                    /*
                     * 新增DVD
                     */
                    add();

                    break; // 跳出switch循环
                case 2:
                    /*
                     * 查看DVD
                     */
                    view();
                    break;
                case 3:
                    /*
                     * 删除DVD
                     */
                    del();
                    break;
                case 4:
                    /*
                     * 借出DVD
                     */
                    arr();
                    break;
                case 5:
                    /*
                     * 归还DVD并计算租金
                     */
                    get();
                    break;
                case 6:
                    choose = 2; // 用户选择退出
                    break;
                default:
                    System.out.println("非法操作");
                    choose = 2; // 用户没有输入1到6的整形数据则属于非法操作直接退出程序
                    break;
            }
            if (choose != 2) {// 如果为2则是用户选择了退出或者是非法操作
                System.out.println("输入0返回 ");
                int back = input.nextInt();
                if (back != 0) {// 如果用户没选择0则为非法操作
                    System.out.println("非法操作");
                    choose = 2;
                }
            }
        } while (choose == 1); // 判断用户择退出还是返回
        System.out.print("谢谢使用");
    }

    public static void main(String[] a) {
        DVD4 dvd = new DVD4();
        dvd.init();

    }
}
