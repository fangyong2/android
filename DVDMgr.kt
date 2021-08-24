import java.util.*

class DVDMgr/*初始三个DVD*/ {

    /*创建数组存储DVD信息*/
    private var dvdList = mutableSetOf<DVDBean>()

    init {
        val dvdBean1 = DVDBean("罗马假日", 0, 1, 15)
        val dvdBean2 = DVDBean("风声鹤唳", 1, 0, 12)
        val dvdBean3 = DVDBean("浪漫满屋", 1, 0, 30)
        dvdList.add(dvdBean1)
        dvdList.add(dvdBean2)
        dvdList.add(dvdBean3)
    }

    fun init() {
        var choose = 1 // 判断用户是否选择退出或是非法操作，1为初始值2为退出或者非法操作
        do {
            /*
             * 开始菜单
             */
            println("欢 迎 使 用 迷 你 DVD 管 理 器")
            println("-------------------------------------")
            println("1. 新 增 DVD")
            println("2. 查 看 DVD")
            println("3. 删 除 DVD")
            println("4. 借 出 DVD")
            println("5. 归 还 DVD")
            println("6. 退 出DVD")
            print("--------------------------------------\n")
            print("请选择： ")
            val input = Scanner(System.`in`)
            when (input.nextInt()) {
                1 ->{
                    /** 新增DVD*/
                    println("新增DVD")
                    add()
                }
                2 ->{
                    /** 查看DVD*/
                    println("查看DVD")
                    view()
                }
                3 ->{
                    /** 删除DVD**/
                    println("删除DVD")
                    del()
                }
                4 ->{
                    /** 借出DVD*/
                    println("借出DVD")
                    arr()
                }
                5 ->{
                    /** 归还DVD并计算租金*/
                    println("归还DVD并计算租金")
                    get()
                }
                6 -> choose = 2 // 用户选择退出
                else -> {
                    println("非法操作")
                    choose = 2 // 用户没有输入1到6的整形数据则属于非法操作直接退出程序
                }
            }
            if (choose != 2) { // 如果为2则是用户选择了退出或者是非法操作
                println("输入0返回 ")
                val back = input.nextInt()
                if (back != 0) { // 如果用户没选择0则为非法操作
                    println("非法操作")
                    choose = 2
                }
            }
        } while (choose == 1) // 判断用户择退出还是返回
        print("谢谢使用")
    }

    private fun view() {
        println("---> 查看DVD\n")
        println("序号\t状 态\t名称\t\t借出日期\t借出次数")
        if (dvdList.isEmpty()) {
            return
        }
        for ((i, dvdBean: DVDBean) in dvdList.withIndex()) {
            if (dvdBean.state == 0) { // state[i]为0则说明该DVD已借出
                println(
                    (i + 1).toString() + "\t已借出\t" + "<<"
                            + dvdBean.name + ">>\t" + dvdBean.date + "日\t"
                            + dvdBean.count + "次"
                )
            } else if (dvdBean.state == 1) { // state[i]为1则说明该DVD可借
                println(
                    ((i + 1).toString() + "\t可借\t" + "<<"
                            + dvdBean.name + ">>\t" + dvdBean.date + "日\t"
                            + dvdBean.count + "次")
                )
            }
        }
        println("**************************")
    }

    private fun add(){
        val input = Scanner(System.`in`)
        println("---> 新增DVD\n")
        print("请输入DVD名称： ")
        val name = input.next()

        val dvdBean = DVDBean(name,1,0,0)
        dvdList.add(dvdBean)
        println("新增《$name》成功！")
        println("**************************")
    }

    private fun del(){
        val input = Scanner(System.`in`)
        var flag = false// 标识删除成功与否
        println("---> 删除DVD\n")
        print("请输入DVD名称： ")
        val name = input.next()
        // 遍历数组，查找匹配信息
        for(dvdBean:DVDBean in dvdList){
            //查找到DVD
            if(dvdBean.name.equals(name)){
                //可借状态
                if (dvdBean.state == 1) {
                    dvdList.remove(dvdBean)
                    println("删除 $name 成功！")
                    flag = true// 表示删除成功
                    break
                }else {
                    println("《$name》为借出状态，不能删除！")
                }

            }

        }
        if (!flag) { // 若flag不为true则说明用户输入的名称在names数组中没有匹配成功
            println("没有匹配成功")
        }
        println("**************************")
    }

    private fun get(){
        val input = Scanner(System.`in`)
        println("---> 归还DVD\n")
        val charge: Int// 租金
        print("请输入DVD名称： ")
        val want = input.next()
        if(dvdList.isEmpty()){
            println("没有找到匹配信息！")
        }else{
            for (dvdBean:DVDBean in dvdList) {
                if (dvdBean.name.equals(want) && dvdBean.state == 0) { // 找到匹配
                    dvdBean.state = 1
                    print("请输入归还日期：")

                    var redate = input.nextInt()
                    while (redate < dvdBean.date!! || redate > 31) { // 归还日期的数据校验
                        redate = if (redate < dvdBean.date!!) {
                            print("归还日期不能小于借出日期,请重新输入：")
                            input.nextInt()
                        } else {
                            print("一个月只有31天，请重新输入：")
                            input.nextInt()
                        }
                    }
                    charge = redate - dvdBean.date!!
                    println("\n归还《$want》成功!")
                    println("借出日期为：${dvdBean.date}日")
                    println("归还日期为：$redate 日")
                    println("应付租金（元）：$charge")
                    break
                } else if (dvdBean.name.equals(want) && dvdBean.state == 1) { // 找到匹配但没有借出
                    println("该DVD没有被借出！无法进行归还操作。")
                    break
                }
            }
        }

        println("**************************")
    }

    private fun arr(){
        val input = Scanner(System.`in`)
        println("---> 借出DVD\n")
        print("请输入DVD名称： ")
        val want = input.next() // 要借出的DVD名称
        if (dvdList.isEmpty()){
            println("没有找到匹配信息！")
        }else{
            for (dvdBean:DVDBean in dvdList) {
                if (dvdBean.name.equals(want) && dvdBean.state == 1) { // 找到匹配可借
                    dvdBean.state = 0 // 将此DVD置于借出状态
                    print("请输入借出日期：")
                    dvdBean.date = input.nextInt()
                    while (dvdBean.date!! < 1 || dvdBean.date!! > 31) { // 一个月只有31天则需要数据校验
                        print("必须输入大于等于1且小于等于31的数字，请重新输入：")
                        dvdBean.date = input.nextInt()
                    }
                    println("借出《$want》成功!")
                    dvdBean.count = dvdBean.count!! + 1
                    break
                }else if (dvdBean.name.equals(want) && dvdBean.state == 0) { // 找到匹配已被借出
                    println("《$want》已被借出！")
                    break
                }
            }
        }
        println("**************************")
    }
}


fun main(args:Array<String>){
    val dvdmgrPop = DVDMgr()
    dvdmgrPop.init()
}