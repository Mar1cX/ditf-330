class Isogram {
    fun isIsogram(text: String): Boolean {
        return Regex("[^A-Za-z0-9]").replace(text, "")
                .toLowerCase()
                .groupingBy { it }
                .eachCount()
                .values
                .any { it > 1 }
                .not()
    }
}
