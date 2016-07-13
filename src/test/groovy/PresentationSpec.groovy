import spock.lang.Specification

/**
 * @author Jeremy Mefford
 * @since 7/12/16
 */
class PresentationSpec extends Specification {

    def "java should still min properly"() {
        expect:
        Math.min(a, b) == c

        where:
        a  | b  | c
        1  | 2  | 1
        2  | 3  | 2
        3  | 1  | 1
        -1 | 12 | -1
    }

    def "mocks are fantastic"() {
        given:
        def weirdNumber = Mock(Number)

        when:
        def longVal = weirdNumber.longValue()
        def intVal = weirdNumber.intValue()

        then:
        1 * weirdNumber.longValue() >> 100L
        1 * weirdNumber.intValue() >> 42L

        and:
        longVal == 100L
        intVal == 42
    }

    def "complicated mock"() {
        given:
        def weirdNumber = Mock(Number)

        when:
        def val1 = weirdNumber.longValue()
        def val2 = weirdNumber.longValue()

        then:
        2 * weirdNumber.longValue() >>> [100L, 25L, { throw new RuntimeException() }]

        and:
        val1 == 100L
        val2 == 25L
    }

}
