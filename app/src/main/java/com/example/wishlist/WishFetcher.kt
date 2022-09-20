package com.example.wishlist

class WishFetcher {
    companion object {
        val wishName = listOf(
            "New Lamp",
            "New Computer",
            "New Dress"
        )
        val wishPrice = listOf(
            "20.99",
            "3189,99",
            "200.00"
        )
        val wishURL = listOf(
            "https://courses.codepath.org/courses/",
            "https://juejin.cn/pos",
            "https://www.techinterviewhandbook.org/grind75"
        )
        fun getEmails(): ArrayList<Wish> {
            var wishes: ArrayList<Wish> = ArrayList()
            for (i in 0..2) {
                val wish = Wish(wishName[i], wishPrice[i], wishURL[i])
                wishes.add(wish)
            }
            return wishes
        }
    }
}