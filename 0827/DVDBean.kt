class DVDBean {
    //名称
    var name: String? = null

    //状态
    var state: Int? = null

    //日期
    var date: Int? = null

    //次数
    var count: Int? = null

    constructor(name: String?, state: Int?, date: Int?, count: Int?) {
        this.name = name
        this.state = state
        this.date = date
        this.count = count
    }
}