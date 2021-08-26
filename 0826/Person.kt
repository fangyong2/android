//open ~~ abstract
open class Person {
    //属性
    private var name:String = ""
        get() = field.lowercase()
        set(value) = if(value==null){field="fangyong"}else{field=value}
    private var age:Int =0
    private var gender:String = "男"

    //构造器（第一）==静态块 static{}
    init {
        println("init.............")
    }

    //构造器（第二）
    constructor(name: String, age: Int, gender: String) {
        this.name = name
        this.age = age
        this.gender = gender
        println("constructor.............")
    }


    //方法
    open fun study(){
        println("study.........")
    }
}