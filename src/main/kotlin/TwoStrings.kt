class SubstringFinder {

    fun find(str1: String?, str2: String?): Boolean {
        if((str1 == null) || (str2 == null)){
            throw IllegalArgumentException()
        }
        val str2Set = str2.toSet()
        str1.toCharArray().toList().forEach {
            if (str2Set.contains(it)) {
                return true
            }
        }
        return false
    }
}