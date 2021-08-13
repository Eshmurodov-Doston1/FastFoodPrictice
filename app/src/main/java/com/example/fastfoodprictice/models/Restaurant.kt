package com.example.fastfoodprictice.models

class Restaurant {
    var name:String?=null
    var time:String?=null
    var delivery:String?=null

    constructor(name: String?, time: String?, delivery: String?) {
        this.name = name
        this.time = time
        this.delivery = delivery
    }
}