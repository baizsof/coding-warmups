import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SubstringFinderTest {
    lateinit var substringFinder: SubstringFinder

    @BeforeEach
    fun setUp() {
        substringFinder = SubstringFinder()
    }

    @ParameterizedTest
    @CsvSource(value = ["null|asdasd", "foo|null", "null|null"], delimiter = '|', nullValues = ["null"])
    fun `given null strings, when strings does not have substrings, then IllegalArgumentException is thrown`(str1: String?, str2: String?) {
        assertThrows(IllegalArgumentException::class.java) {
            substringFinder.find(str1, str2)
        }
    }

    @ParameterizedTest
    @CsvSource(value = ["nosubstring|yeah", "hell|noway"], delimiter = '|')
    fun `given not null strings, when strings does not have substrings, then false returned`(
        str1: String, str2: String
    ) {
        assertFalse(substringFinder.find(str1, str2))
    }

    @ParameterizedTest
    @CsvSource(value = ["foo|barf", "somecommunity|cdecdecdecde", "jackandjill|wentupthehill"], delimiter = '|')
    fun `given not null short strings, when strings does have substrings, then true returned`(str1: String, str2: String) {
        assertTrue(substringFinder.find(str1, str2))
    }
}