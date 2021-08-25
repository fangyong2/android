package com.hsbc.myapplication5

class Dvd {
    var name:String = ""
    var state:Int = 1
    var date:Int = 0
    var count:Int = 0

    constructor(name: String, state: Int, date: Int, count: Int) {
        this.name = name
        this.state = state
        this.date = date
        this.count = count
    }
}