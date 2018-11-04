class IsbnVerifier {
    fun isValid(text: String): Boolean {
        return text.toLowerCase()
                .replace("-", "")
                .apply { if (length != 10) return false }
                .apply { if (!Regex("""^[\d]+x?""").matches(this)) return false }
                .split("")
                .filter { !it.isEmpty() }
                .map { if (it == Character.toString('x')) 10 else it.toInt() }
                .mapIndexed { index, it -> (10 - index) * it }
                .sum() % 11 == 0
    }
}
