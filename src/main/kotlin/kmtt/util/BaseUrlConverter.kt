package kmtt.util

import kmtt.base.models.enums.Website

fun Website.apiURL(version: String = "1.9"): String = "https://api.${this.baseURL}/$version"
