package chirikualii.com.footballapps.common

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by chirikualii on 11/8/18
 * github.com/chirikualii
 */
class UtillsTest {
    @Test
    fun toDate() {
        val date = "2018-02-10"
        assertEquals("Feb 10, 2018", date.toDate())
    }
}