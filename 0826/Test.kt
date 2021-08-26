class Test {
}

fun main(args:Array<String>){

    /*面向过程编程语言开始*/
    println("hello world!!!")

    //变量val var
    var a:Int = 1
    val b:Float = 2.0f
    val c = a +b
    val d = "123"
    println(c)

    //类型转换
    val aa:Byte = 1
    val bb = aa.toFloat()

    /*字符串模版*/
    val s = "fy"
    println("hello $s")

    /*if*/
    val score = 60
    if(score>=60){
        println("ok")
    }else{
        println("not ok")
    }

    if(score>=90){
        println("A")
    }else if(score>=80){
        println("B")
    }else if(score>=70){
        println("C")
    }else if(score>=60){
        println("D")
    }else{
        println("E")
    }

    /*变量+if*/
    val result = if(score>=60){
        "ok"
    }else{
        "not ok"
    }
    println(result)

    /*when表达式 = if 或 switch case*/
    when{
        score>=60 -> println("ok...")
        else -> println("not ok")
    }

    val degress = "D"
    when(degress){
        "A" -> println("90-100")
        "B" -> println("80-90")
        "C" -> println("70-80")
        "D" -> println("60-70")
        else -> println("60以下")
    }

    val menu = 11
    when(menu){
        1,2 -> println("菜单1 或 菜单2")
        else -> println("菜单3")
    }

    when(menu){
        in 1..10 -> println("菜单1-10")
        !in 1..10 -> println("非 菜单1-10")
        else -> println("其他菜单")
    }

    //函数的定义
    fun sum(a:Int,b:Int): Int {
        return a+b
    }
    println(sum(1,2))

    //函数 + when
//    val x = 1
//    when(x){
//        in 1..10 -> println("x is in range")
//        else -> println("none of the above")
//    }

//    fun menu(x:Int){
//        when(x){
//            in 1..10 -> println("x is in range")
//            else -> println("none of the above")
//        }

    fun menu(x:Int) = when(x){
            in 1..10 -> println("x is in range")
            else -> println("none of the above")
        }
    menu(1)

    /*数组*/
    val arr = arrayOf(1,2,3,4,"fy")
    println(arr.size)

    val arrB = Array<Int>(6) { i -> i * i }


    /*for in  3种*/
    for(value in arrB){
        println("$value")
    }
    for(index in arrB.indices){
        println("$index\t")
    }

    for((index,value) in arrB.withIndex()){
        println("index=$index,value=$value")
    }

    //1+2+3+4...10=55
    var count = 0
    for(i in 1..10){
        count+=i
    }
    println(count)

    //1++3+.5.7.9=25
    count = 0
    for(i in 1..10){
        if(i % 2 ==0){
            continue
        }
        count+=i
    }
    println(count)

    //1++3+.5.=9
    count = 0
    for(i in 1..10){
        if(i % 2 ==0){
            continue
        }
        if(i==7){
            break
        }
        count+=i
    }
    println(count)

    //while do while
    //1+2+3+4...10=55
    count = 0
    var i = 0
    while(i<10){
        i++
        count+=i
    }
    println(count)

    //1+2+3+4...10=55
    count = 0
    i = 0
    do{
        i++
        count+=i
    } while(i<10)
    println(count)
    /*面向过程编程语言结束*/

    /*kotlin :集合 collection (list set), map 开始*/
    //list................
    val list = listOf<Int>(1,2,3,4,5,6)
    for((index,value) in list.withIndex()){
        println("index=$index,value=$value")
    }
    val mutableList = mutableListOf<Int>(10,20,30,40,50,60)
    for((index,value) in mutableList.withIndex()){
        println("index=$index,value=$value")
    }
    //添加
    mutableList.add(70)
    //修改
    mutableList[0] = 100
    //删除
    mutableList.remove(50)
    for((index,value) in mutableList.withIndex()){
        println("index=$index,value=$value")
    }

    //set................
    println("====================")
    val set = setOf<Int>(1,2,2,3,4,5)
    for((index,value) in set.withIndex()){
        println("index=$index,value=$value")
    }
    val mutableSet = mutableSetOf<Int>(10,20,20,30,40,50)
    for((index,value) in mutableSet.withIndex()){
        println("index=$index,value=$value")
    }
    //添加
    mutableSet.add(70)
    //修改
    //删除
    mutableSet.remove(50)
    for((index,value) in mutableSet.withIndex()){
        println("index=$index,value=$value")
    }

    //map................
    println("====================")
    val map = mapOf<String,Int>("key1" to 1,"key2" to 2)
    map.forEach{
            (key,value) -> println("key=$key,value=$value")
    }
    val mutableMap = mutableMapOf<String,Int>("key1" to 10,"key2" to 20)
    mutableMap.forEach{
            (key,value) -> println("key=$key,value=$value")
    }
    //添加
    mutableMap["key3"] = 30
    //修改
    mutableMap["key1"] = 100
    //删除
    mutableMap.remove("key2")
    mutableMap.forEach{
            (key,value) -> println("key=$key,value=$value")
    }
    /*kotlin :集合 collection (list set), map 结束*/

    /*kotlin :OOP 类   封装  继承 多态 接口 开始*/
    //类..................
    println("====================")
    val person = Person("fy",40,"男")
    person.study()

    //继承 多态,open : override
    val student = Student("fy",40,gender = "男")
    student.study()

    //接口
    student.getMoney()
    student.setMoney()
    /*kotlin :OOP 类   封装  继承 多态 接口 结束*/
}