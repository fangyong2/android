class DVDBean {
    //名称
    var name: String? = ""

    //状态
    var state: Int? = 1

    //日期
    var date: Int? = 0

    //次数
    var count: Int? = 0


    constructor(name: String?, state: Int?, date: Int?, count: Int?) {
        this.name = name
        this.state = state
        this.date = date
        this.count = count
    }
}