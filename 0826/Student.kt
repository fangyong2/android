class Student(name: String,age:Int,gender:String) : Person(name,age,gender),Money {

    override fun study() {
        super.study()
        println("学生学习！！！")
    }

    override fun setMoney() {
        println("学习是为了更好的赚钱。。。")
    }
}