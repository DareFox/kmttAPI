package kmtt.util

import kmtt.models.enums.Website

internal fun Website.apiURL(version: String = "v1.9"): String = "https://api.${this.baseURL}/$version"
