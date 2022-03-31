package kmtt.base.models.enums

import kotlinx.serialization.SerialInfo

enum class SortingType(val typeValue: String) {
    ByDate("date"),
    Popular("popular")
}