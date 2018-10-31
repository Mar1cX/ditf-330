class WordCount {
    fun phrase(text: String): Map<String, Int> {
        return text.toLowerCase()
                .split(Regex("[^A-Za-z0-9']"))
                .filter { !it.isEmpty() }
                .map { it.removeSurrounding("'", "'") }
                .groupingBy { it }
                .eachCount()
    }
}