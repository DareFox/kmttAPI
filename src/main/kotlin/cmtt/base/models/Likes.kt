package cmtt.base.models

import kotlinx.serialization.json.JsonNames

/**
 *
 *
 * @param summ
 * @param counter
 * @param isLiked Значения лайка:   * `-1` - дизлайк   * `0` - нет значения   * `1` - лайк
 */

data class Likes(

    @JsonNames("summ")
    val summ: Int? = null,

    @JsonNames("counter")
    val counter: Int? = null,

    /* Значения лайка:   * `-1` - дизлайк   * `0` - нет значения   * `1` - лайк  */
    @JsonNames("isLiked")
    val isLiked: Likes.IsLiked? = null

) {

    /**
     * Значения лайка:   * `-1` - дизлайк   * `0` - нет значения   * `1` - лайк
     *
     * Values: minus1,_0,_1
     */
    enum class IsLiked(val value: Int) {
        @JsonNames("-1")
        minus1(-1),

        @JsonNames("0")
        _0(0),

        @JsonNames("1")
        _1(1);
    }
}

